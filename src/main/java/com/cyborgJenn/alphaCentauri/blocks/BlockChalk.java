package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChalk extends Block{

	protected BlockChalk() {
		super(Material.ROCK);
		this.blockSoundType = SoundType.GLASS;
	}
	
	@Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
		if (!worldIn.isRemote)
		{
			if (entityIn.world.getBlockState(pos) == ModBlocks.CHALK.getDefaultState())
			{
				worldIn.destroyBlock(pos, false);
			}
		}
	}
}
