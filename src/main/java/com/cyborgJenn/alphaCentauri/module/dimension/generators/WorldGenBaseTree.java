package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenBaseTree implements IWorldGenerator
{
	private final boolean doBlockNotify;
	protected final World world;
	protected Random rand = new Random();
	protected final BlockPos pos;

	public WorldGenBaseTree(boolean notify, World world, BlockPos pos)
    {
        this.doBlockNotify = notify;
        this.world = world;
        this.pos = pos;
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
	 * Grows Leaves in a Circular pattern. 
	 * Good for trees with a trunk 1 block in width.
	 * @param worldIn
	 * @param layerCenter
	 * @param width
	 * @param leafBlock
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
    /**
     * Grow leaves in a circle with the outside being within the circle.
     * Good for trees with a trunk 2 blocks in width.
     * @param worldIn
     * @param layerCenter
     * @param width
     * @param leafBlock
     */
    protected void growLeavesCircularStrict(World worldIn, BlockPos layerCenter, int width, IBlockState leafBlock)
    {
        int i = width * width;

        for (int j = -width; j <= width + 1; ++j)
        {
            for (int k = -width; k <= width + 1; ++k)
            {
                int l = j - 1;
                int i1 = k - 1;

                if (j * j + k * k <= i || l * l + i1 * i1 <= i || j * j + i1 * i1 <= i || l * l + k * k <= i)
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
    /**
     * returns whether or not a tree can grow into a block
     * For example, a tree will not grow into stone
     */
    protected boolean canGrowInto(Block blockType)
    {
        Material material = blockType.getDefaultState().getMaterial();
        return material == Material.AIR || material == Material.LEAVES || blockType == Blocks.GRASS 
        		|| blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 
        		|| blockType == Blocks.SAPLING || blockType == Blocks.VINE || blockType == ModBlocks.vines 
        		|| blockType == ModBlocks.SAPLINGS1 || blockType == ModBlocks.LOG1 || blockType == ModBlocks.acGrass 
        		|| blockType == ModBlocks.acDirt;
    }
    
    /**
     * Sets the block in the world based on coordinates relative to base of the trunk of the tree. Positions assumed as no change for east facing
     * @param worldIn
     * @param blockStateIn
     * @param x
     * @param y
     * @param z
     * @param direction
     */
    protected void setRelativeBlockState(World worldIn, IBlockState blockStateIn, int x, int y, int z, EnumFacing direction)
    {
    	BlockPos blockPos = new BlockPos(this.getXWithOffset(x,z,direction),this.getYWithOffset(y), this.getZWithOffset(x, z, direction));
    	
    	setBlockAndNotifyAdequately(worldIn, blockPos, blockStateIn);
    }
    
    private int getXWithOffset(int x, int z, EnumFacing direction)
    {
		switch(direction)
		{
		case NORTH:
			return pos.getX() + z;
		case SOUTH:
			return pos.getX() - z;
		case EAST:
			return pos.getX() + x;
		case WEST:
			return pos.getX() + x;
		default:
			return x;
		}    	
    }
    private int getYWithOffset(int y)
    {
		return pos.getY() + y;
    	
    }
    private int getZWithOffset(int x, int z, EnumFacing direction)
    {
    	switch(direction)
		{
		case NORTH:
			return pos.getZ() - x;
		case SOUTH:
			return pos.getZ() + x;
		case EAST:
			return pos.getZ() + z;
		case WEST:
			return pos.getZ() + z;
		default:
			return z;
		}  
    }
}
