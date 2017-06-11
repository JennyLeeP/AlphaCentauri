package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenLivingPlateau extends ACBiome{

	public BiomeGenLivingPlateau(BiomeProperties biomeProperties) {
		super(biomeProperties);
        //this.rootHeight = 2.0F;
        //this.heightVariation = 0.0F;
        this.spawnableCreatureList.clear();
        //this.setTemperatureRainfall(0.2F, 0.3F);
        //this.setColor(8900670);
	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.lightSand.getDefaultState();
            this.fillerBlock = ModBlocks.marble.getDefaultState();

            this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
