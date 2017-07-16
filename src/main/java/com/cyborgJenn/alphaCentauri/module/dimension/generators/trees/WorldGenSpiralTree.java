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
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenSpiralTree extends WorldGenBaseTree
{
	private final int BaseHeight = 5;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL);
	private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

	public WorldGenSpiralTree(World world,BlockPos pos)
	{
		super(true, world, pos);
		this.generateTree(world, new Random());// TODO fix hacky tree gen.
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		this.generateTree(world, random);
	}

	public void generateTree(World worldIn, Random rand) 
	{
        
		if (this.isValidLocation(worldIn, pos, false))
		{
			int height = rand.nextInt(4) + BaseHeight;
			int quantity = rand.nextInt(4)+1;
			
			IBlockState block = worldIn.getBlockState(pos.down());
			this.setDirt(worldIn, block);
			
			this.makeTrunk(worldIn, height);
			this.makeRoots(worldIn, quantity, rand);
			System.out.println("Quantity; "+quantity);
			
		}	
	}
	
	public void makeTrunk(World worldIn, int height)
	{


		for (int i=0; i<=height; i++)
		{
			this.setBlockAndNotifyAdequately(worldIn, pos.up(i), DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
		}

	}
	/**
	 * Makes a Quantity of Roots up to 4 
	 * @param worldIn
	 * @param quantity
	 */
	private void makeRoots(World worldIn, int quantity, Random rand)
	{
		List<EnumFacing> availableSides = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL.facings()); //array of available sides of the tree
		for (int j=1; j<=quantity;j++)
		{
			EnumFacing direction = availableSides.remove(rand.nextInt(availableSides.size())); //pick a random direction and remove it from the list
			int type = rand.nextInt(2) + 1;
			buildRoot(worldIn, direction, type);
		}
	}
	/**
	 * Makes the branches
	 * @param quantity
	 */
	private void makeBranches(int quantity)
	{

	}
	
	/**
	 * Selects the type of Root to use.
	 * @param worldIn
	 * @param type
	 */
	private void buildRoot(World worldIn, EnumFacing direction, int type)
	{
		switch (type)
		{
		case 1: 
			//TODO more root designs/styles
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 1, 1, 0, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 2, 0, 1, direction);
			break;
		case 2:
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 1, 0, 0, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 2, 0, 0, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 2, 0, -1, direction);
			this.setRelativeBlockState(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), 3, 0, -1, direction);
			break;

		default:
			break;
		}
	}
}
