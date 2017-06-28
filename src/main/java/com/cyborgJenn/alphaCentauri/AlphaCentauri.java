package com.cyborgJenn.alphaCentauri;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cyborgJenn.alphaCentauri.core.handlers.CyborgEventHandler;
import com.cyborgJenn.alphaCentauri.core.handlers.EventHandlerEntity;
import com.cyborgJenn.alphaCentauri.core.handlers.WorldEventHandler;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.core.network.PacketHandler;
import com.cyborgJenn.alphaCentauri.core.proxy.CommonProxy;
import com.cyborgJenn.alphaCentauri.core.utils.AlphaCentauriTab;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.ListEntities;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.commands.CommandHeal;
import com.cyborgJenn.alphaCentauri.module.commands.CommandKill;
import com.cyborgJenn.alphaCentauri.module.commands.CommandKillall;
import com.cyborgJenn.alphaCentauri.module.commands.CommandTps;
import com.cyborgJenn.alphaCentauri.module.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.command.TeleportCommand;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBaseTree;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.trees.WorldGenSpiralTree;
import com.cyborgJenn.alphaCentauri.module.dimension.util.BlockColorHandler;
import com.cyborgJenn.alphaCentauri.module.dimension.util.Registry;
import com.cyborgJenn.alphaCentauri.module.largeCaves.LargeCaveGen;
import com.cyborgJenn.alphaCentauri.module.motd.CommandMotd;
import com.cyborgJenn.alphaCentauri.module.motd.Motd;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
		modid = Reference.MODID, 
		name = Reference.NAME, 
		version = Reference.VERSION,
		dependencies="required-after:Forge@[11.15.0,);")

public class AlphaCentauri {

	@Instance(value = Reference.MODID)
	public static AlphaCentauri instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.SERVERPROXY)
	public static CommonProxy proxy;

	public static CreativeTabs 		tabAlphaCentauri = new AlphaCentauriTab(CreativeTabs.getNextID(), "tabAlphaCentauri");
	public static final Logger 		logger = LogManager.getLogger(Reference.NAME);
	public static int 				dimension;
	public static LargeCaveGen 		caveGen;
	public static Minecraft         minecraft;
	public static MinecraftServer 	server;
	public static boolean 			firstStart = true;
	private static Path 			configDir;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)throws IOException
	{
		event.getModMetadata().version = Reference.VERSION;
		Config.init(event.getSuggestedConfigurationFile());

		File modConfigDir = event.getModConfigurationDirectory();
		configDir = modConfigDir.toPath().resolve("AlphaCentauri");
		Files.createDirectories(configDir);

		PacketHandler.init();
		MinecraftForge.EVENT_BUS.register(new EventHandlerEntity());
		MinecraftForge.EVENT_BUS.register(new CyborgEventHandler());
		if (Config.enableModuleLargeCaves)
		{
			caveGen = new LargeCaveGen(); 
			MinecraftForge.TERRAIN_GEN_BUS.register(new CyborgEventHandler()); 
		}
		if(Config.enableModuleDimension)
		{
			ModBlocks.init();
			ModBiomes.initBiomes();
		}
		logger.info("Pre Init Complete..........");
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		if(Config.enableModuleAccessories)
		{
			ModItems.initAccessoryItems();
			ModItems.registerAccessoryItems();
			proxy.registerAccessoryRenderers();
			proxy.registerKeyBindings();
			proxy.registerHudRenderer();
		}
		if(Config.enableModuleCombat)
		{
			ModItems.initCombatItems();
			ModItems.registerCombatItems();
			proxy.registerCombatRenderers();
		}
		if(Config.enableModuleDimension)
		{
			Registry.registerDimensionTypes();
			Registry.registerDimension();
			proxy.registerDimensionRenderers();
			BlockColorHandler.registerColorHandlers();
			MinecraftForge.TERRAIN_GEN_BUS.register(new WorldEventHandler());//TODO confirm necessary.
			GameRegistry.registerWorldGenerator(new WorldGenBaseTree(), 0);
		}
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		logger.info("Init Complete.............");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		new ListEntities();
		logger.info("Post Init Complete.............");
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) throws IOException
	{
		server = event.getServer();
		if (Config.enableModuleCommands)
		{
			event.registerServerCommand(new CommandTps());
			event.registerServerCommand(new CommandHeal());
			event.registerServerCommand(new CommandKillall());
			event.registerServerCommand(new CommandKill());
			// TODO fix or remove these Commands.
			//event.registerServerCommand(new CommandInventory());
			// event.registerServerCommand(new CommandSpawn());
			//event.registerServerCommand(new CommandEntity());
			//event.registerServerCommand(new CommandHome());
		}
		if (Config.enableModuleMOTD) 
		{
			//TODO fix Motd save file.
			final Motd motd = new Motd(configDir.resolve("motd.txt"));
			CommandMotd motdCommand = new CommandMotd(motd);
			event.registerServerCommand(motdCommand);
			MinecraftForge.EVENT_BUS.register(motd);
		}
		if (Config.enableModuleDimension)
		{
			event.registerServerCommand(new TeleportCommand());
		}
	}

}
