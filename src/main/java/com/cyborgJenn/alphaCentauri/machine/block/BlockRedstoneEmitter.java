package com.cyborgJenn.alphaCentauri.machine.block;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.machine.tileEnitity.TileEntityRedstoneEmitter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRedstoneEmitter extends BlockContainer{

	private boolean particles = true;
	protected BlockRedstoneEmitter() {
		super(Material.IRON);
		this.setLightLevel(1.0F);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityRedstoneEmitter();
	}

	
    
}
