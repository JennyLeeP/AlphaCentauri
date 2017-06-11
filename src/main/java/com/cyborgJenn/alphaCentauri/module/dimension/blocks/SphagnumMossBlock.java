package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SphagnumMossBlock extends Block{

	protected SphagnumMossBlock(Material material, String name) {
		super(material);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
	}

	

}
