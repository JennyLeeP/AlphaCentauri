package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BeachGrassBlock extends BlockBush implements IPlantable
{
	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", BeachGrassBlock.EnumType.class);
	protected static final AxisAlignedBB BGRASS_AABB = new AxisAlignedBB(0.025D, 0.0D, 0.025D, 0.975D, 0.70D, 0.975D);
	
	public BeachGrassBlock() 
	{
		super(Material.PLANTS);
		this.blockSoundType = SoundType.PLANT;	
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BGRASS_AABB;
    }
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		IBlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();
        
		if (block == ModBlocks.SAND || block == Blocks.SAND)
        {
            return true;
        }
		return false;
    }
	@Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
	@Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return getDefaultState();
    }
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {   
		return this.canPlaceBlockAt(worldIn, pos);
    }
	/**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	BeachGrassBlock.EnumType[] aenumtype = BeachGrassBlock.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BeachGrassBlock.EnumType enumtype = aenumtype[j];
        	items.add(new ItemStack(this, 1, enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given meta-data into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BeachGrassBlock.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BeachGrassBlock.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
	
	public static enum EnumType implements IStringSerializable
    {
        FULL(0, "full"),
        MED(1, "med"),
		LOW(2, "low");
        private static final BeachGrassBlock.EnumType[] META_LOOKUP = new BeachGrassBlock.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;


        private EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static BeachGrassBlock.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
        	BeachGrassBlock.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BeachGrassBlock.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
