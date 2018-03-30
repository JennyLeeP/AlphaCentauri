package com.cyborgJenn.alphaCentauri.dimension.biome;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

public class BiomeGenLivingPlateau extends ACBiome
{
	public BiomeGenLivingPlateau(BiomeProperties biomeprops) 
	{
		super(biomeprops);
        this.topBlock = ModBlocks.ACGRASS.getDefaultState();
        this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
        
	}
}
