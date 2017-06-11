package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenLivingOcean extends ACBiome{


	public BiomeGenLivingOcean(Biome.BiomeProperties properties)
	{
		super(properties);
		this.spawnableCreatureList.clear();
		
	}

	public Biome.TempCategory getTempCategory()
	{
		return Biome.TempCategory.OCEAN;
	}

	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.blueGravel.getDefaultState();
		this.fillerBlock = ModBlocks.peat.getDefaultState();
		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
}
