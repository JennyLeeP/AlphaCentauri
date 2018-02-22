package com.cyborgJenn.alphaCentauri.utils;

import com.cyborgJenn.alphaCentauri.dimension.world.ACWorldProvider;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class Registry 
{
    public static DimensionType DIMENSION;

	public static void registerDimensionTypes() 
	{
		DIMENSION = DimensionType.register(Reference.MODID, "_alphacentauri", Config.dimensionID, ACWorldProvider.class, false);
    }
	public static void registerDimension()
	{
		DimensionManager.registerDimension(Config.dimensionID, DIMENSION);
	}
}

