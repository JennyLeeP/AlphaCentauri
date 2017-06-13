package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenBaseTree implements IWorldGenerator
{
	private final boolean doBlockNotify;
	public WorldGenBaseTree()
	{
		this(false);
	}
	public WorldGenBaseTree(boolean notify)
    {
        this.doBlockNotify = notify;
    }
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		
	}
	
	public void generateTree(World world, Random rand, BlockPos pos)
	{
		
	}
	
	protected void setBlockAndNotifyAdequately(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.doBlockNotify)
        {
            worldIn.setBlockState(pos, state, 3);
        }
        else
        {
            worldIn.setBlockState(pos, state, 2);
        }
    }
	protected void setDirt(World worldIn, IBlockState block, BlockPos pos)
	{
		if (block == ModBlocks.acGrass.getDefaultState())
		{
			worldIn.setBlockState(pos.down(), ModBlocks.acDirt.getDefaultState());
		}
		else if(block == Blocks.GRASS.getDefaultState())
		{
			worldIn.setBlockState(pos.down(), Blocks.DIRT.getDefaultState());
		}
	}
	protected boolean isValidLocation(World worldIn, BlockPos pos, boolean islargetree)
	{
		//TODO check if location is valid for tree
		return true;
		
	}
	/**
     * grow leaves in a circle
     */
    protected void growLeavesCircular(World worldIn, BlockPos layerCenter, int width, IBlockState leafBlock)
    {
        int i = width * width;

        for (int j = -width; j <= width; ++j)
        {
            for (int k = -width; k <= width; ++k)
            {
                if (j * j + k * k <= i)
                {
                    BlockPos blockpos = layerCenter.add(j, 0, k);
                    IBlockState state = worldIn.getBlockState(blockpos);

                    if (state.getBlock().isAir(state, worldIn, blockpos) || state.getBlock().isLeaves(state, worldIn, blockpos))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, blockpos, leafBlock);
                    }
                }
            }
        }
    }
}
