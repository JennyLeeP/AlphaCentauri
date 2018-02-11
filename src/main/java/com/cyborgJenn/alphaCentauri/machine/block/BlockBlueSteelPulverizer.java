package com.cyborgJenn.alphaCentauri.machine.block;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBlueSteelPulverizer extends BlockContainer{

	private final boolean isActive;
	
	
    
	protected BlockBlueSteelPulverizer(boolean isActive) {
		super(Material.IRON);
		this.isActive = isActive;
		if (!isActive){
			this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		}else {
			this.setLightLevel(1.0F);
		}
	}



	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
