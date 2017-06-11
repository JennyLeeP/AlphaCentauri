package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenCharredTrees extends WorldGenAbstractTree{
	
	Block wood;
	Block leaves;
	int metaWood;
	int metaLeaves;
	boolean growVines;
    
    public WorldGenCharredTrees(Block woodType, Block leaveType, int woodMeta, int leaveMeta, boolean growVines, boolean doBlockNotify)
    {
    	super(doBlockNotify);
		this.wood = woodType;
		this.leaves = leaveType;
		this.metaWood = woodMeta;
		this.metaLeaves = leaveMeta;
		this.growVines = growVines;
    }

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}
}
