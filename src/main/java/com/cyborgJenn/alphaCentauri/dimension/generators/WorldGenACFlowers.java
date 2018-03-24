package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers;
import com.cyborgJenn.alphaCentauri.blocks.BlockACFlowers.EnumType;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenACFlowers extends WorldGenerator 
{
	private IBlockState state;
	private EnumType chosen;
	public static List<EnumType> possible = new ArrayList<EnumType>();

	public WorldGenACFlowers() { }
	/**
	 * Set a list of EnumType FLowers to generate. Should be called by a Biome to create a 
	 * list of acceptable flowers to generate in this Biome.
	 * Other wise the generator will default to generating a purple flower.
	 * @param list
	 */
	public static void setFlowers(ArrayList<BlockACFlowers.EnumType> list)
	{
		possible.addAll(list);
	}
	private BlockACFlowers.EnumType chooseFlower()
	{
		if (!possible.isEmpty()) {
			int rand = new Random().nextInt(possible.size());
			chosen = possible.get(rand);
			return chosen;

		} else {
			for (int i = 0; i < BlockACFlowers.EnumType.values().length; ++i) {
				chosen = BlockACFlowers.EnumType.byMetadata(i);
			}
			return chosen ;
		}
	}
	/**
	 * Generates a Random Flower from available EnumTypes in BlockACFlowers. 
	 * If a list of possible flowers is given to setFlowers by the Biome.
	 * This will then generate a random flower from the given list.
	 */
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		this.state = ModBlocks.FLOWERS.getDefaultState().withProperty(BlockACFlowers.VARIANT, chooseFlower());
		for (int i = 0; i < 64; ++i)
		{
			BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

			if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && ModBlocks.FLOWERS.canBlockStay(worldIn, blockpos, this.state))
			{
				worldIn.setBlockState(blockpos, this.state, 2);
			}
		}
		return true;
	}
}
