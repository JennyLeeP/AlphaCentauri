package com.cyborgJenn.alphaCentauri.module.machine.block;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.machine.tileEnitity.TileEntityRedstoneEmitter;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
