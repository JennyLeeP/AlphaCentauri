package com.cyborgJenn.alphaCentauri.proxy;

import com.cyborgJenn.alphaCentauri.dimension.blocks.BlockVanillaOres;
import com.cyborgJenn.alphaCentauri.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.util.BlockColorHandler;
import com.cyborgJenn.alphaCentauri.handlers.EventHandlerEntity;
import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
import net.minecraftforge.fml.relauncher.SideOnly;

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
		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		initClient(mesher);
		BlockColorHandler.registerColorHandlers();
		super.init(event);
	}
	@SubscribeEvent
	public static void registerModels(RegistryEvent.Register<Item> event) 
	{
		
	}
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher) {	
		mesher.register(Item.getItemFromBlock(ModBlocks.ACSTONE), 0, new ModelResourceLocation(ModBlocks.ACSTONE.getRegistryName(), "inventory"));
		for(int i=0; i <= BlockVanillaOres.EnumType.values().length; i++)
		{
			mesher.register(Item.getItemFromBlock(ModBlocks.VANILLA_ORES), i, new ModelResourceLocation(ModBlocks.VANILLA_ORES.getRegistryName(), "inventory"));
		}
		
		
	}
	@Override
	public World getClientWorld() 
	{
		return FMLClientHandler.instance().getClient().world;
	}
}
