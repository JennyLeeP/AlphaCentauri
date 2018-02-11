package com.cyborgJenn.alphaCentauri.dimension.biome;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class ACGenLayerBiomes extends GenLayer {


	protected Biome[] allowedBiomes = {ModBiomes.LUSHHILLS, ModBiomes.GREENRIVER, ModBiomes.BEACH, ModBiomes.PAINTED_CLIFFS,
			ModBiomes.LIVINGPLATEAU, ModBiomes.Mangroves, ModBiomes.Morass, ModBiomes.PrimevalForest, ModBiomes.HOODOOVALLEY, ModBiomes.VioletBoscage,ModBiomes.DESERT};



	public ACGenLayerBiomes(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;

	}
	public ACGenLayerBiomes(long seed) {
		super(seed);
	}


	@Override
	public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
		int[] dest = IntCache.getIntCache(areaWidth * areaHeight);

		for (int i = 0; i < areaHeight; ++i)
		{
			for (int j = 0; j < areaWidth; ++j)
			{
				this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
				//dest[j + i * areaWidth] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
				dest[j + i * areaWidth] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;

	}

}
