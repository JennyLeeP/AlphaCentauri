package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenACSand extends WorldGenerator {
	/**   The Block to generate with      */
	private final IBlockState state;
	/** The maximum radius used when generating a patch of blocks. */
	private final int radius;

	public WorldGenACSand(IBlockState state, int radius) {
		this.state = state;
		this.radius = radius;
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (worldIn.getBlockState(position).getMaterial() != Material.WATER)
		{
			return false;
		}
		else
		{
			int i = rand.nextInt(this.radius - 2) + 2;
			for (int k = position.getX() - i; k <= position.getX() + i; ++k)
			{
				for (int l = position.getZ() - i; l <= position.getZ() + i; ++l)
				{
					int i1 = k - position.getX();
					int j1 = l - position.getZ();

					if (i1 * i1 + j1 * j1 <= i * i)
					{
						for (int k1 = position.getY() - 2; k1 <= position.getY() + 2; ++k1)
						{
							BlockPos blockpos = new BlockPos(k, k1, l);
							Block block = worldIn.getBlockState(blockpos).getBlock();

							if (block == ModBlocks.ACDIRT || block == ModBlocks.ACGRASS)
							{
								worldIn.setBlockState(blockpos, state, 2);
							}
						}
					}
				}
			}

			return true;
		}
	}

}
