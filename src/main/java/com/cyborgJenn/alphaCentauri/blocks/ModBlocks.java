package com.cyborgJenn.alphaCentauri.blocks;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.dimension.portal.BlockAlphaCentauriPortal;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACFlowers;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACGravel;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACLeaves1;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACLog1;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACLog2;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACPlank1;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACPlank2;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockACSand;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockAlienPlants;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockBeachGrass;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemBlockVanillaOres;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemSaplingBlock1;
import com.cyborgJenn.alphaCentauri.item.itemBlock.ItemSaplingBlock2;
import com.cyborgJenn.alphaCentauri.proxy.CommonProxy;
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

	public static BlockACGrass ACGRASS;
	public static BlockACGrass darkGrass;
	public static Block BEACHGRASS;
	public static Block ACDIRT;
	@GameRegistry.ObjectHolder("alphacentauri:acstone")
	public static Block ACSTONE;
	public static Block ACCOBBLE;
	public static Block BASALT;
	public static Block BASALTCOBBLE;
	public static Block MARBLE;
	public static Block GRANITE;
	public static Block SAND;
	public static Block GRAVEL;
	public static Block PEAT;
	
	public static Block lightSandstone;
	public static Block darkSandstone;
	public static Block bogg;
	public static Block CHALK;
	public static Block shells;
	public static Block cursedStone;
	public static Block walls;
	public static Block fences;

	public static BlockBush MOSS;
	public static Block VINES;
	public static Block FLOWERS;
	public static Block LOG1;
	public static Block LOG2;
	public static Block LEAVES1;
	public static Block SAPLINGS1;
	public static Block SAPLINGS2;
	public static Block PLANKS1;
	public static Block PLANKS2;
	public static Block ALIEN_PLANTS_1;
	public static Block VANILLA_ORES;
	public static BlockBush PURPLE_MUSHROOM;
	public static BlockBush BLUE_MUSHROOM;
	public static Block FUNGUS;
	public static Block BLOCK_MUSHROOM_PURPLE;
	public static Block BLOCK_MUSHROOM_BLUE;
	public static Block BOULDERS;
	public static Block SHRUBBARY;
	
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
	
	public static void initBlocks()
	{
		/* Gate Blocks */
		//gateAlphaCentauri       = new GenericBlock(0, Material.ROCK, "acgate");
		alphaCentauriPortal     = (BlockAlphaCentauriPortal) new BlockAlphaCentauriPortal("acportal");

		/*  GROUND type  Blocks  */
		ACGRASS       = (BlockACGrass) new BlockACGrass();
		CommonProxy.registerBlockWithItem(ACGRASS, "acgrass");
		BEACHGRASS    = new BeachGrassBlock();
		CommonProxy.registerBlockWithCustomItem(BEACHGRASS, new ItemBlockBeachGrass(BEACHGRASS), "beachgrass");
		ACDIRT        = new BlockACDirt();
		CommonProxy.registerBlockWithItem(ACDIRT, "acdirt");
		PEAT          = new GenericBlock(2, Material.GROUND);
		CommonProxy.registerBlockWithItem(PEAT, "peat");
		//bogg          = new BlockBogg();

		/* Sand & Gravel Blocks  */
		SAND          = new BlockACSand();
		CommonProxy.registerBlockWithCustomItem(SAND, new ItemBlockACSand(SAND),"sand");
		GRAVEL        = new BlockACGravel();
		CommonProxy.registerBlockWithCustomItem(GRAVEL, new ItemBlockACGravel(GRAVEL),"gravel");
		
		/* Stone Blocks */
		ACSTONE       = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(ACSTONE, "acstone");
		ACCOBBLE      = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(ACCOBBLE, "accobble");
		BASALT        = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(BASALT, "basalt");
		BASALTCOBBLE  = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(BASALTCOBBLE, "basalt_cobble");
		MARBLE        = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(MARBLE, "marble");
		GRANITE       = new GenericBlock(1, Material.ROCK);
		CommonProxy.registerBlockWithItem(GRANITE, "granite");
		
		lightSandstone= new SandstoneBlock("sandstone_light");
		darkSandstone = new SandstoneBlock("sandstone_dark");

		/* Misc */
		CHALK         = new BlockChalk();
		CommonProxy.registerBlockWithItem(CHALK, "chalk");
		//shells        = new GenericBlock(1, Material.ROCK, "shells");
		//cursedStone     = new GenericBlock(1, Material.ROCK, "cursedStone");

		/* Fences and Walls */
		//walls         = new WallBlock(beachGrass).setRegistryName("terraWalls");
		//fences        = new FenceBlock().setRegistryName("terraFences");
		BOULDERS = new BlockBoulders();
		CommonProxy.registerBlockWithItem(BOULDERS, "boulders");
		/* Flowers  and Plants */
		FLOWERS = new BlockACFlowers();
		CommonProxy.registerBlockWithCustomItem(FLOWERS, new ItemBlockACFlowers(FLOWERS),"flowers");
		MOSS    = new MossBlock();
		CommonProxy.registerBlockWithItem(MOSS, "moss");
		VINES   = new VineBlock("bluemoss");
		CommonProxy.registerBlockWithItem(VINES, "bluemoss");
		
		/*  Trees Leaves Saplings  */
		LOG1            = new BlockACLog1();
		CommonProxy.registerBlockWithCustomItem(LOG1, new ItemBlockACLog1(LOG1),"log1");
		LOG2 			= new BlockACLog2();
		CommonProxy.registerBlockWithCustomItem(LOG2, new ItemBlockACLog2(LOG2),"log2");
		LEAVES1          = new BlockACLeaves1();
		CommonProxy.registerBlockWithCustomItem(LEAVES1, new ItemBlockACLeaves1(LEAVES1),"leaves1");
		PLANKS1         = new BlockACPlanks1();
		CommonProxy.registerBlockWithCustomItem(PLANKS1, new ItemBlockACPlank1(PLANKS1),"planks");
		PLANKS2         = new BlockACPlanks2();
		CommonProxy.registerBlockWithCustomItem(PLANKS2, new ItemBlockACPlank2(PLANKS2),"planks2");
		SAPLINGS1       = new BlockACSaplings1();
		CommonProxy.registerBlockWithCustomItem(SAPLINGS1, new ItemSaplingBlock1(SAPLINGS1),"saplings1");
		SAPLINGS2       = new BlockACSaplings2();
		CommonProxy.registerBlockWithCustomItem(SAPLINGS2, new ItemSaplingBlock2(SAPLINGS2),"saplings2");
		SHRUBBARY = new BlockShrubbary();
		CommonProxy.registerBlockWithTest(SHRUBBARY, "shrubbary");
		ALIEN_PLANTS_1 = new BlockAlienPlants1();
		CommonProxy.registerBlockWithCustomItem(ALIEN_PLANTS_1, new ItemBlockAlienPlants(ALIEN_PLANTS_1), "alienplants");
		FUNGUS 		    = new BlockFungus();
		CommonProxy.registerBlockWithItem(FUNGUS, "fungus");
		PURPLE_MUSHROOM = new AlienShroom();
		CommonProxy.registerBlockWithItem(PURPLE_MUSHROOM, "purple_mushroom");
		BLUE_MUSHROOM   = new AlienShroom();
		CommonProxy.registerBlockWithItem(BLUE_MUSHROOM, "blue_mushroom");
		BLOCK_MUSHROOM_PURPLE = new BlockAlienMushroom(MapColor.PURPLE, PURPLE_MUSHROOM);
		CommonProxy.registerBlockWithItem(BLOCK_MUSHROOM_PURPLE, "block_mushroom_purple");
		BLOCK_MUSHROOM_BLUE   = new BlockAlienMushroom(MapColor.BLUE, BLUE_MUSHROOM);
		CommonProxy.registerBlockWithItem(BLOCK_MUSHROOM_BLUE, "block_mushroom_blue");
		
		/* Ores  */
		VANILLA_ORES      = new BlockVanillaOres();
		CommonProxy.registerBlockWithCustomItem(VANILLA_ORES, new ItemBlockVanillaOres(VANILLA_ORES),"block_vanilla_ore");
		//oreMethane   = new GenericBlock(1, Material.ROCK, "ore_methane");
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
			//oreAluminum  = new GenericBlock(1, Material.ROCK, "ore_aluminum");
			//oreCopper    = new GenericBlock(1, Material.ROCK, "ore_copper");
			//oreNickel    = new GenericBlock(1, Material.ROCK, "ore_nickel");
			//oreSilver    = new GenericBlock(1, Material.ROCK, "ore_silver");
			//oreLead      = new GenericBlock(1, Material.ROCK, "ore_lead");
			//oreTin       = new GenericBlock(1, Material.ROCK, "ore_tin");
			//oreIridium   = new GenericBlock(1, Material.ROCK, "ore_iridium");
			//orePlatinum  = new GenericBlock(1, Material.ROCK, "ore_platinum");
			//oreMithril   = new GenericBlock(1, Material.ROCK, "ore_mithril");
		}
		if (Loader.isModLoaded("railcraft") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Railcraft, Initializing Ores");
			//oreSaltpeter = new GenericBlock(1, Material.ROCK, "ore_saltpeter");
			//oreSulfur    = new GenericBlock(1, Material.ROCK, "ore_sulfur");
		}
		if (Loader.isModLoaded("techreborn") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello TechReborn, Initializing Ore's");
			//oreUranium    = new GenericBlock(1, Material.ROCK, "ore_uranium");
			//oreBauxite    = new GenericBlock(1, Material.ROCK, "ore_bauxite");
			//oreGalena     = new GenericBlock(1, Material.ROCK, "ore_galena");
			//oreGarneirite = new GenericBlock(1, Material.ROCK, "ore_garneirite");
			
		}
		if (Loader.isModLoaded("forestry") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Forestry, Initializing Ore");
			//oreApatite   = new GenericBlock(1, Material.ROCK, "ore_apatite");
		}
		if (Loader.isModLoaded("mffs") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello MFFS, Initializing Ore");
			//oreMonazit   = new GenericBlock(1, Material.ROCK, "ore_monazit");
		}
		if (Loader.isModLoaded("projectred") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello ProjectRed, Initializing Ore's");
			//oreElectrotine = new GenericBlock(1, Material.ROCK, "ore_electrotine");
			//orePeridot     = new GenericBlock(1, Material.ROCK, "ore_peridot");
			//oreRuby        = new GenericBlock(1, Material.ROCK, "ore_ruby");
			//oreSaphire     = new GenericBlock(1, Material.ROCK, "ore_saphire");
		}
		if (Loader.isModLoaded("appliedenergistics") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Applied Energistics, Initializing Ore");
			//oreCertus = new GenericBlock(1, Material.ROCK, "ore_certus");
		}
		if (Loader.isModLoaded("deepresonance") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello Deep Resonance, Initializing Ore");
			//oreResonating = new GenericBlock(1, Material.ROCK, "ore_resonating");
		}
		if (Loader.isModLoaded("big-reactors") || Config.forceOres)
		{
			AlphaCentauri.logger.info("Hello BigReactors, Initializing Ore");
			//oreYellorite = new GenericBlock(1, Material.ROCK, "ore_yellorite");
		}
		
		

	}
	public static void addFireSpreadInfo() 
	{
		Blocks.FIRE.setFireInfo(ModBlocks.LEAVES1, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.PLANKS1, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.PLANKS2, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.LOG1, 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.LOG2, 30, 60);
	}
}
