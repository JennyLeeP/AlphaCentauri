package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenSplotchTree;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenPrimevalForest extends ACBiome
{
	private WorldGenSplotchTree SPLOTCH_TREE = new WorldGenSplotchTree();
	public BiomeGenPrimevalForest(BiomeProperties biomeprops) 
	{
		super(biomeprops);
		this.customBiomeDecorator.treesPerChunk = 1;
		this.customBiomeDecorator.grassPerChunk = 4;
		this.customBiomeDecorator.flowersPerChunk = 10;
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.ACGRASS.getDefaultState();
		this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();

		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	@Override
	public WorldGenBaseTree getRandomTreeFeature(Random rand)
	{ 
		return SPLOTCH_TREE; 
	}
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x5c96c9;// Nice Blue color.
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
