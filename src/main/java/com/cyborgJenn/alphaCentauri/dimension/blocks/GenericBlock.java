package com.cyborgJenn.alphaCentauri.dimension.blocks;


import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.dimension.util.Registry;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GenericBlock extends Block
{
	public GenericBlock(int type, Material material, String name) 
	{
		super(material);

		if (type == 0)    // Gate Blocks
		{     
			this.setSoundType(SoundType.STONE);
			this.setLightLevel(1.0F);
			this.setHardness(50.0F);
			this.setHarvestLevel("pickaxe", 3);
			this.setResistance(2000.0F);// resistance to tnt
		} 
		else if (type == 1)     // Stone Blocks
		{ 
			this.setSoundType(SoundType.STONE);
			this.setHardness(2.0F);
			this.setHarvestLevel("pickaxe", 2);
			this.setResistance(100.0F);
		}
		else if (type == 2)     // Dirt type Blocks
		{ 
			this.setSoundType(SoundType.GROUND);
			this.setHardness(1.0F);
			this.setHarvestLevel("shovel", 2);
			this.setResistance(25.0F);
		}
		else {}

		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+name);
		this.setRegistryName(name);

	}
}
