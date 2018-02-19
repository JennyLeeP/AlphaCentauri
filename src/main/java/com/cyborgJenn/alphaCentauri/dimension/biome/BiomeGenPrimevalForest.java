package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenPrimevalForest extends ACBiome
{
	public BiomeGenPrimevalForest(BiomeProperties par1) 
	{
		super(par1);
		this.spawnableCreatureList.clear();
		//this.setTemperatureRainfall(0.2F, 0.3F);
		//this..setColor(8900670);
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
	{      
		this.topBlock = ModBlocks.acGrass.getDefaultState();
		this.fillerBlock = ModBlocks.acDirt.getDefaultState();

		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
	}
	@Override
	public BiomeDecorator createBiomeDecorator()
	{   
		return getModdedBiomeDecorator(new ACBiomeDecorator(this));
	}
}
