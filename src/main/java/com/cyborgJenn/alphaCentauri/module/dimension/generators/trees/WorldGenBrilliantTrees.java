package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenBrilliantTrees extends WorldGenAbstractTree {

    public WorldGenBrilliantTrees(Block wood, Block leaves, int woodMeta, int leavesMeta)
    {
        super(true);
    }
    
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}
}