package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;


public class BlockACDirt extends Block 
{  
    protected BlockACDirt() 
    {
        super(Material.GROUND);
        this.setSoundType(SoundType.GROUND);
		this.setHardness(1.0F);
		this.setHarvestLevel("shovel", 2);
		this.setResistance(25.0F);
    }   
    @Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) 
    {
		return true;
    }
}
