package com.cyborgJenn.alphaCentauri.module.dimension.util;

import com.cyborgJenn.alphaCentauri.core.utils.Config;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;

import net.minecraftforge.fml.common.Loader;

public class OreDictionary 
{
	public static void registerOres()
	{
		net.minecraftforge.oredict.OreDictionary.registerOre("oreIron"    , ModBlocks.oreIron);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreGold"    , ModBlocks.oreGold);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreCoal"    , ModBlocks.oreCoal);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreLapis"   , ModBlocks.oreLapis);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreDiamond" , ModBlocks.oreDiamond);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreRedstone", ModBlocks.oreRedstone);
		net.minecraftforge.oredict.OreDictionary.registerOre("oreEmerald" , ModBlocks.oreEmerald);
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
