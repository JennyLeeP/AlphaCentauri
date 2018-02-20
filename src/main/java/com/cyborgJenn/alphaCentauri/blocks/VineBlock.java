package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraftforge.common.IShearable;

public class VineBlock extends BlockVine implements IShearable{

	protected VineBlock(String name) 
	{
		super();
		this.setTickRandomly(true);
		this.setSoundType(SoundType.PLANT);
	}
}
