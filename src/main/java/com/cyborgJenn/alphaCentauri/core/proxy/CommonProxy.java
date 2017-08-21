package com.cyborgJenn.alphaCentauri.core.proxy;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.handlers.CyborgEventHandler;
import com.cyborgJenn.alphaCentauri.core.handlers.WorldEventHandler;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.util.Registry;
import com.cyborgJenn.alphaCentauri.module.largeCaves.LargeCaveGen;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

	public static LargeCaveGen 		caveGen;
	
	public void preInit(FMLPreInitializationEvent event)
	{
		event.getModMetadata().version = Reference.VERSION;
		Config.init(event.getSuggestedConfigurationFile());
		
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
		AlphaCentauri.logger.info("Pre Init Complete..........");
    }

    public void init(FMLInitializationEvent e) 
    {
    	if(Config.enableModuleCombat)
		{
			ModItems.initCombatItems();
		}
		if(Config.enableModuleDimension)
		{
			Registry.registerDimensionTypes();
			Registry.registerDimension();
			//OreDictionary.registerOres();
		}
		AlphaCentauri.logger.info("Init Complete.............");
    }

    public void postInit(FMLPostInitializationEvent e) 
    {
    	AlphaCentauri.logger.info("Post Init Complete.............");
    }
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(ModBlocks.acStone);
		/*
		event.getRegistry().register(ModBlocks.acDirt);
		event.getRegistry().register(ModBlocks.acCobble);
		event.getRegistry().register(ModBlocks.basalt);
		event.getRegistry().register(ModBlocks.BLOCK_MUSHROOM_PURPLE);
		event.getRegistry().register(ModBlocks.BLOCK_MUSHROOM_BLUE);
		event.getRegistry().register(ModBlocks.BLUE_MUSHROOM);
		event.getRegistry().register(ModBlocks.FLOWERS1);
		event.getRegistry().register(ModBlocks.FUNGUS);
		event.getRegistry().register(ModBlocks.GRAVEL);
		event.getRegistry().register(ModBlocks.LOG1);
		event.getRegistry().register(ModBlocks.MOSS);
		event.getRegistry().register(ModBlocks.ORE_VANILLA);
		event.getRegistry().register(ModBlocks.ORE_VANITEM);
		event.getRegistry().register(ModBlocks.ORE_ALPHACE);
		event.getRegistry().register(ModBlocks.PLANTS1);
		event.getRegistry().register(ModBlocks.PLANKS1);
		event.getRegistry().register(ModBlocks.PURPLE_MUSHROOM);
		event.getRegistry().register(ModBlocks.SAND);
		event.getRegistry().register(ModBlocks.SANDSTONE);
		event.getRegistry().register(ModBlocks.SAPLINGS1);
		*/
		
		/*             Mod Support Blocks                 */
		//event.getRegistry().register(ModBlocks.ORE_THERMAL);
		//event.getRegistry().register(ModBlocks.ORE_PROJRED);
		//event.getRegistry().register(ModBlocks.ORE_TECHREB);
		//event.getRegistry().register(ModBlocks.ORE_APPLIED);
		//event.getRegistry().register(ModBlocks.ORE_BIGREAC);
		//event.getRegistry().register(ModBlocks.ORE_RAILCRA);
		//event.getRegistry().register(ModBlocks.ORE_FORESTY);
		//event.getRegistry().register(ModBlocks.ORE_MFFFFFS);
		//event.getRegistry().register(ModBlocks.ORE_DEEPRES);
		AlphaCentauri.logger.info("Block Register Complete.............");
	}
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		
    }
	public World getClientWorld() {
		return null;
	}
}
