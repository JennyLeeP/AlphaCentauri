package com.cyborgJenn.alphaCentauri.dimension.generators;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACDoublePlant;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenACDoublePlants extends WorldGenerator {

	private BlockACDoublePlant.EnumPlantType plantType;

	public void setPlantType(BlockACDoublePlant.EnumPlantType plantTypeIn)
	{
		this.plantType = plantTypeIn;
	}
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		boolean flag = false;
		for (int i = 0; i < 64; ++i)
		{
			BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

			if (worldIn.isAirBlock(blockpos) &&(!worldIn.provider.isNether() || blockpos.getY() < 254) && ModBlocks.ACDOUBLEPLANT.canPlaceBlockAt(worldIn, blockpos))
			{
				if (WorldGenUtils.isPosDarkEnough(worldIn, blockpos.add(0,1,0)))
				{
					//System.out.println("Checked Light at: "+blockpos.getX()+" "+blockpos.getY() + 1+" "+blockpos.getZ());
					ModBlocks.ACDOUBLEPLANT.placeAt(worldIn, blockpos, this.plantType, 2);
					flag = true;
				}
			}
		}
		return flag;
	}

}
