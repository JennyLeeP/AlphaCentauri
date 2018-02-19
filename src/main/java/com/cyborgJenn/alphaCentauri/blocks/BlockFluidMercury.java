package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidMercury extends BlockFluidClassic{


    
	public BlockFluidMercury(Fluid fluid, Material material) {
		super(fluid, material);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}
	
}
