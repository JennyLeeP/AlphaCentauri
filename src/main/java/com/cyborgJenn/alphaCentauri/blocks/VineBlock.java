package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.IShearable;

public class VineBlock extends BlockVine implements IShearable{

	
	protected VineBlock(String name) {
		super();
		this.setTickRandomly(true);
		this.setSoundType(SoundType.PLANT);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+name);
		this.setRegistryName(name);
	}
	
   
}
