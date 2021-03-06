package com.cyborgJenn.alphaCentauri.dimension.generators.trees;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACLeaves1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldGenSplotchTree extends WorldGenBaseTree 
{
	private final int baseHeight = 10;
	private static final IBlockState DEFAULT_TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.SPLOTCH);
	private static final IBlockState DEFAULT_LEAF = ModBlocks.LEAVES1.getDefaultState().withProperty(BlockACLeaves1.VARIANT, BlockACLeaves1.EnumType.SPLOTCH).withProperty(BlockACLeaves1.CHECK_DECAY, Boolean.valueOf(false));

	public WorldGenSplotchTree() {super(true);}
	
	public WorldGenSplotchTree(World world, BlockPos pos) {
		super(true);
		this.generate(world, new Random(), pos);
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) { }

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		int height = rand.nextInt(10) + baseHeight;
		if (this.isValidLocation(worldIn, pos, false)) {
			makeTrunk(worldIn, DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), pos, height);
			makeBranches(worldIn, pos, height, rand);
			return true;
		}
		return false;
	}
	public void makeBranches(World worldIn, BlockPos pos, int height, Random rand) {
		this.setBlockAndNotifyAdequately(worldIn, pos.up(height+1), DEFAULT_LEAF);
		int baseGap = rand.nextInt(4); 
		for (int i = height; i > baseGap;i=i-2) {
			int branchLength = (height - i)/2;
			for (EnumFacing direction:EnumFacing.HORIZONTALS) {
				IBlockState branchLog = DEFAULT_TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(direction.getAxis()));
				for (int j = 0; j < branchLength; j++) {
					this.setBlockAndNotifyAdequately(worldIn, pos.up(i).offset(direction, j + 1), branchLog);
					int leafWidth = Math.round((branchLength - j)/2f + 1);
					for (int k = 1; k < leafWidth; k++) {
						this.setBlockAndNotifyAdequately(worldIn, pos.up(i).offset(direction, j + 1).offset(direction.rotateY(), k), DEFAULT_LEAF);
						this.setBlockAndNotifyAdequately(worldIn, pos.up(i).offset(direction, j + 1).offset(direction.rotateYCCW(), k), DEFAULT_LEAF);
					}
				}
				this.setBlockAndNotifyAdequately(worldIn, pos.up(i).offset(direction, branchLength + 1), DEFAULT_LEAF);
			}
		}
	}
}
