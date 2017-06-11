package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFluidMercury extends BlockFluidClassic{


    
	public BlockFluidMercury(Fluid fluid, Material material) {
		super(fluid, material);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}
	
}
