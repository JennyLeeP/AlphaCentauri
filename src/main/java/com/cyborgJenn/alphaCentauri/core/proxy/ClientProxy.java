package com.cyborgJenn.alphaCentauri.core.proxy;

import com.cyborgJenn.alphaCentauri.core.handlers.EventHandlerEntity;
import com.cyborgJenn.alphaCentauri.core.handlers.WorldEventHandler;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.biome.ModBiomes;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.util.BlockColorHandler;
import com.cyborgJenn.alphaCentauri.module.dimension.util.DimensionEntityHandler;
import com.cyborgJenn.alphaCentauri.module.dimension.util.OreDictionary;
import com.cyborgJenn.alphaCentauri.module.dimension.util.Registry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e) 
	{
		super.preInit(e);
		MinecraftForge.EVENT_BUS.register(new EventHandlerEntity());
		if(Config.enableModuleDimension)
		{
			//MinecraftForge.EVENT_BUS.register(DimensionEntityHandler.class);
		}
	}
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		if(Config.enableModuleDimension)
		{
			BlockColorHandler.registerColorHandlers();
		}
	}
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{

	}

	@Override
	public World getClientWorld() 
	{
		return FMLClientHandler.instance().getClient().world;
	}
}
