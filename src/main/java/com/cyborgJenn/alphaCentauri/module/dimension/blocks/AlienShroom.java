package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenLargeMushroom;
import com.cyborgJenn.alphaCentauri.module.dimension.util.Registry;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AlienShroom extends BlockBush implements IGrowable
{
	protected static final AxisAlignedBB MUSHROOM_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.8, 0.699999988079071D);

	public AlienShroom(String name)
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
	}
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return MUSHROOM_AABB;
	}
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return (double)rand.nextFloat() < 0.4D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		this.generateLargeMushroom(worldIn, pos, state, rand);	
	}
	/**
	 * Return true if the block can sustain a Bush
	 */
	@Override
	protected boolean canSustainBush(IBlockState state)
	{
		return state.isFullBlock();
	}
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock() == ModBlocks.FUNGUS || this.canBlockStay(worldIn, pos, this.getDefaultState());
    }
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		if (pos.getY() >= 0 && pos.getY() < 256)
		{
			IBlockState soil = worldIn.getBlockState(pos.down());
			return soil.getBlock().canSustainPlant(state, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
		}
		else
		{
			return false;
		}
	}
	public boolean generateLargeMushroom(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		worldIn.setBlockToAir(pos);
		WorldGenerator worldgenerator = null;

		if (this == ModBlocks.PURPLE_MUSHROOM)
		{
			worldgenerator = new WorldGenLargeMushroom(ModBlocks.BLOCK_MUSHROOM_PURPLE);// TODO make custom large mushroom.
		}
		else if (this == ModBlocks.BLUE_MUSHROOM)
		{
			worldgenerator = new WorldGenLargeMushroom(ModBlocks.BLOCK_MUSHROOM_BLUE);
		}
		if (worldgenerator != null && worldgenerator.generate(worldIn, rand, pos))
		{
			return true;
		}
		else
		{
			worldIn.setBlockState(pos, state, 3);
			return false;
		}
	}
}
