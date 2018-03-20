package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoulders extends WorldGenerator
{
	@SuppressWarnings("unused")
	private Block blockUsed;

	public void setBlockUSed(Block blockUsedIn)
    {
        this.blockUsed = blockUsedIn;
    }

    public WorldGenBoulders() { }

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
