package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenSpiralTree;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenSpiralForest extends ACBiome{

	private ACBiomeDecorator customBiomeDecorator;
	private WorldGenSpiralTree SPIRAL_TREE = new WorldGenSpiralTree();
	
	public BiomeGenSpiralForest(BiomeProperties biomeProperties) {
		super(biomeProperties);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
		/* Trees and Plants */
		biomeDecorator = new ACBiomeDecorator(this);
		customBiomeDecorator = (ACBiomeDecorator)biomeDecorator;
		this.customBiomeDecorator.treesPerChunk = 7;
		this.customBiomeDecorator.grassPerChunk = 6;
		
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
		this.topBlock = ModBlocks.ACGRASS.getDefaultState();
		this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
		this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
	@Override
	public WorldGenBaseTree getRandomTreeFeature(Random rand)
    { 
		return SPIRAL_TREE; 
    }
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override 
    public BiomeDecorator createBiomeDecorator()
    {   
        return getModdedBiomeDecorator(new ACBiomeDecorator(this));
    }
    @Override
	public int getModdedBiomeGrassColor(int ont)
	{
		//return 0x5c96c9;// Nice Blue color.
		return 0x5D8F92; // nice
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
