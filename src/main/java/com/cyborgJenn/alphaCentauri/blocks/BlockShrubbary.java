package com.cyborgJenn.alphaCentauri.blocks;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShrubbary extends Block
{
	protected static final AxisAlignedBB SHRUBBARY_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 4.0D, 1.0D);
	
	public BlockShrubbary() 
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SHRUBBARY_AABB;
	}
	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean p_185477_7_) 
	{
		addCollisionBoxToList(pos, entityBox, collidingBoxes, SHRUBBARY_AABB);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	public boolean isBlockNormalCube(IBlockState blockState) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState blockState) {
		return false;
	}
}
