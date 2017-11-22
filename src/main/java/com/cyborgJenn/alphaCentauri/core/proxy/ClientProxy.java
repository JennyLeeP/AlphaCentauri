package com.cyborgJenn.alphaCentauri.core.proxy;

import com.cyborgJenn.alphaCentauri.core.handlers.EventHandlerEntity;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.util.BlockColorHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
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
	public static void registerModels(RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new ItemBlock(ModBlocks.acStone).setRegistryName(ModBlocks.acStone.getRegistryName()));
	}

	@Override
	public World getClientWorld() 
	{
		return FMLClientHandler.instance().getClient().world;
	}
}
