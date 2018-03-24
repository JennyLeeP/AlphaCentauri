package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.List;

import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class WorldGenUtils 
{
	private static List<Block> replacableBlock = Lists.newArrayList(Blocks.GRASS, Blocks.DIRT, ModBlocks.ACGRASS, ModBlocks.ACDIRT);
	private static List<Block> groundBlocks = Lists.newArrayList(Blocks.GRASS, Blocks.DIRT, ModBlocks.ACGRASS, ModBlocks.ACDIRT);
	/**
	 * Determines if this Location is a Valid Location for this object to spawn.
	 * --- Not Yet Complete , currently returning true by default. ---
	 * @param worldIn Object reference of the World
	 * @param pos BlockPos
	 * @return boolean
	 */
	public static boolean isValidLocation(World worldIn, BlockPos pos) 
	{
		return true;
	}
	public static boolean isValidTreeLocation(World worldIn, BlockPos pos, int treeHeight)
	{
		return false;
	}
	/**
	 * Is the block at the chosen location of a ground type. I.E. Grass and Dirt.
	 * @param worldIn
	 * @param pos
	 * @return
	 */
	public static boolean isGroundBlock(World worldIn, BlockPos pos)
	{
		Block groundBlock = worldIn.getBlockState(pos.down()).getBlock();
		for (Block ground : groundBlocks) {
			if (groundBlock == ground) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Determines if this Location is Dark enough to generate objects that prefer dark areas.
	 * Uses World .getLightBrightness(BlockPos)
	 * @return boolean
	 */
	public static boolean isPosDarkEnough(World worldIn, BlockPos pos)
	{
		int skylight = worldIn.getLightFor(EnumSkyBlock.SKY, pos);
		if (skylight > 1 && skylight < 5) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Determines if this Location is Bright enough for light loving objects.
	 * Uses World .getLightBrightness(BlockPos)
	 * @return boolean
	 */
	public static boolean isPosBrightEnough(World worldIn, BlockPos pos)
	{
		int skylight = worldIn.getLightFor(EnumSkyBlock.SKY, pos);
		if (skylight > 7.0F){
			return true;
		}
		return false;
	}

	/**
	 * Are we allowed to replace the block in question. Based on ArrayList of Blocks that can be replaced.
	 * @param block
	 * @return boolean
	 */
	public static boolean canReplaceBlock(Block block)
	{
		for(Block aBlock : replacableBlock){
			if (aBlock == block){
				return true;
			}
		}
		return false;
	}
}
