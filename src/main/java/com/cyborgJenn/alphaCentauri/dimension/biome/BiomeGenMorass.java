package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;


public class BiomeGenMorass extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	
	public BiomeGenMorass(Biome.BiomeProperties properties) {
		super(properties);
        //this.rootHeight = -0.5F;
        //this.heightVariation = 0.1F;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        biomeDecorator = new ACBiomeDecorator(this);
        customBiomeDecorator = (ACBiomeDecorator)biomeDecorator;
        
        this.customBiomeDecorator.treesPerChunk = 7;
        this.customBiomeDecorator.nodesPerChunk = 1;
        this.customBiomeDecorator.grassPerChunk = 5;
        this.customBiomeDecorator.methIcePerChunk = 4;

	}
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.PEAT.getDefaultState();
            this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();

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
    /**
     * Gets a WorldGen appropriate for this biome. Use this method to add World Gen items to certain Biomes.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return null;
    	//return (WorldGenerator)(par1Random.nextInt(10) == 4 ? new WorldGenMangroveTrees(false) : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenBrilliantTrees(false) : new WorldGenMangroveTrees(true))));
    }
    @Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x33fffa;
		//return 0x5D8F92; nice
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xa64dff;
	}
}
