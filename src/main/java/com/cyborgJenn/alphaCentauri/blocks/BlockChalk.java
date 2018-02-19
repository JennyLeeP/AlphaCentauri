package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChalk extends Block{

	protected BlockChalk() {
		super(Material.CLAY);
		this.blockSoundType = SoundType.SAND;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}
	
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		
	}
}
