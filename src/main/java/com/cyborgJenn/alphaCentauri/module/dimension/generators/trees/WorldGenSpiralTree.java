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
			//this.setDirtAt(worldIn, pos.down());

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
			int type = rand.nextInt(6) + 1;
			buildRoot(worldIn, treebase, direction, type);
		}
	}
	/**
	 * Makes the branches
	 * @param quantity
	 */
	private void makeBranches(World worldIn, BlockPos pos, int quantity, Random rand, int treeHeight)
	{	
		float f = rand.nextFloat() * ((float)Math.PI * 2F); // The angle in Radians.
		int width = rand.nextInt(1)+1;
		int x = pos.getX();
		int y = pos.getY() + treeHeight -2;
		int z = pos.getZ();
		if (quantity ==1)
		{
			for (int l =1;l <4; l++)
			{
				this.growLeavesCircular(worldIn, new BlockPos( x, y+l, z),width , DEFAULT_LEAF);
				++width;
			}
		}
		else 
		{
			
			for (int t =1; t <= quantity; t++)
			{	
				for (int j = pos.getY() + treeHeight - 2; j > (pos.getY() + treeHeight / 2); j -= 2 + rand.nextInt(4))
				{
					//f += ((rand.nextFloat() / quantity) * ((float)Math.PI * 2F / quantity)) + ((float)Math.PI * 2F / quantity);
					f += (((-0.5 + rand.nextFloat()) / quantity) * ((float)Math.PI * 2F / quantity)) + ((float)Math.PI * 2F / quantity);
					for (int i1 = 0; i1 < + 5; ++i1)
					{
						x = pos.getX() + (int)(1.0F + MathHelper.cos(f) * (float)i1);
						z = pos.getZ() + (int)(1.0F + MathHelper.sin(f) * (float)i1);
						this.setBlockAndNotifyAdequately(worldIn, new BlockPos(x, j + 3 + i1 / 2, z), BARK);
					}
					
					
					int j2 = 1 + rand.nextInt(2);
					int s = 1;
					for (int k1 = j - j2; k1 <= j; ++k1)
					{
						//System.out.println("k1 "+ k1 + " j "+ j + " j2 "+ j2);
						int l1 = k1 - j;
						this.growLeavesCircular(worldIn, new BlockPos(x, k1+6, z), 1 + s, DEFAULT_LEAF);
						++s;
					}
					
				}
			}
		}
	}
	/**
	 * Selects the type of Root to use.
	 * X+ or 1  = away from tree, X- or -1 = towards or behind tree.
	 * Z+ or 1  = left, Z- or -1 = right.
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
		case 3:
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 1, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 2, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 0, direction);
			break;
		case 4:
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 3, 0, -1, direction);
			break;
		case 5:
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			break;
		case 6:
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 1, 1, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 3, 0, 0, direction);
			this.setRelativeBlockState(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), 4, 0, 1, direction);
			break;
		default:
			break;
		}
	}
	@Override
	protected void makeTrunk(World worldIn, IBlockState trunk, BlockPos pos, int height) {
		
		setBlockAndNotifyAdequately(worldIn, pos, Blocks.AIR.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.up(1), BARK);
		for (int i=2; i<=height -1; i++)
		{
			setBlockAndNotifyAdequately(worldIn, pos.up(i), trunk);
		}
		setBlockAndNotifyAdequately(worldIn, pos.up(height), BARK);
	}
}
