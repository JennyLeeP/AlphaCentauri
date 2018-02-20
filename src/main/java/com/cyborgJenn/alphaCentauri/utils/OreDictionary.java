package com.cyborgJenn.alphaCentauri.utils;

import com.cyborgJenn.alphaCentauri.blocks.BlockACGravel;
import com.cyborgJenn.alphaCentauri.blocks.BlockACSand;
import com.cyborgJenn.alphaCentauri.blocks.BlockVanillaOres;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;

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
		net.minecraftforge.oredict.OreDictionary.registerOre("sand"       , ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.LIGHT).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("sand"       , ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.MEDIUM).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("sand"       , ModBlocks.SAND.getDefaultState().withProperty(BlockACSand.VARIANT, BlockACSand.EnumType.DARK).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.SAND.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.BLUE).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.SAND.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.RED).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.SAND.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.DARK).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.SAND.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.PURPLE).getBlock());
		net.minecraftforge.oredict.OreDictionary.registerOre("gravel"     , ModBlocks.SAND.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.RUSTY).getBlock());
		
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
