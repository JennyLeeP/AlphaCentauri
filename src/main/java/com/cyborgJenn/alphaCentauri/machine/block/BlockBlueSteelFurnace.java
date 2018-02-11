package com.cyborgJenn.alphaCentauri.machine.block;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBlueSteelFurnace extends BlockContainer{

	private final boolean isActive;
	private static boolean keepInventory;
	private Random rand = new Random();

	protected BlockBlueSteelFurnace(boolean isActive) {
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
