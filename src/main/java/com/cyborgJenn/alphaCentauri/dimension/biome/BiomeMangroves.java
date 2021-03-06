package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACSand;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.cyborgJenn.alphaCentauri.dimension.generators.trees.WorldGenMangroveTree;

import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeMangroves extends ACBiome
{
	private WorldGenMangroveTree MANGROVE_TREE = new WorldGenMangroveTree();
	public BiomeMangroves(BiomeProperties biomeProperties) 
	{
		super(biomeProperties);
        this.customBiomeDecorator.treesPerChunk = 7;
	}
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {      
            this.topBlock = ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.LIGHT);
            this.fillerBlock = ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.MEDIUM);
            this.generateCustomeBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
	@Override
	public WorldGenBaseTree getRandomTreeFeature(Random rand)
	{ 
		return MANGROVE_TREE; 
	}
	@Override
	public int getModdedBiomeGrassColor(int ont)
	{
		return 0x22e2ac;
	}
	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return 0xad5cc9;
	}
}
