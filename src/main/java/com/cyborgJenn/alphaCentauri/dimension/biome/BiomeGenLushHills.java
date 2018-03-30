package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenLushHills extends ACBiome{

	public BiomeGenLushHills(BiomeProperties biomeProperties)
	{
		super(biomeProperties);
		this.customBiomeDecorator.treesPerChunk = 10;
		this.customBiomeDecorator.nodesPerChunk = 3;
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.ACGRASS.getDefaultState();
		this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		super.decorate(worldIn, rand, pos);
	}
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x5D8F92;
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
