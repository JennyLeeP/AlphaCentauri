package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenShrubs extends WorldGenAbstractTree
{
	Block wood;
	Block leaves;
	int metaWood;
	int metaLeaves;
	boolean growVines;
	/**
	 * 
	 * @param woodType
	 * @param leaveType
	 * @param woodMeta
	 * @param leaveMeta
	 * @param growVines
	 * @param doBlockNotify
	 */
	public WorldGenShrubs(Block woodType, Block leaveType, int woodMeta, int leaveMeta, boolean growVines, boolean doBlockNotify)
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
		/*
		while (world.isAirBlock(posX, posY, posZ) && posY > 2)
        {
            --posY;
        }
		Block block2 = world.getBlock(posX, posY - 1, posZ);
		
		boolean isSoil = block2.canSustainPlant(world, posX, posY - 1, posZ, ForgeDirection.UP, (BlockSapling)ModBlocks.saplings);
		if (isSoil && posY < 256)
		{
			posY = posY +1;
			int random = new Random().nextInt(3);

			if (random == 0)
			{
				small(world, posX, posY, posZ);
			}else if(random == 1)
			{
				medium(world, posX, posY, posZ);
			}else
			{
				large(world, posX, posY, posZ);
			}
		}
		*/

		return false;
	}
	/**
	 * Creates a small sized shrub
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 */
	
	public void small(World world, int posX, int posY, int posZ)
	{
		/*
		world.setBlock(posX, posY, posZ, wood, metaWood, 2);
		world.setBlock(posX+1, posY, posZ, leaves, metaLeaves, 2);
		world.setBlock(posX-1, posY, posZ, leaves, metaLeaves, 2);
		world.setBlock(posX, posY, posZ+1, leaves, metaLeaves, 2);
		world.setBlock(posX, posY, posZ-1, leaves, metaLeaves, 2);
		world.setBlock(posX, posY+1, posZ, leaves, metaLeaves, 2);
		*/
	}
	/**
	 * Creates a Medium sized shrub.
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 */
	public void medium(World world, int posX, int posY, int posZ)
	{
		/*
		for (int i=0; i<3; i++)
		{
			world.setBlock(posX, posY+i, posZ, wood, metaWood, 2);// Creates Trunk
			world.setBlock(posX+1, posY+i, posZ, leaves, metaLeaves, 2);
			world.setBlock(posX-1, posY+i, posZ, leaves, metaLeaves, 2);
			world.setBlock(posX, posY+i, posZ+1, leaves, metaLeaves, 2);
			world.setBlock(posX, posY+i, posZ-1, leaves, metaLeaves, 2);
		}
		for (int i=0; i<2; i++)
		{
			world.setBlock(posX+2, posY+i, posZ, leaves, metaLeaves, 2);
			world.setBlock(posX-2, posY+i, posZ, leaves, metaLeaves, 2);
			world.setBlock(posX, posY+i, posZ+2, leaves, metaLeaves, 2);
			world.setBlock(posX, posY+i, posZ-2, leaves, metaLeaves, 2);
			world.setBlock(posX+1, posY+i, posZ+1, leaves, metaLeaves, 2);
			world.setBlock(posX+1, posY+i, posZ-1, leaves, metaLeaves, 2);
			world.setBlock(posX-1, posY+i, posZ+1, leaves, metaLeaves, 2);
			world.setBlock(posX-1, posY+i, posZ-1, leaves, metaLeaves, 2);
			world.setBlock(posX, posY+3+i, posZ, leaves, metaLeaves, 2);
		}
		*/
	}
	/**
	 * Creates a Large sized shrub.
	 * @param world
	 * @param posX
	 * @param posY
	 * @param posZ
	 */
	public void large(World world, int posX, int posY, int posZ)
	{

	}
}
