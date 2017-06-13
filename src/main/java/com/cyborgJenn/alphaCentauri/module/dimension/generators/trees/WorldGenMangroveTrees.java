package com.cyborgJenn.alphaCentauri.module.dimension.generators.trees;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenMangroveTrees extends WorldGenAbstractTree{
	/** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final int metaLeaves;
    private static final String __OBFID = "CL_00000438";

    public WorldGenMangroveTrees(boolean par1)
    {
        this(par1, 12, 0, 0, true);
    }

    public WorldGenMangroveTrees(boolean par1, int par2, int par3, int par4, boolean par5)
    {
        super(par1);
        this.minTreeHeight = par2;
        this.metaWood = par3;
        this.metaLeaves = par4;
        this.vinesGrow = par5;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
		return vinesGrow;
    	/*
        int l = par2Random.nextInt(3) + this.minTreeHeight;
        boolean flag = true;

        if (posY >= 1 && posY + l + 1 <= 256)
        {
            byte b0;
            int k1;
            Block block;

            for (int i1 = posY; i1 <= posY + 1 + l; ++i1)
            {
                b0 = 1;

                if (i1 == posY)
                {
                    b0 = 0;
                }

                if (i1 >= posY + 1 + l - 2)
                {
                    b0 = 2;
                }

                for (int j1 = posX - b0; j1 <= posX + b0 && flag; ++j1)
                {
                    for (k1 = posZ - b0; k1 <= posZ + b0 && flag; ++k1)
                    {
                        if (i1 >= 0 && i1 < 256)
                        {
                            block = par1World.getBlock(j1, i1, k1);

                            if (!this.isReplaceable(par1World, j1, i1, k1))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block2 = par1World.getBlock(posX, posY - 1, posZ);

                boolean isSoil = block2.canSustainPlant(par1World, posX, posY - 1, posZ, ForgeDirection.UP, (ZetaSaplingsBlock)ModBlocks.saplings);
                if (isSoil && posY < 256 - l - 1)
                {
                    block2.onPlantGrow(par1World, posX, posY - 1, posZ, posX, posY, posZ);
                    b0 = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (k1 = posY - b0 + l; k1 <= posY + l; ++k1)
                    {
                        i3 = k1 - (posY + l);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = posX - l1; i2 <= posX + l1; ++i2)
                        {
                            j2 = i2 - posX;

                            for (int k2 = posZ - l1; k2 <= posZ + l1; ++k2)
                            {
                                int l2 = k2 - posZ;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || par2Random.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = par1World.getBlock(i2, k1, k2);

                                    if (block1.isAir(par1World, i2, k1, k2) || block1.isLeaves(par1World, i2, k1, k2))
                                    {
                                        this.setBlockAndNotifyAdequately(par1World, i2, k1, k2, Blocks.leaves, this.metaLeaves);
                                    }
                                }
                            }
                        }
                    }

                    for (k1 = 0; k1 < l; ++k1)
                    {
                        block = par1World.getBlock(posX, posY + k1, posZ);

                        if (block.isAir(par1World, posX, posY + k1, posZ) || block.isLeaves(par1World, posX, posY + k1, posZ))
                        {
                            this.setBlockAndNotifyAdequately(par1World, posX, posY + k1, posZ, ModBlocks.log1, this.metaWood);

                            if (this.vinesGrow && k1 > 0)
                            {
                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(posX - 1, posY + k1, posZ))
                                {
                                    this.setBlockAndNotifyAdequately(par1World, posX - 1, posY + k1, posZ, Blocks.vine, 8);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(posX + 1, posY + k1, posZ))
                                {
                                    this.setBlockAndNotifyAdequately(par1World, posX + 1, posY + k1, posZ, Blocks.vine, 2);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(posX, posY + k1, posZ - 1))
                                {
                                    this.setBlockAndNotifyAdequately(par1World, posX, posY + k1, posZ - 1, Blocks.vine, 1);
                                }

                                if (par2Random.nextInt(3) > 0 && par1World.isAirBlock(posX, posY + k1, posZ + 1))
                                {
                                    this.setBlockAndNotifyAdequately(par1World, posX, posY + k1, posZ + 1, Blocks.vine, 4);
                                }
                            }
                        }
                    }

                    if (this.vinesGrow)
                    {
                        for (k1 = posY - 3 + l; k1 <= posY + l; ++k1)
                        {
                            i3 = k1 - (posY + l);
                            l1 = 2 - i3 / 2;

                            for (i2 = posX - l1; i2 <= posX + l1; ++i2)
                            {
                                for (j2 = posZ - l1; j2 <= posZ + l1; ++j2)
                                {
                                    if (par1World.getBlock(i2, k1, j2).isLeaves(par1World, i2, k1, j2))
                                    {
                                        if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2 - 1, k1, j2).isAir(par1World, i2 - 1, k1, j2))
                                        {
                                            this.growVines(par1World, i2 - 1, k1, j2, 8);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2 + 1, k1, j2).isAir(par1World, i2 + 1, k1, j2))
                                        {
                                            this.growVines(par1World, i2 + 1, k1, j2, 2);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2, k1, j2 - 1).isAir(par1World, i2, k1, j2 - 1))
                                        {
                                            this.growVines(par1World, i2, k1, j2 - 1, 1);
                                        }

                                        if (par2Random.nextInt(4) == 0 && par1World.getBlock(i2, k1, j2 + 1).isAir(par1World, i2, k1, j2 + 1))
                                        {
                                            this.growVines(par1World, i2, k1, j2 + 1, 4);
                                        }
                                    }
                                }
                            }
                        }

                        if (par2Random.nextInt(5) == 0 && l > 5)
                        {
                            for (k1 = 0; k1 < 2; ++k1)
                            {
                                for (i3 = 0; i3 < 4; ++i3)
                                {
                                    if (par2Random.nextInt(4 - k1) == 0)
                                    {
                                        l1 = par2Random.nextInt(3);
                                        this.setBlockAndNotifyAdequately(par1World, posX + Direction.offsetX[Direction.rotateOpposite[i3]], posY + l - 5 + k1, posZ + Direction.offsetZ[Direction.rotateOpposite[i3]], Blocks.cocoa, l1 << 2 | i3);
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        */
    }

    /**
     * Grows vines downward from the given block for a given length. Args: World, x, starty, z, vine-length
     */
    private void growVines(World par1World, int par2, int par3, int posY, int posZ)
    {
        
    }
	public void genRoots(){

	}
	public void genBase(){

	}
	public void genBranches(){
		
	}
}
