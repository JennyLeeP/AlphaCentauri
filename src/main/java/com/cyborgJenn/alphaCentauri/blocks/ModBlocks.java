package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.dimension.portal.BlockAlphaCentauriPortal;
import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block gateAlphaCentauri;

	public static BlockAlphaCentauriPortal alphaCentauriPortal;

	public static BlockACGrass acGrass;
	public static BlockACGrass darkGrass;
	public static Block beachGrass;
	public static Block acDirt;
	@GameRegistry.ObjectHolder("alphacentauri:acstone")
	public static Block ACSTONE;
	public static Block acCobble;
	public static Block basalt;
	public static Block basaltCobble;
	public static Block marble;
	public static Block granite;
	
	public static Block lightSandstone;
	public static Block darkSandstone;
	
	public static Block lightSand;
	public static Block darkSand;
	
	public static Block blueGravel;
	public static Block redGravel;
	public static Block darkGravel;
	public static Block purpleGravel;
	public static Block rustyGravel;

	public static Block peat;
	public static Block bogg;

	public static Block chalk;
	public static Block shells;
	public static Block cursedStone;

	public static Block walls;
	public static Block fences;

	public static BlockBush MOSS;
	public static Block vines;

	public static Block whiteFlower;
	public static Block orangeFlower;
	public static Block magentaFlower;
	public static Block lightBlueFlower;
	public static Block yellowFlower;
	public static Block limeFlower;
	public static Block pinkFlower;
	public static Block grayFlower;
	public static Block lightGrayFlower;
	public static Block cyanFlower;
	public static Block purpleFlower;
	public static Block blueFlower;
	public static Block brownFlower;
	public static Block greenFlower;
	public static Block redFlower;
	public static Block blackFlower;

	public static Block LOG1;
	public static Block LOG2;
	public static Block leaves;
	public static Block SAPLINGS1;
	public static Block PLANKS1;
	
	public static Block ALIEN_PLANTS_1;

	public static Block VANILLA_ORES;
	
	
	public static Block oreAluminum;
	public static Block oreApatite;
	public static Block oreArdite;
	public static Block oreCobalt;
	public static Block oreCopper;
	
	
	
	
	public static Block oreLead;
	public static Block oreNickel;
	
	public static Block oreSaltpeter;
	public static Block oreSilver;
	public static Block oreSulfur;
	public static Block oreTin;
	public static Block oreUranium;
	public static Block oreMethane;
	public static Block oreIridium;
	public static Block orePlatinum;
	public static Block oreMithril;
	public static Block oreMonazit;
	public static Block oreBauxite;
	public static Block oreGalena;
	public static Block oreGarneirite;
	public static Block oreElectrotine;
	public static Block oreSaphire;
	public static Block oreRuby;
	public static Block orePeridot;
	public static Block oreCertus;
	public static Block oreResonating;
	public static Block oreYellorite;
	
	public static BlockBush PURPLE_MUSHROOM;
	public static BlockBush BLUE_MUSHROOM;
	public static Block FUNGUS;
	public static Block BLOCK_MUSHROOM_PURPLE;
	public static Block BLOCK_MUSHROOM_BLUE;
	
	public static void init()
	{
		initBlocks();
		InitCompatOres();
		addFireSpreadInfo();
	}

	public static void initBlocks()
	{
		// TODO Trees and plants.
		
		/* Gate Blocks */
		gateAlphaCentauri       = new GenericBlock(0, Material.ROCK, "acgate");
		alphaCentauriPortal     = (BlockAlphaCentauriPortal) new BlockAlphaCentauriPortal("acportal");

		/*  GROUND type  Blocks  */
		acGrass       = (BlockACGrass) new BlockACGrass();
		//beachGrass    = new BeachGrassBlock("beachGrass");
		acDirt        = new BlockACDirt("acdirt");
		peat          = new GenericBlock(2, Material.GROUND, "peat");
		//bogg          = new BlockBogg();

		/* Sand & Gravel Blocks  */
		lightSand     = new FallingBlock(0, Material.SAND, "sand_light");
		darkSand      = new FallingBlock(0, Material.SAND, "sand_dark");
		
		blueGravel    = new FallingBlock(1, Material.GROUND, "gravel_blue");
		redGravel     = new FallingBlock(1, Material.GROUND, "gravel_red");
		darkGravel    = new FallingBlock(1, Material.GROUND, "gravel_dark");
		purpleGravel  = new FallingBlock(1, Material.GROUND, "gravel_purple");
		rustyGravel   = new FallingBlock(1, Material.GROUND, "gravel_rusty");

		/* Stone Blocks */
		ACSTONE       = new GenericBlock(1, Material.ROCK, "acstone");
		acCobble      = new GenericBlock(1, Material.ROCK, "accobble");
		basalt        = new GenericBlock(1, Material.ROCK, "basalt");
		basaltCobble  = new GenericBlock(1, Material.ROCK, "basalt_cobble");
		marble        = new GenericBlock(1, Material.ROCK, "marble");
		granite       = new GenericBlock(1, Material.ROCK, "granite");
		lightSandstone= new SandstoneBlock("sandstone_light");
		darkSandstone = new SandstoneBlock("sandstone_dark");

		/* Misc */
		//chalk         = new BlockChalk().setRegistryName("chalk");
		//shells        = new GenericBlock(1, Material.ROCK, "shells");
		cursedStone     = new GenericBlock(1, Material.ROCK, "cursedStone");

		/* Fences and Walls */
		//walls         = new WallBlock(beachGrass).setRegistryName("terraWalls");
		//fences        = new FenceBlock().setRegistryName("terraFences");

		/* Flowers  and Plants */
		whiteFlower     = new PlantBlock("flower_white");
		orangeFlower    = new PlantBlock("flower_orange");
		magentaFlower   = new PlantBlock("flower_magenta");
		lightBlueFlower = new PlantBlock("flower_lightblue");
		yellowFlower    = new PlantBlock("flower_yellow");
		limeFlower      = new PlantBlock("flower_lime");
		pinkFlower      = new PlantBlock("flower_pink");
		grayFlower      = new PlantBlock("flower_gray");
		lightGrayFlower = new PlantBlock("flower_lightgray");
		cyanFlower      = new PlantBlock("flower_cyan");
		purpleFlower    = new PlantBlock("flower_purple");
		blueFlower      = new PlantBlock("flower_blue");
		brownFlower     = new PlantBlock("flower_brown");
		greenFlower     = new PlantBlock("flower_green");
		redFlower       = new PlantBlock("flower_red");
		blackFlower     = new PlantBlock("flower_black");

		MOSS    		= new MossBlock("moss");
		vines           = new VineBlock("bluemoss");
		
		/*  Trees Leaves Saplings  */
		LOG1            = new BlockACLog1("log1");
		LOG2 			= new BlockACLog2("log2");
		PLANKS1         = new BlockACPlanks1();
		SAPLINGS1       = new BlockACSaplings1();
		
		
		ALIEN_PLANTS_1 = new BlockAlienPlants1("alien_plants");
		
		FUNGUS 		    = new BlockFungus("fungus");
		PURPLE_MUSHROOM = new AlienShroom("purple_mushroom");
		BLUE_MUSHROOM   = new AlienShroom("blue_mushroom");
		BLOCK_MUSHROOM_PURPLE = new BlockAlienMushroom("block_mushroom_purple", MapColor.PURPLE, PURPLE_MUSHROOM);
		BLOCK_MUSHROOM_BLUE   = new BlockAlienMushroom("block_mushroom_blue", MapColor.BLUE, BLUE_MUSHROOM);
		//leaves          = new ZetaLeafBlock();
		
		/* Ores  */
		VANILLA_ORES      = new BlockVanillaOres();
		
		oreMethane   = new GenericBlock(1, Material.ROCK, "ore_methane");
	}
	public static void InitCompatOres()
	{
		/*TODO fix null-pointer . 
		 * Mod Ores not loaded and not forced by config, causes null-pointer on ItemBlock render register.
		 * Reason: -  blocks have not been registered to forge, therefore do not exist = null.
		*/
		if (Loader.isModLoaded("thermalfoundation") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello ThermalFoundation, Initializing Ores");
			oreAluminum  = new GenericBlock(1, Material.ROCK, "ore_aluminum");
			oreCopper    = new GenericBlock(1, Material.ROCK, "ore_copper");
			oreNickel    = new GenericBlock(1, Material.ROCK, "ore_nickel");
			oreSilver    = new GenericBlock(1, Material.ROCK, "ore_silver");
			oreLead      = new GenericBlock(1, Material.ROCK, "ore_lead");
			oreTin       = new GenericBlock(1, Material.ROCK, "ore_tin");
			oreIridium   = new GenericBlock(1, Material.ROCK, "ore_iridium");
			orePlatinum  = new GenericBlock(1, Material.ROCK, "ore_platinum");
			oreMithril   = new GenericBlock(1, Material.ROCK, "ore_mithril");
		}
		if (Loader.isModLoaded("railcraft") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Railcraft, Initializing Ores");
			oreSaltpeter = new GenericBlock(1, Material.ROCK, "ore_saltpeter");
			oreSulfur    = new GenericBlock(1, Material.ROCK, "ore_sulfur");
		}
		if (Loader.isModLoaded("techreborn") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello TechReborn, Initializing Ore's");
			oreUranium    = new GenericBlock(1, Material.ROCK, "ore_uranium");
			oreBauxite    = new GenericBlock(1, Material.ROCK, "ore_bauxite");
			oreGalena     = new GenericBlock(1, Material.ROCK, "ore_galena");
			oreGarneirite = new GenericBlock(1, Material.ROCK, "ore_garneirite");
			
		}
		if (Loader.isModLoaded("forestry") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Forestry, Initializing Ore");
			oreApatite   = new GenericBlock(1, Material.ROCK, "ore_apatite");
		}
		if (Loader.isModLoaded("mffs") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello MFFS, Initializing Ore");
			oreMonazit   = new GenericBlock(1, Material.ROCK, "ore_monazit");
		}
		if (Loader.isModLoaded("projectred") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello ProjectRed, Initializing Ore's");
			oreElectrotine = new GenericBlock(1, Material.ROCK, "ore_electrotine");
			orePeridot     = new GenericBlock(1, Material.ROCK, "ore_peridot");
			oreRuby        = new GenericBlock(1, Material.ROCK, "ore_ruby");
			oreSaphire     = new GenericBlock(1, Material.ROCK, "ore_saphire");
		}
		if (Loader.isModLoaded("appliedenergistics") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Applied Energistics, Initializing Ore");
			oreCertus = new GenericBlock(1, Material.ROCK, "ore_certus");
		}
		if (Loader.isModLoaded("deepresonance") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Deep Resonance, Initializing Ore");
			oreResonating = new GenericBlock(1, Material.ROCK, "ore_resonating");
		}
		if (Loader.isModLoaded("big-reactors") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello BigReactors, Initializing Ore");
			oreYellorite = new GenericBlock(1, Material.ROCK, "ore_yellorite");
		}
		
		

	}
	private static void addFireSpreadInfo() 
	{
		Blocks.FIRE.setFireInfo(ModBlocks.leaves, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.PLANKS1, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.LOG1, 30, 60);
		// TODO finish adding fire spread info;
	}
}
