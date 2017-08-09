package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.List;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.common.IWorldGenerator;

public abstract class WorldGenBaseTree extends WorldGenAbstractTree implements IWorldGenerator
{
	//protected final BlockPos pos;

	public WorldGenBaseTree(boolean notify)
    {
        super(notify);
    }
	
	@Override
	protected void setDirtAt(World worldIn, BlockPos pos)
	{
		if (worldIn.getBlockState(pos).getBlock() == ModBlocks.acGrass.getDefaultState())
		{
			worldIn.setBlockState(pos.down(), ModBlocks.acDirt.getDefaultState());
		}
		else if(worldIn.getBlockState(pos).getBlock() == Blocks.GRASS.getDefaultState())
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
        return material == Material.AIR || material == Material.LEAVES || material == Material.PLANTS || blockType == Blocks.TALLGRASS || blockType == Blocks.GRASS 
        		|| blockType == Blocks.DIRT || blockType == Blocks.LOG || blockType == Blocks.LOG2 
        		|| blockType == Blocks.SAPLING || blockType == Blocks.VINE || blockType == ModBlocks.vines 
        		|| blockType == ModBlocks.SAPLINGS1 || blockType == ModBlocks.LOG1 || blockType == ModBlocks.acGrass 
        		|| blockType == ModBlocks.acDirt || blockType == ModBlocks.BLOCK_MUSHROOM_BLUE || blockType == ModBlocks.BLOCK_MUSHROOM_PURPLE;  		
    }
    

    protected void buildRoot(World worldIn, BlockPos treeBase, EnumFacing direction, IBlockState rootBlock, List<Vec3i> posList){
    	for (Vec3i currPos: posList){
    		setRelativeBlockState(worldIn, treeBase, rootBlock, currPos.getX(), currPos.getY(), currPos.getZ(), direction);
    	}
    }
    
    protected void setRelativeBlockState(World worldIn, BlockPos treeBase, IBlockState blockStateIn, int x, int y, int z, EnumFacing direction)
    {
    	BlockPos blockPos = new BlockPos(this.getXWithOffset(treeBase, x,z,direction),this.getYWithOffset(treeBase, y), this.getZWithOffset(treeBase, x, z, direction));
    	if (this.canGrowInto(worldIn.getBlockState(blockPos).getBlock()))
    	{
    		setBlockAndNotifyAdequately(worldIn, blockPos, blockStateIn);
    	}
    	
    }
    
    private int getXWithOffset(BlockPos treeBase, int x, int z, EnumFacing direction)
    {
		switch(direction)
		{
		case NORTH:
			return treeBase.getX() + z;
		case SOUTH:
			return treeBase.getX() - z;
		case EAST:
			return treeBase.getX() + x;
		case WEST:
			return treeBase.getX() - x;
		default:
			return x;
		}    	
    }
    private int getYWithOffset(BlockPos treeBase, int y)
    {
		return treeBase.getY() + y;
    	
    }
    private int getZWithOffset(BlockPos treeBase, int x, int z, EnumFacing direction)
    {
    	switch(direction)
		{
		case NORTH:
			return treeBase.getZ() - x;
		case SOUTH:
			return treeBase.getZ() + x;
		case EAST:
			return treeBase.getZ() + z;
		case WEST:
			return treeBase.getZ() - z;
		default:
			return z;
		}  
    }

	protected void makeTrunk(World worldIn, IBlockState trunk, BlockPos pos, int height) {
		for (int i=0; i<=height; i++)
		{
			setBlockAndNotifyAdequately(worldIn, pos.up(i), trunk);
		}
	
	}
}
