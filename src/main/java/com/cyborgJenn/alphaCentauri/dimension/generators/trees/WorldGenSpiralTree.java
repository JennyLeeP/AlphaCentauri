package com.cyborgJenn.alphaCentauri.dimension.generators.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACLeaves1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;
import com.google.common.collect.Lists;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldGenSpiralTree extends WorldGenBaseTree
{
	private final int BaseHeight = 6;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL);
	private static final IBlockState DEFAULT_LEAF = ModBlocks.LEAVES1.getDefaultState().withProperty(BlockACLeaves1.VARIANT, BlockACLeaves1.EnumType.SPIRAL).withProperty(BlockACLeaves1.CHECK_DECAY, Boolean.valueOf(false));
	private static final IBlockState BARK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPIRAL).withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.NONE);
	
	public WorldGenSpiralTree()
	{
		super(true);
	}
	public WorldGenSpiralTree(World world,BlockPos pos)
	{
		super(true);
		this.generate(world, new Random(), pos);
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		if (this.isValidLocation(worldIn, pos, false))
		{
			int height = rand.nextInt(3) + BaseHeight;
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
	 * Makes the branches
	 * @param quantity
	 */
	private void makeBranches(World worldIn, BlockPos pos, int quantity, Random rand, int treeHeight)
	{	
		float f = rand.nextFloat() * ((float)Math.PI * 2F); // The angle in Radians.
		int x = pos.getX();
		int z = pos.getZ();
		if (quantity ==1)
		{

			int y = pos.getY() + treeHeight;
			int width = rand.nextInt(1)+2;
			for (int l =1;l <4; l++) //3 layers of leaves
			{
				if (l < 3) { //set previous block to be a normal trunk
					this.setBlockAndNotifyAdequately(worldIn, new BlockPos( x, y+l-1, z), DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
				}
				else {
					this.setBlockAndNotifyAdequately(worldIn, new BlockPos( x, y+l-1, z), BARK);
				}
				
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
						//int l1 = k1 - j;
						this.growLeavesCircular(worldIn, new BlockPos(x, k1+6, z), 1 + s, DEFAULT_LEAF);
						++s;
					}
					
				}
			}
		}
	}
	/**
	 * Makes a Quantity of Roots up to 4 
	 * @param worldIn
	 * @param quantity
	 */
	private void makeRoots(World worldIn, BlockPos treeBase, int quantity, Random rand)
	{
		List<EnumFacing> availableSides = Lists.newArrayList(EnumFacing.Plane.HORIZONTAL.facings()); //array of available sides of the tree
		for (int j=1; j<=quantity;j++)
		{
			if (quantity == 1) {
				this.setBlockAndNotifyAdequately(worldIn, treeBase, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.setBlockAndNotifyAdequately(worldIn, new BlockPos(treeBase.getX(), treeBase.getY() + 1, treeBase.getZ()), DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
			}
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
			posList.add(new Vec3i(1, 1, 0));
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
			posList.add(new Vec3i(1, 1, 0));
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
	@Override
	protected void makeTrunk(World worldIn, IBlockState trunk, BlockPos pos, int height) {
		
		setBlockAndNotifyAdequately(worldIn, pos, Blocks.AIR.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.up(1), BARK);
		for (int i=2; i<height; i++)
		{
			setBlockAndNotifyAdequately(worldIn, pos.up(i), trunk);
		}
		setBlockAndNotifyAdequately(worldIn, pos.up(height), BARK);
	}
}
