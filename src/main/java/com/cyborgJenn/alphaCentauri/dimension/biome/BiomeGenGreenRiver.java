package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenGreenRiver extends ACBiome{

	public BiomeGenGreenRiver(BiomeProperties properties) 
	{
		super(properties);
        this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.ACGRASS.getDefaultState();
        this.fillerBlock = ModBlocks.ACDIRT.getDefaultState();
	}
    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    @Override
    public BiomeDecorator createBiomeDecorator()
    {   
        return getModdedBiomeDecorator(new ACBiomeDecorator(this));
    }
    /*
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return this.worldGeneratorTrees;
    }
    */
    /**
     * Gets a WorldGen appropriate for this biome. Use this method to add World Gen items to certain Biomes.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return null;
    	//return (WorldGenerator)(par1Random.nextInt(10) == 4 ? new WorldGenMangroveTrees(false) : (par1Random.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (par1Random.nextInt(3) == 0 ? new WorldGenBrilliantTrees(false) : new WorldGenMangroveTrees(true))));
    }
    @Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        super.decorate(worldIn, rand, pos);
    }
}
