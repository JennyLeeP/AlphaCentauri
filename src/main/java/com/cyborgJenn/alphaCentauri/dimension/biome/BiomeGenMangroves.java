package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenMangroves extends ACBiome
{
	public BiomeGenMangroves(BiomeProperties biomeProperties) 
	{
		super(biomeProperties);
        //this.rootHeight = -0.5F;
        //this.heightVariation = 0.1F;
        //this.setTemperatureRainfall(0.2F, 0.3F);
        //this.setColor(8900670);
        this.customBiomeDecorator.treesPerChunk = 7;
        this.customBiomeDecorator.nodesPerChunk = 1;
	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.ACGRASS.getDefaultState();
            this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
            this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
