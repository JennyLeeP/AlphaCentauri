package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.dimension.blocks.ModBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenVioletBoscage extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	private WorldGenTrees worldGeneratorTrees;
	
	public BiomeGenVioletBoscage(BiomeProperties biomeProperties) {
		super(biomeProperties);
		
		//this.rootHeight = 1.0F;// -2 to 2
		//this.heightVariation = 2.0F;
		//this.temperature = 0.2F;
		//this.rainfall = 0.3F;
		//this.enableRain = true;
		//this.waterColorMultiplier = 8900670;
		/* Entities and Animals */
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		/* Trees and Plants */
		biomeDecorator = new ACBiomeDecorator(this);
		customBiomeDecorator = (ACBiomeDecorator)biomeDecorator;
		this.worldGeneratorTrees = new WorldGenTrees(false);
		this.customBiomeDecorator.treesPerChunk = 7;
		this.customBiomeDecorator.nodesPerChunk = 3;
		this.customBiomeDecorator.sandPatchesPerChunk = 4;
		//this.customBiomeDecorator.sandPerChunk2 = 4;
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
		this.topBlock = ModBlocks.acGrass.getDefaultState();
		this.fillerBlock = ModBlocks.acDirt.getDefaultState();

		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
	
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator()
    {   
        return getModdedBiomeDecorator(new ACBiomeDecorator(this));
    }
    
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return this.worldGeneratorTrees;
    }
    /**
     * Gets a WorldGen appropriate for this biome. Use this method to add World Gen items to certain Biomes.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return null;
    	//return (WorldGenerator)(par1Random.nextInt(10) == 4 ? new WorldGenMangroveTrees(false) : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenBrilliantTrees(false) : new WorldGenMangroveTrees(true))));
    }
}
