package com.cyborgJenn.alphaCentauri.module.dimension.generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGenericTrees extends WorldGenerator {

	Block wood;
	Block leaves;
	int metaWood = 5;
	int metaLeaves;

	public WorldGenGenericTrees(Block woodType, Block leavesType, int metaWood, int metaLeaves, boolean doBlockNotify) {
		super(doBlockNotify);
		this.wood = woodType;
		this.leaves = leavesType;
		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		/*
		Random heightModulator = new Random();
		int height = heightModulator.nextInt(6);
		System.out.println("world = "+ world+ " Wood = "+ wood.toString() + " MetaWood = "+metaWood+ " Leaves = "+leaves+ " MetaLeaves = "+ metaLeaves );
		while (world.isAirBlock(x, y, z) && y > 2)
		{
			--y;
		}


		for (int var7 = -2; var7 <= 2; ++var7)
		{
			for (int var8 = -2; var8 <= 2; ++var8)
			{
				if (world.isAirBlock(x + var7, y - 1, z + var8) && world.isAirBlock(x + var7, y - 2, z + var8) && !world.isAirBlock(x + var7, y, z + var8))
					return false;
			}
		}

		System.out.println("height = "+height);
		System.out.println("metaWood = "+metaWood);
		for (int i= 0; i <= height; i++){
			world.setBlock(x, y +1 + i, z, wood, metaWood, 2);

		}

		//world.setBlock(x, y + 1 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 2 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 3 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 4 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 5 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 6 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 7 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 8 + height, z, wood, metaWood, 2);
		world.setBlock(x, y + 9 + height, z, wood, metaWood, 2);

		world.setBlock(x + 1, y + 3 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 3 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 3 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 3 + height, z - 1, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 4 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 4 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 4 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 4 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 4 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 4 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 4 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 4 + height, z - 1, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 5 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 5 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 5 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 5 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 5 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 5 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 5 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 5 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 2, y + 5 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 2, y + 5 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 5 + height, z + 2, leaves, metaLeaves, 2);
		world.setBlock(x, y + 5 + height, z - 2, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 6 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 6 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 6 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 6 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 6 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 6 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 6 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 6 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 2, y + 6 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 2, y + 6 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 6 + height, z + 2, leaves, metaLeaves, 2);
		world.setBlock(x, y + 6 + height, z - 2, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 7 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 7 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 7 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 7 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 7 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 7 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 7 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 7 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 2, y + 7 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 2, y + 7 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 7 + height, z + 2, leaves, metaLeaves, 2);
		world.setBlock(x, y + 7 + height, z - 2, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 8 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 8 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 8 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 8 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 8 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x + 1, y + 8 + height, z - 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 8 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 8 + height, z - 1, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 9 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 9 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 9 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 9 + height, z - 1, leaves, metaLeaves, 2);

		world.setBlock(x + 1, y + 10 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x - 1, y + 10 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 10 + height, z + 1, leaves, metaLeaves, 2);
		world.setBlock(x, y + 10 + height, z - 1, leaves, metaLeaves, 2);

		world.setBlock(x, y + 10 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 11 + height, z, leaves, metaLeaves, 2);
		world.setBlock(x, y + 12 + height, z, leaves, metaLeaves, 2);
		//world.setBlock(x, y + 13, z, leaves, metaLeaves, 2);
*/
		return true;
	}
}



