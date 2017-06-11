package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenLifeTrees extends WorldGenAbstractTree{

    public WorldGenLifeTrees(boolean par1)
    {
        super(par1);
    }
    
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}

}
