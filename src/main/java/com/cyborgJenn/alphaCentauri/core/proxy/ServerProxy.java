package com.cyborgJenn.alphaCentauri.core.proxy;

import java.io.IOException;

import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.module.dimension.command.TeleportCommand;

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
