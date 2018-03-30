package com.cyborgJenn.alphaCentauri.dimension.generators.trees;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.blocks.BlockACLeaves1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldGenHouseTree extends WorldGenBaseTree {

	private static final IBlockState TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.ADANSONIA);
	private static final IBlockState LEAF = ModBlocks.LEAVES1.getDefaultState().withProperty(BlockACLeaves1.VARIANT, BlockACLeaves1.EnumType.ADANSONIA);//.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	
	public WorldGenHouseTree() {
		super(true);
	} //empty constructor
	
	public WorldGenHouseTree(World worldIn, List<BlockPos> sapList) { //sapling generator
		super(true);
		Random rand = new Random();
		generateWalls(worldIn, rand, sapList);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) { //worldgen method
		//generate a 2x2 or 3x3
		AlphaCentauri.logger.info("Growing House Tree");
		return false;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) { } //unused
	
	private void generateWalls(World worldIn, Random rand, List<BlockPos> sapList) {
		for (int i = 0; i < sapList.size();i++) {
			this.makeTrunk(worldIn, TRUNK.withProperty(BlockACLog1.LOG_AXIS, BlockLog.EnumAxis.Y), sapList.get(i), 4);
		}
		
	}

}
