package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class GenericBlockdropItem extends Block {

	public GenericBlockdropItem(Material materialIn) 
	{
		super(materialIn);
	}

	public GenericBlockdropItem(int i, Material materialIn, String name, Item item) 
	{
		super(materialIn);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+name);
		this.setRegistryName(name);
	}

}
