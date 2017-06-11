package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPineTree extends WorldGenerator {

	Block wood;
	Block leaves;
	int metaWood;
	int metaLeaves;
	boolean growVines;
	
	public WorldGenPineTree(Block woodType, Block leaveType, int woodMeta, int leaveMeta, boolean growVines, boolean doBlockNotify)
	{
		super(doBlockNotify);
		this.wood = woodType;
		this.leaves = leaveType;
		this.metaWood = woodMeta;
		this.metaLeaves = leaveMeta;
		this.growVines = growVines;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		return true;
		
	}
	
	public void trunk()
	{

	}

	public void branch1()
	{

	}
	public void branch2()
	{

	}
	public void branch3()
	{

	}
	public void treeTop()
	{

	}
}
