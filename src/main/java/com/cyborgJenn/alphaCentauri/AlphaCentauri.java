package com.cyborgJenn.alphaCentauri;


import java.io.IOException;

import org.apache.logging.log4j.Logger;

import com.cyborgJenn.alphaCentauri.command.TeleportCommand;
import com.cyborgJenn.alphaCentauri.proxy.CommonProxy;
import com.cyborgJenn.alphaCentauri.utils.AlphaCentauriTab;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
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
	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)throws IOException
	{
		logger = event.getModLog();
		MinecraftForge.EVENT_BUS.register(proxy);
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.Init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new TeleportCommand());
	}
}
