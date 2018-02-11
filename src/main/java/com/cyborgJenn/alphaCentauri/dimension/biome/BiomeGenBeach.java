package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenFossils;

public class BiomeGenBeach extends ACBiome
{
	public BiomeGenBeach(Biome.BiomeProperties properties) 
	{
		super(properties);
		this.topBlock = ModBlocks.darkSand.getDefaultState();
        this.fillerBlock = ModBlocks.purpleGravel.getDefaultState();
        this.spawnableCreatureList.clear();    
	}
	@Override
	public BiomeDecorator createBiomeDecorator()
	{   
		return getModdedBiomeDecorator(new ACBiomeDecorator(this));
	}
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);
    }
}
