package com.cyborgJenn.alphaCentauri.dimension.blocks;

import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MossBlock extends BlockBush{

	protected static final AxisAlignedBB MOSS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1D, 1.0D);

	protected MossBlock(String name) 
	{
		super(Material.PLANTS);
		this.setHardness(0.2F);
		this.setLightOpacity(0);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName(Reference.MODID +"."+name);
		this.setRegistryName(name);
	}
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
        	IBlockState ablock = worldIn.getBlockState(pos.down());
            return ablock.getBlock() != Blocks.AIR;
        }
        return !this.isAir(state, worldIn, pos.down());
    }
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		IBlockState notAir = worldIn.getBlockState(pos.down());
		return  !notAir.getBlock().isAir(notAir, worldIn, pos.down());
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return MOSS_AABB;
	}
	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}
