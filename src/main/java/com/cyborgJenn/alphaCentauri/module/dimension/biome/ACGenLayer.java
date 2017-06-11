package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class ACGenLayer extends GenLayer {


	public ACGenLayer(long seed) 
	{
		super(seed);
	}
	public static GenLayer[] initializeAllBiomeGenerators(long seed) 
	{

		GenLayer genlayer = new ACGenLayerBiomes(1L);

		// more GenLayerZoom = bigger biomes
		genlayer = new GenLayerZoom(1000L, genlayer);
		genlayer = new GenLayerZoom(1001L, genlayer);
		genlayer = new GenLayerZoom(1002L, genlayer);
		genlayer = new GenLayerZoom(1003L, genlayer);
		genlayer = new GenLayerZoom(1004L, genlayer);
		genlayer = new GenLayerZoom(1005L, genlayer);




		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayer);

		genlayer.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		return new GenLayer[] {genlayer, genlayervoronoizoom};
	}

}
