package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenBaseTree;

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
	private ArrayList<BlockPos> RSIDES = new ArrayList<BlockPos>();
	private final int BaseHeight = 5;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL);
	private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

	public WorldGenSpiralTree(World world,BlockPos pos)
	{
		super(true, world, pos);
		addSides();
		this.gen();// TODO fix hacky tree gen.
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		this.generateTree(world, random, pos);
	}
	@Override
	public void generateTree(World worldIn, Random rand, BlockPos pos) 
	{
		EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
		int j = pos.getX();
        int k = pos.getY();
        int l = pos.getZ();
        
		if (this.isValidLocation(worldIn, pos, false))
		{
			int height = rand.nextInt(4) + BaseHeight;
			int quantity = rand.nextInt(4)+1;
			
			IBlockState block = worldIn.getBlockState(pos.down());
			this.setDirt(worldIn, block, pos);
			
			this.makeTrunk(worldIn, pos, height);
			this.makeRoots(worldIn, pos, quantity);
			System.out.println("Quantity; "+quantity);
			RSIDES.clear();
			
		}	
	}
	public void gen()
	{
		this.generateTree(world, rand, pos);
	}
	public void makeTrunk(World worldIn, BlockPos pos, int height)
	{


		for (int i=0; i<=height; i++)
		{
			worldIn.setBlockState(pos.up(i), DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
		}

	}
	/**
	 * Makes a Quantity of Roots up to 4 
	 * @param worldIn
	 * @param pos
	 * @param quantity
	 */
	private void makeRoots(World worldIn, BlockPos pos, int quantity)
	{
		int j;
		for (j=1; j<=quantity;j++)
		{
			rootType(worldIn, pickSide(pos), selectType());
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
	private void rootType(World worldIn, BlockPos pos, int type)
	{
		switch (type)
		{
		case 1: 
			//TODO actually set the blocks for the root type.
			System.out.println("Type 1");
			this.setBlockAndNotifyAdequately(worldIn, pos, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
			this.setBlockAndNotifyAdequately(worldIn, pos, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
			break;
		case 2:
			System.out.println("Type 2");
			this.setBlockAndNotifyAdequately(worldIn, pos, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE));
			break;

		default:
			System.out.println("Type default");
			break;
		}
	}
	/**
	 * Method used to return an Integer referring to type of root to use.
	 * Must be = to the number of root types we have.
	 * @return
	 */
	private int selectType()
	{
		int type = rand.nextInt(2) + 1;

		return type;
	}
	/**
	 * Gets Random position for Root around tree Trunk. 
	 * Must remove side from list if chosen.
	 * 4 Side of tree - pos.east() , pos.west(), pos.north(), pos.south().
	 * @param pos
	 * @return
	 */
	private BlockPos pickSide(BlockPos pos)
	{ 
		BlockPos thePos;
		int choice = rand.nextInt(RSIDES.size());
		thePos = RSIDES.get(choice);
		int X = thePos.getX();
		int Y = thePos.getY();
		int Z = thePos.getZ();
		
		AlphaCentauri.logger.info("ThePos: "+ thePos);
		AlphaCentauri.logger.info("Pos: "+ pos);
		
		pos = pos.add(X, Y, Z);
		RSIDES.remove(choice);
		System.out.println("Choice: " + pos);//TODO remove debug code
		return pos;
	}
	private void addSides()
	{
		RSIDES.add(BlockPos.ORIGIN.east());
		RSIDES.add(BlockPos.ORIGIN.west());
		RSIDES.add(BlockPos.ORIGIN.north());
		RSIDES.add(BlockPos.ORIGIN.south());
	}
	public void rotatedPos(BlockPos pos)
	{
		
	}
}
