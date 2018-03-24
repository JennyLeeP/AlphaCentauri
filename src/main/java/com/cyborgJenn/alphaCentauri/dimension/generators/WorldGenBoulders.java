package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoulders extends WorldGenerator
{
	private  IBlockState blockState;

	public WorldGenBoulders() { }

	public void setBlockStateUsed(IBlockState blockStateIn)
	{
		blockState = blockStateIn;
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) 
	{	
		if(WorldGenUtils.isValidLocation(worldIn, pos))
		{
			pickBoulder(worldIn, pos, rand.nextInt(4));
			return true;
		}
		return false;
	}
	private void pickBoulder(World worldIn, BlockPos pos, int type)
	{
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		if (blockState == null)
		{
			blockState = ModBlocks.ACCOBBLE.getDefaultState();
		}
		switch (type)
		{
		case 0:
			/*      Type 1      */
			worldIn.setBlockState(new BlockPos(X, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X, Y + 1, Z), blockState);
			worldIn.setBlockState(new BlockPos(X + 1, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X - 1, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X, Y, Z + 1), blockState);
			worldIn.setBlockState(new BlockPos(X, Y, Z - 1), blockState);
			worldIn.setBlockState(new BlockPos(X, Y - 1, Z), blockState);
			break;
		case 1:
			worldIn.setBlockState(new BlockPos(X, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X + 1, Y, Z + 1), blockState);
			break;
		case 2:
			worldIn.setBlockState(new BlockPos(X, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X + 1, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X + 1, Y + 1, Z), ModBlocks.MOSS.getDefaultState());
			worldIn.setBlockState(new BlockPos(X - 1, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X - 1, Y + 1, Z), ModBlocks.MOSS.getDefaultState());
			worldIn.setBlockState(new BlockPos(X, Y + 1, Z), blockState);
			break;
		case 3:
			worldIn.setBlockState(new BlockPos(X, Y, Z), blockState);
			worldIn.setBlockState(new BlockPos(X, Y + 1, Z), ModBlocks.MOSS.getDefaultState());
			
			break;
		default:
			AlphaCentauri.logger.warn("Tried to generate a non existant boulder type");
			break;
		}
	}

}
