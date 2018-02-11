package com.cyborgJenn.alphaCentauri.proxy;

import java.io.IOException;

import com.cyborgJenn.alphaCentauri.command.TeleportCommand;
import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {
	
	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent event) throws IOException
	{
		if (Config.enableModuleDimension)
		{
			event.registerServerCommand(new TeleportCommand());
		}
	}
}
