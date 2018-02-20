package com.cyborgJenn.alphaCentauri.blocks;

import net.minecraft.block.BlockFalling;
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

public class BlockACGravel extends BlockFalling {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockACGravel.EnumType.class);
	
	public BlockACGravel() 
	{
		super(Material.SAND);
		this.blockSoundType = SoundType.GROUND;
		this.setHardness(0.5F);
		this.setHarvestLevel("shovel", 2);
		this.setResistance(5.0F);
	}
	/**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockACGravel.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	BlockACGravel.EnumType[] aenumtype = BlockACGravel.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BlockACGravel.EnumType enumtype = aenumtype[j];
        	items.add(new ItemStack(this, 1, enumtype.getMetadata()));
        }
    }
    /**
     * Convert the given meta-data into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockACGravel.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockACGravel.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
    public static enum EnumType implements IStringSerializable
    {
        BLUE(0, "blue"),
        RED(1, "red"),
		DARK(2, "dark"),
		PURPLE(3, "purple"),
		RUSTY(4, "rusty");
        private static final BlockACGravel.EnumType[] META_LOOKUP = new BlockACGravel.EnumType[values().length];
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

        public static BlockACGravel.EnumType byMetadata(int meta)
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
        	BlockACGravel.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockACGravel.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
