package com.cyborgJenn.alphaCentauri.dimension.generators.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.google.common.collect.Lists;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenSplotchTree extends WorldGenBaseTree 
{
	private final int BaseHeight = 15;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPLOTCH);
	private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

	public WorldGenSplotchTree(World world, BlockPos pos)
	{
		super(true);
		this.generate(world, new Random(), pos);// TODO fix hacky tree gen.
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		//this.generateTree(world, random); TODO check if this is really needed or not because of the dimension
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(3) + rand.nextInt(2) + 6; //TODO use baseheight here?

		if (this.isValidLocation(worldIn, pos, false))
		{

			
			
			makeTrunk(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), pos, height);
            makeRoots(worldIn, pos, rand);
    		return true;
		}
		return false;
	}

/**
	 * Makes a Quantity of Roots up to 4 
	 * @param worldIn
	 * @param quantity
	 */
	private void makeRoots(World worldIn, BlockPos treeBase, Random rand)
	{
		int quantity = rand.nextInt(5);
		List<EnumFacing> availableSides = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL.facings()); //array of available sides of the tree
		for (int j=1; j<=quantity;j++)
		{
			EnumFacing direction = availableSides.remove(rand.nextInt(availableSides.size())); //pick a random direction and remove it from the list
			pickRoot(worldIn, treeBase, direction, rand);
		}
	}
	
	/**
	 * Selects the type of Root to use.
	 * @param worldIn
	 * @param type
	 */
	private void pickRoot(World worldIn, BlockPos treeBase, EnumFacing direction, Random rand)
	{
		int type = rand.nextInt(6) + 1;
		List<Vec3i> posList = new ArrayList<Vec3i>();
		switch (type)
		{
		case 1: 
			//TODO more root designs/styles DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE)
			posList.add(new Vec3i(1, 0, 0));
			posList.add(new Vec3i(1, 1, 0));
			posList.add(new Vec3i(2, 0, 0));
			posList.add(new Vec3i(2, 0, 1));
			break;
		case 2:
			posList.add(new Vec3i(1, 0, 0));
			posList.add(new Vec3i(2, 0, 0));
			posList.add(new Vec3i(2, 0, -1));
			posList.add(new Vec3i(3, 0, -1));
			break;
		case 3:
			posList.add(new Vec3i(1, 0, 0));
			posList.add(new Vec3i(1, 1, 0));
			posList.add(new Vec3i(1, 2, 0));
			posList.add(new Vec3i(2, 0, 0));
			break;
		case 4:
			posList.add(new Vec3i(1, 0, 0));
			posList.add(new Vec3i(2, 0, 0));
			posList.add(new Vec3i(3, 0, -1));
			break;
		case 5:
			posList.add(new Vec3i(1, 0, 0));
			break;
		case 6:
			posList.add(new Vec3i(1, 0, 0));
			posList.add(new Vec3i(1, 1, 0));
			posList.add(new Vec3i(2, 0, 0));
			posList.add(new Vec3i(3, 0, 0));
			posList.add(new Vec3i(4, 0, 1));
			break;
		default:
			break;
		}
		buildRoot(worldIn, treeBase, direction, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE), posList);
	}
}
