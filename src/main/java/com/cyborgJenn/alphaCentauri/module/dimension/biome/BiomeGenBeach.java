package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenBeach extends ACBiome{

	private int field_150644_aH;
	
	public BiomeGenBeach(Biome.BiomeProperties properties) {
		super(properties);
		//this.topBlock = (Block) Blocks.sand;
        //this.fillerBlock = (Block) Blocks.gravel;
        //this.rootHeight = 0.0F;
        //this.heightVariation = 0.1F;
        this.spawnableCreatureList.clear();
        //this.setTemperatureRainfall(0.2F, 0.3F);
        //this.setColor(8900670);
	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.darkSand.getDefaultState();
            this.fillerBlock = ModBlocks.redGravel.getDefaultState();

    		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
}
