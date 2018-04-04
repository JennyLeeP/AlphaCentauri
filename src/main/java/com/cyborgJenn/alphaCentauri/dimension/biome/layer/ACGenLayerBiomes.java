package com.cyborgJenn.alphaCentauri.dimension.biome.layer;

import com.cyborgJenn.alphaCentauri.dimension.biome.ModBiomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class ACGenLayerBiomes extends GenLayer 
{
	protected Biome[] allowedBiomes = {ModBiomes.LUSHHILLS, ModBiomes.RIVER, ModBiomes.BEACH, ModBiomes.PAINTED_CLIFFS,
			ModBiomes.LIVINGPLATEAU, ModBiomes.MANGROVES, ModBiomes.Morass, ModBiomes.PRIMEVAL_FOREST, ModBiomes.HOODOOVALLEY, ModBiomes.SPIRAL_FOREST,ModBiomes.DESERT};

	public ACGenLayerBiomes(long seed, GenLayer genlayer) 	
	{
		super(seed);
		this.parent = genlayer;

	}
	public ACGenLayerBiomes(long seed) 
	{
		super(seed);
	}
	@Override
	public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) 
	{
		int[] dest = IntCache.getIntCache(areaWidth * areaHeight);

		for (int i = 0; i < areaHeight; ++i)
		{
			for (int j = 0; j < areaWidth; ++j)
			{
				this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
				dest[j + i * areaWidth] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}

}
