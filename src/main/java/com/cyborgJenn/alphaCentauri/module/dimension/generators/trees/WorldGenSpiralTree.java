package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBaseTree;
import com.google.common.collect.Lists;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenSpiralTree extends WorldGenBaseTree
{
	private final int BaseHeight = 5;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL);
	private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	private static final IBlockState BARK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL).withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE);
	public WorldGenSpiralTree(World world,BlockPos pos)
	{
		super(true);
		this.generate(world, new Random(), pos);// TODO fix hacky tree gen.
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		//this.generateTree(world, random); TODO see if this is needed
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{

		if (this.isValidLocation(worldIn, pos, false))
		{
			int height = rand.nextInt(4) + BaseHeight;
			int quantity = rand.nextInt(4)+1;
			this.setDirtAt(worldIn, pos.down());

			this.makeTrunk(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), pos, height);
			this.makeRoots(worldIn, pos, quantity, rand);
			this.makeBranches(worldIn, pos, quantity, rand, height);
			return true;
		}	
		return false;
	}

	/**
	 * Makes a Quantity of Roots up to 4 
	 * @param worldIn
	 * @param quantity
	 */
	private void makeRoots(World worldIn, BlockPos treebase, int quantity, Random rand)
	{
		List<EnumFacing> availableSides = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL.facings()); //array of available sides of the tree
		for (int j=1; j<=quantity;j++)
		{
			EnumFacing direction = availableSides.remove(rand.nextInt(availableSides.size())); //pick a random direction and remove it from the list
			int type = rand.nextInt(2) + 1;
			buildRoot(worldIn, treebase, direction, type);
		}
	}
	/**
	 * Makes the branches
	 * @param quantity
	 */
	private void makeBranches(World worldIn, BlockPos pos, int quantity, Random rand, int height)
	{
		
		
		float f = rand.nextFloat() * ((float)Math.PI * 2F); // angle?
		for (int i =0; i <= quantity; i++)
		{
			for (int j = pos.getY() + height; j > pos.getY() + height + rand.nextInt(4); j -= 2 + rand.nextInt(4))
			{
				f += rand.nextFloat() * ((float)Math.PI * 2F / quantity); // angle?
				int k = pos.getX() + (int)(0.5F + MathHelper.cos(f) * 4.0F);
				int l = pos.getZ() + (int)(0.5F + MathHelper.sin(f) * 4.0F);

				for (int i1 = 0; i1 < 5; ++i1)
				{
					k = pos.getX() + (int)(1.5F + MathHelper.cos(f) * (float)i1);
					l = pos.getZ() + (int)(1.5F + MathHelper.sin(f) * (float)i1);
					this.setBlockAndNotifyAdequately(worldIn, new BlockPos(k, j + 3 + i1 / 2, l), BARK);
				}

				int j2 = 1 + rand.nextInt(2);
				int j1 = j;  // References y height as J.

				for (int k1 = j - j2; k1 <= j1; ++k1)
				{
					int l1 = k1 - j1;
					this.growLeavesCircular(worldIn, new BlockPos(k, k1 + height, l), 1 - l1, DEFAULT_LEAF);
				}
			}
		}

	}

	/**
	 * Selects the type of Root to use.
	 * @param worldIn
	 * @param type
	 */
	private void buildRoot(World worldIn, BlockPos treeBase, EnumFacing direction, int type)
	{
		switch (type)
		{
		case 1: 
			//TODO more root designs/styles
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 1, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 1, direction);
			break;
		case 2:
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, -1, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 3, 0, -1, direction);
			break;

		default:
			break;
		}
	}
}
