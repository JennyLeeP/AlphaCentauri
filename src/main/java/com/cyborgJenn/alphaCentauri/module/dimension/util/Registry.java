package com.cyborgJenn.alphaCentauri.module.dimension.util;

import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.world.ACWorldProvider;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
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
}

