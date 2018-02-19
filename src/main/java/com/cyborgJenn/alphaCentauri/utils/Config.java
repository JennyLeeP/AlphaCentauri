package com.cyborgJenn.alphaCentauri.utils;

import java.io.File;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config 
{
	/* Commands */
	public static boolean 	requireOpTps;
	public static boolean 	requireOpKillSelf;
	public static boolean 	requireOpSpawn;
	/* Debug Options */
	public static boolean 	enableDebugging;
	public static boolean 	enableStructureDebug;
	public static boolean 	forceOres;
	/* Dimension Options */
	public static int       dimensionID;
    public static boolean   enableTreeParticles = true;
	
		
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		try
		{
			config.load();
			configCommandsOptions(config);
			configDebugOptions(config);
			configDimensionOptions(config);
		}
		catch (Exception e)
		{
			AlphaCentauri.logger.fatal("AlphaCentauri has had a problem loading its configuration file", new Object[0],e);
		}
		finally
		{
			if (config.hasChanged()) {
				config.save();
			}
		}
	}
	private static void configCommandsOptions(Configuration config)
	{
		String commandsOptions 		= "Command Options";
		config.addCustomCategoryComment(commandsOptions, "Permissions and related settings for commands, as part of the command module.");
		requireOpTps 		= config.get(commandsOptions, "require Op Tps",       true).getBoolean(true);
		requireOpKillSelf 	= config.get(commandsOptions, "require Op Kill Self", true).getBoolean(true);
		requireOpSpawn 		= config.get(commandsOptions, "require Op Spawn",     true).getBoolean(true);
	} 
	private static void configDebugOptions(Configuration config){
		String debug = "Dev Debug Options";
		config.addCustomCategoryComment(debug, "Use these settings to Enable Dev Debug Options");
		enableDebugging 		= config.get(debug, "enable Debugging", false).getBoolean();
		enableStructureDebug 	= config.get(debug, "enableStructureDebug", false).getBoolean();
		forceOres               = config.get(debug, "forceOres", false).getBoolean();;

	}
	private static void configDimensionOptions(Configuration config)
	{
		String dimension        = "Dimension";
		config.addCustomCategoryComment(dimension, "These settings are for the dimension module.");
		dimensionID             = config.get(dimension, "Dimension ID", 444).getInt();
	}
	
	private static void configParticles(Configuration config) {
    	Property particles = config.get("Particle Settings", "enableTreeParticles", enableTreeParticles);
    	enableTreeParticles = particles.getBoolean(enableTreeParticles);
    	
    	config.addCustomCategoryComment("Particle Settings", "Set this to false if your computer cannot handle lots of particles.");
    }
}
