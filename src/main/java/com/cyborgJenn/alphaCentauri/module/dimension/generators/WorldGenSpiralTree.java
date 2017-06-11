package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpiralTree extends WorldGenAbstractTree 
{
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL);
    private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean growVines;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;
    
    public WorldGenSpiralTree(boolean notify)
    {
    	this(notify, 4, DEFAULT_TRUNK, DEFAULT_LEAF, false);
    }
    public WorldGenSpiralTree(boolean notify, int p_i46446_2_, IBlockState blockStateLog, IBlockState blockStateLeaves, boolean growVines)
    {
        super(notify);
        this.minTreeHeight = p_i46446_2_;
        this.metaWood = blockStateLog;
        this.metaLeaves = blockStateLeaves;
        this.growVines = growVines;
    }
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		int i = rand.nextInt(3) + this.minTreeHeight;
		IBlockState state = worldIn.getBlockState(position.down());
		if (state.getBlock().canSustainPlant(state, worldIn, position.down(), net.minecraft.util.EnumFacing.UP, (net.minecraft.block.BlockSapling)Blocks.SAPLING) && position.getY() < worldIn.getHeight() - i - 1)
        {
			this.setDirtAt(worldIn, position.down());
			return true;
        }
        else
        {
            return false;
        }
		
	}
	public void makeTrunk()
	{
		
	}
	public void makeRoots()
	{
		
	}
	public void makeBranches()
	{
		
	}
	@Override
	/**
     * sets dirt at a specific location if it isn't already dirt
     */
    protected void setDirtAt(World worldIn, BlockPos pos)
    {
        if (worldIn.getBlockState(pos).getBlock() != ModBlocks.acDirt)
        {
            this.setBlockAndNotifyAdequately(worldIn, pos, ModBlocks.acDirt.getDefaultState());
        }
    }
}
