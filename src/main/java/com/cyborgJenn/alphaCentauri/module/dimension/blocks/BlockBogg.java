package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBogg extends Block{

	private Random rand;
	protected BlockBogg() {
		super(Material.GROUND);
		this.blockSoundType = SoundType.SAND;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return blockState.getBoundingBox(worldIn, pos);

	}
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		rand = new Random();
		entityIn.motionX *= 0.1D;
		entityIn.motionZ *= 0.1D;
		entityIn.motionY *= 0.001D;

		//entityIn.playSound("game.neutral.swim", 0.7F, 1.6F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
	}
}
