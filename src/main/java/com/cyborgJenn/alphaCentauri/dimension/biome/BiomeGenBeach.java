package com.cyborgJenn.alphaCentauri.dimension.biome;

import com.cyborgJenn.alphaCentauri.blocks.BlockACGravel;
import com.cyborgJenn.alphaCentauri.blocks.BlockACSand;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.world.biome.Biome;

public class BiomeGenBeach extends ACBiome
{
	public BiomeGenBeach(Biome.BiomeProperties properties) 
	{
		super(properties);
		this.topBlock = ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.DARK);
        this.fillerBlock = ModBlocks.GRAVEL.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.PURPLE);    
	}
}
