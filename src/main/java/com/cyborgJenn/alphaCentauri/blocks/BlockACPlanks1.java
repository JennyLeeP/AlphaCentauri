package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockACPlanks1 extends Block 
{
	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", BlockACPlanks1.EnumType.class);
	
	public BlockACPlanks1() 
	{
		super(Material.WOOD);
		this.blockSoundType = SoundType.WOOD;
		this.setHardness(2.0F);
		this.setResistance(5.0F);
	}
	
	/**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	BlockACPlanks1.EnumType[] aenumtype = BlockACPlanks1.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BlockACPlanks1.EnumType enumtype = aenumtype[j];
        	items.add(new ItemStack(this, 1, enumtype.getMetadata()));
        }
    }

    /**
     * Convert the given meta-data into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockACPlanks1.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockACPlanks1.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
	
	public static enum EnumType implements IStringSerializable
    {
        SPIRAL(0, "spiral"),
        SPLOTCH(1, "splotch"),
		MANGROVE(2, "mangrove"),
		ADANSONIA(3, "adansonia");
        private static final BlockACPlanks1.EnumType[] META_LOOKUP = new BlockACPlanks1.EnumType[values().length];
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

        public static BlockACPlanks1.EnumType byMetadata(int meta)
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
        	BlockACPlanks1.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockACPlanks1.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
