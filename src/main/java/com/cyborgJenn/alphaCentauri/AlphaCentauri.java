package com.cyborgJenn.alphaCentauri;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.command.TeleportCommand;
import com.cyborgJenn.alphaCentauri.core.network.PacketHandler;
import com.cyborgJenn.alphaCentauri.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.handlers.CyborgEventHandler;
import com.cyborgJenn.alphaCentauri.handlers.EventHandlerEntity;
import com.cyborgJenn.alphaCentauri.handlers.WorldEventHandler;
import com.cyborgJenn.alphaCentauri.item.ModItems;
import com.cyborgJenn.alphaCentauri.largeCaves.LargeCaveGen;
import com.cyborgJenn.alphaCentauri.proxy.CommonProxy;
import com.cyborgJenn.alphaCentauri.utils.AlphaCentauriTab;
import com.cyborgJenn.alphaCentauri.utils.BlockColorHandler;
import com.cyborgJenn.alphaCentauri.utils.Config;
import com.cyborgJenn.alphaCentauri.utils.DimensionEntityHandler;
import com.cyborgJenn.alphaCentauri.utils.OreDictionary;
import com.cyborgJenn.alphaCentauri.utils.Reference;
import com.cyborgJenn.alphaCentauri.utils.Registry;

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

@Mod(
		modid = Reference.MODID, 
		name = Reference.NAME, 
		version = Reference.VERSION,
		useMetadata = true
		/*dependencies="required-after:Forge@[11.15.0,);"*/)

public class AlphaCentauri {

	@Mod.Instance(value = Reference.MODID)
	public static AlphaCentauri instance;

	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.SERVERPROXY)
	public static CommonProxy proxy;
	public static CreativeTabs 		tabAlphaCentauri = new AlphaCentauriTab(CreativeTabs.getNextID(), "tabAlphaCentauri");
	public static final Logger 		logger = LogManager.getLogger(Reference.NAME);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)throws IOException
	{
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) throws IOException
	{
		if (Config.enableModuleDimension)
		{
			event.registerServerCommand(new TeleportCommand());
		}
	}
}
