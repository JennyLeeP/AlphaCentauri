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

public class BlockACSandStone extends Block 
{
	public static final PropertyEnum<EnumType> VARIANT = PropertyEnum.create("variant", BlockACSandStone.EnumType.class);
	
	public BlockACSandStone() {
		super(Material.ROCK);
		this.blockSoundType = SoundType.STONE;
		this.setHardness(1.0F);
		this.setResistance(3.0F);
	}
	 @Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockACSandStone.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	BlockACSandStone.EnumType[] aenumtype = BlockACSandStone.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BlockACSandStone.EnumType enumtype = aenumtype[j];
        	items.add(new ItemStack(this, 1, enumtype.getMetadata()));
        }
    }
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockACSandStone.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockACSandStone.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
    public static enum EnumType implements IStringSerializable
    {
        LIGHT_NORMAL(0, "light_normal"),
        LIGHT_SMOOTH(1, "light_smooth"),
		LIGHT_CARVED(2, "light_carved"),
		MEDIUM_NORMAL(3, "medium_normal"),
		MEDIUM_SMOOTH(4, "medium_smooth"),
		MEDIUM_CARVED(5, "medium_carved"),
		DARK_NNORMAL(6, "dark_normal"),
		DARK_SMOOTH(7, "dark_smooth"),
		DARK_CARVED(8, "dark_carved");
        private static final BlockACSandStone.EnumType[] META_LOOKUP = new BlockACSandStone.EnumType[values().length];
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

        public static BlockACSandStone.EnumType byMetadata(int meta)
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
        	BlockACSandStone.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockACSandStone.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
