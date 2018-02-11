package com.cyborgJenn.alphaCentauri.dimension.generators.trees;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.dimension.blocks.BlockACLog1;
import com.cyborgJenn.alphaCentauri.dimension.blocks.BlockACPlanks1;
import com.cyborgJenn.alphaCentauri.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenBaseTree;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenAdonsoniaTree extends WorldGenBaseTree {

	private static final IBlockState TRUNK = ModBlocks.LOG1.getDefaultState().withProperty(BlockACLog1.VARIANT, BlockACPlanks1.EnumType.ADANSONIA);
	private static final IBlockState LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	
	public WorldGenAdonsoniaTree(World worldIn, BlockPos pos) {
		super(true);
		this.generate(worldIn, new Random(), pos);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		AlphaCentauri.logger.info("Growing Adonsonia Tree");
		return false;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) { }

}
