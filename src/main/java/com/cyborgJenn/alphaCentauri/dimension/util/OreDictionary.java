package com.cyborgJenn.alphaCentauri.dimension.util;

import com.cyborgJenn.alphaCentauri.dimension.blocks.BlockVanillaOres;
import com.cyborgJenn.alphaCentauri.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraftforge.fml.common.Loader;

public class OreDictionary 
{
	public static void registerOres()
	{
		net.minecraftforge.oredict.OreDictionary.registerOre("oreIron"    , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.IRON).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreGold"    , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.GOLD).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreCoal"    , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.COAL).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreLapis"   , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.LAPIS).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreDiamond" , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.DIAMOND).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreRedstone", ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.REDSTONE).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("oreEmerald" , ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.EMERALD).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("sand"       , ModBlocks.lightSand);
		net.minecraftforge.oredict.OreDictionary.registerOre("sand"       , ModBlocks.darkSand);
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.blueGravel);
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.purpleGravel);
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.redGravel);
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.rustyGravel);
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.darkGravel);
		
		if (Loader.isModLoaded("thermalfoundation") || Config.forceOres)
		{
			net.minecraftforge.oredict.OreDictionary.registerOre("oreAluminum", ModBlocks.oreAluminum);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreTin"     , ModBlocks.oreTin);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreCopper"  , ModBlocks.oreCopper);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreLead"    , ModBlocks.oreLead);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreSilver"  , ModBlocks.oreSilver);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreIridium" , ModBlocks.oreIridium);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreNickel"  , ModBlocks.oreNickel);
			net.minecraftforge.oredict.OreDictionary.registerOre("oreMithril" , ModBlocks.oreMithril);
			net.minecraftforge.oredict.OreDictionary.registerOre("orePlatinum", ModBlocks.orePlatinum);
		}

	}
}
