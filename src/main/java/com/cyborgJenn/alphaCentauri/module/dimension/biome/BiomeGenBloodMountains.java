package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenBloodMountains extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	
	public BiomeGenBloodMountains(Biome.BiomeProperties properties) {
		super(properties);
        //this.rootHeight = -0.5F;
       // this.heightVariation = 0.1F;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        //this.setTemperatureRainfall(0.2F, 0.3F);
        //this.waterColorMultiplier = 8900670;
        theBiomeDecorator = new ACBiomeDecorator(this);
        customBiomeDecorator = (ACBiomeDecorator)theBiomeDecorator;
        
        this.customBiomeDecorator.treesPerChunk = 7;
        this.customBiomeDecorator.nodesPerChunk = 1;
        this.customBiomeDecorator.grassPerChunk = 5;
        
	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.redGravel.getDefaultState();
            this.fillerBlock = ModBlocks.redGravel.getDefaultState();

            this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
