package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

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

public class WorldGenSplotchTree extends WorldGenBaseTree 
{
	private final World world;
	private Random rand = new Random();
	private final BlockPos pos;
	private final int BaseHeight = 15;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPLOTCH);
	private static final IBlockState DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));

	public WorldGenSplotchTree(World world, BlockPos pos)
	{
		super(true);
		//addSides();
		this.pos = pos;
		this.world = world;
		this.gen();// TODO fix hacky tree gen.
	}

	public void gen()
	{
		this.generateTree(world, rand, pos);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		this.generateTree(world, random, pos);
	}
	@Override
	public  void generateTree(World worldIn, Random rand, BlockPos position) 
	{
		EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);//Picks random side of tree around the horizontal plane.
		IBlockState state = worldIn.getBlockState(position);
		int height = rand.nextInt(3) + rand.nextInt(2) + 6;
		int posX = position.getX();
		int posY = position.getY();
		int posZ = position.getZ();

		if (this.isValidLocation(worldIn, position, false))
		{
			int k1 = posX;
            int l1 = posZ;
            int rootType = rand.nextInt(4);
            k1 += enumfacing.getFrontOffsetX();
            l1 += enumfacing.getFrontOffsetZ();
            
			makeTrunk(worldIn, position, height);
			
			int k2 = posY;
			BlockPos newPos = new BlockPos(k1, k2, l1);
			
            placeLogAt(worldIn, newPos);
            placeRoot(worldIn, newPos, enumfacing, rootType);
		}
		
	}

	private void placeLogAt(World worldIn, BlockPos pos)
    {
        if (this.canGrowInto(worldIn.getBlockState(pos).getBlock()))
        {
            this.setBlockAndNotifyAdequately(worldIn, pos, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
        }
    }
	public void makeTrunk(World worldIn, BlockPos pos, int height)
	{


		for (int i=0; i<=height; i++)
		{
			worldIn.setBlockState(pos.up(i), DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y));
		}

	}
	private void placeRoot(World worldIn, BlockPos pos, EnumFacing facing, int type)
	{
		int offsetX = facing.getFrontOffsetX();
		int offsetZ = facing.getFrontOffsetZ();
		int index = facing.getHorizontalIndex();// 0 = south, 1 = west, 2 = north 3 = east.
		EnumFacing opp = facing.getOpposite();
		
		AlphaCentauri.logger.info("Facing: "+facing+" RootType: "+type+ " Xoffset: "+ offsetX+ " Zoffset: "+offsetZ+" Index: "+index+" Opposite: "+opp);
	}
}
