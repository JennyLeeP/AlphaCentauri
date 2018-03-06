package com.cyborgJenn.alphaCentauri.dimension.biome;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

public class BiomeGenGreenRiver extends ACBiome{

	public BiomeGenGreenRiver(BiomeProperties properties) 
	{
		super(properties);
        this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.ACGRASS.getDefaultState();
        this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
	}
}
