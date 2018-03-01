package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBoulders extends Block {

	public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 3);
	
	public BlockBoulders() 
	{
		super(Material.ROCK, MapColor.BLACK);
	}
	@Override
	public boolean isBlockNormalCube(IBlockState blockState) {
		return false;
	}
	@Override
	public boolean isOpaqueCube(IBlockState blockState) {
		return false;
	}
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		// TODO Auto-generated method stub
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	/**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(TYPE)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
}
