package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class VineBlock extends BlockVine implements IShearable{

	
	protected VineBlock(String name) {
		super();
		this.setTickRandomly(true);
		this.setSoundType(SoundType.PLANT);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemBlock(this), new ResourceLocation(Reference.MODID, name));
	}
	
   
}
