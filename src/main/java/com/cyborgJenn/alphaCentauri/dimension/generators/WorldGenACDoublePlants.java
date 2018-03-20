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
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		boolean flag = false;

        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 254) && ModBlocks.ACDOUBLEPLANT.canPlaceBlockAt(worldIn, blockpos))
            {
                ModBlocks.ACDOUBLEPLANT.placeAt(worldIn, blockpos, this.plantType, 2);
                flag = true;
            }
        }

        return flag;
	}

}
