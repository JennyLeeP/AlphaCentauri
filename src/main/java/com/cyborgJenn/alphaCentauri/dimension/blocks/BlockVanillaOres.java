package com.cyborgJenn.alphaCentauri.dimension.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public class BlockVanillaOres extends Block {
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockVanillaOres.EnumType.class);
	
	public BlockVanillaOres() {
		super(Material.ROCK, MapColor.CYAN);
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(Reference.MODID + "." + "block_vanilla_ore");
		this.setRegistryName("block_vanilla_ore");

	}
	//TODO drops
	public static enum EnumType implements IStringSerializable
    {
        GOLD(0, "gold"),
        IRON(1, "iron"),
		LAPIS(2, "lapis"),
		COAL(3, "coal"),
		DIAMOND(4,"diamond"),
		EMERALD(5,"emerald"),
		REDSTONE(6,"redstone");
        private static final BlockVanillaOres.EnumType[] META_LOOKUP = new BlockVanillaOres.EnumType[values().length];
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

        public static BlockVanillaOres.EnumType byMetadata(int meta)
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
        	BlockVanillaOres.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockVanillaOres.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}
