package com.cyborgJenn.alphaCentauri.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FallingBlock extends BlockFalling{


	protected FallingBlock(int type, Material material, String name) 
	{
		if (type == 0)
		{
			this.blockSoundType = SoundType.SAND;
			this.setHardness(0.5F);
			this.setHarvestLevel("shovel", 2);
			this.setResistance(5.0F);
		}
		if (type == 1)
		{
			this.blockSoundType = SoundType.GROUND;
			this.setHardness(0.5F);
			this.setHarvestLevel("shovel", 2);
			this.setResistance(5.0F);
		}
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+name);
		this.setRegistryName(name);
	}

}
