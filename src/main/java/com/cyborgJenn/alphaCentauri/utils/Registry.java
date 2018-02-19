package com.cyborgJenn.alphaCentauri.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cyborgJenn.alphaCentauri.dimension.world.ACWorldProvider;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.registries.IForgeRegistryEntry;

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

