package com.cyborgJenn.alphaCentauri.module.dimension.util;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.world.ACWorldProvider;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.DimensionType;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Registry 
{
    public static DimensionType DIMENSION;

	private static void registerTileEntities() 
	{

	}
	public static void registerDimensionTypes() 
	{
		DIMENSION = DimensionType.register(Reference.MODID, "_alphacentauri", Config.dimensionID, ACWorldProvider.class, false);
    }
	public static void registerDimension()
	{
		DimensionManager.registerDimension(Config.dimensionID, DIMENSION);
	}
	
	public static void blockModelRegister(Block block)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}

