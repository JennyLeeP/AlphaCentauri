package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class BlockACDirt extends Block
{  
    protected BlockACDirt(String name)
    {
        super(Material.GROUND);
        this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
        this.setSoundType(SoundType.GROUND);
		this.setHardness(1.0F);
		this.setHarvestLevel("shovel", 2);
		this.setResistance(25.0F);
        this.setUnlocalizedName(Reference.MODID +"."+ name);
        GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
    }   
    @Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
    {
		return true;
    }
}
