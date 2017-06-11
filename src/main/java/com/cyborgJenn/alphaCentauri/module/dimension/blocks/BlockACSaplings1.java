package com.cyborgJenn.alphaCentauri.module.dimension.blocks;

import java.util.List;
import java.util.Random;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenSpiralTree;
import com.cyborgJenn.alphaCentauri.module.dimension.generators.WorldGenSplotchTree;
import com.cyborgJenn.alphaCentauri.module.dimension.items.ItemSaplingBlock1;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACSaplings1 extends BlockBush implements IGrowable 
{
	public static final PropertyEnum<BlockACPlanks1.EnumType> VARIANT = PropertyEnum.<BlockACPlanks1.EnumType>create("variant", BlockACPlanks1.EnumType.class);
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
    public BlockACSaplings1() 
	{
		super(Material.PLANTS);
		String name = "saplings1";
		this.blockSoundType = SoundType.PLANT;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID +"."+ name);
		GameRegistry.register(this, new ResourceLocation(Reference.MODID, name));
		GameRegistry.register(new ItemSaplingBlock1(this), new ResourceLocation(Reference.MODID, name));
	}
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, rand, pos, state);
            }
        }
    }
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
	}
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
		WorldGenerator worldgenerator;
		switch ((BlockACPlanks1.EnumType)state.getValue(VARIANT))
        {
            case SPIRAL:
            	worldgenerator = new WorldGenSpiralTree();
            	AlphaCentauri.logger.info("Generate Spiral Tree");
            	break;
            case SPLOTCH:
            	worldgenerator = new WorldGenSplotchTree();
            	AlphaCentauri.logger.info("Generate Splotch Tree");
            	break;
		default:
			break;
        }
    }
	private boolean isTwoByTwoOfType(World worldIn, BlockPos pos, int X, int Z, BlockACPlanks1.EnumType type)
    {
        return this.isTypeAt(worldIn, pos.add(X, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z), type) && this.isTypeAt(worldIn, pos.add(X, 0, Z + 1), type) && this.isTypeAt(worldIn, pos.add(X + 1, 0, Z + 1), type);
    }

    /**
     * Check whether the given BlockPos has a Sapling of the given type
     */
    public boolean isTypeAt(World worldIn, BlockPos pos, BlockACPlanks1.EnumType variant)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == this && iblockstate.getValue(VARIANT) == variant;
    }
    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (BlockACPlanks1.EnumType blockplanks$enumtype : BlockACPlanks1.EnumType.values())
        {
            list.add(new ItemStack(itemIn, 1, blockplanks$enumtype.getMetadata()));
        }
    }
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockACPlanks1.EnumType.byMetadata(meta & 3)).withProperty(STAGE, Integer.valueOf((meta & 8) % 4));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
        i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
    }
}
