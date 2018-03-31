package com.cyborgJenn.alphaCentauri.dimension.generators.mapgen;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.MapGenCaves;

public class MapGenACCaves extends MapGenCaves {
	@Override
	protected boolean canReplaceBlock(IBlockState state, IBlockState stateUp) {
		if(super.canReplaceBlock(state, stateUp)){
			return true;
		}else if (state.getBlock() == ModBlocks.ACSTONE) {
			return true;
		}else {
			return (state.getBlock() == ModBlocks.SAND || state.getBlock() == ModBlocks.GRAVEL) && stateUp.getMaterial() != Material.WATER;
		}
	}
}
