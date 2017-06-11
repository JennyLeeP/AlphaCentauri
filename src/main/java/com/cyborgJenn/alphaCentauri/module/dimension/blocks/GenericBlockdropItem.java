package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GenericBlockdropItem extends Block {

	public GenericBlockdropItem(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}

	public GenericBlockdropItem(int i, Material materialIn, String name, Item item) 
	{
		super(materialIn);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
	}

}
