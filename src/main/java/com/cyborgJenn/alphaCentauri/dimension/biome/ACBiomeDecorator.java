package com.cyborgJenn.alphaCentauri.dimension.biome;

import java.util.Random;

import com.cyborgJenn.alphaCentauri.blocks.BlockACGravel;
import com.cyborgJenn.alphaCentauri.blocks.BlockVanillaOres;
import com.cyborgJenn.alphaCentauri.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenACMinable;
import com.cyborgJenn.alphaCentauri.dimension.generators.WorldGenLargeMushroom;
import com.cyborgJenn.alphaCentauri.utils.Config;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;

public class ACBiomeDecorator extends BiomeDecorator 
{
	public ChunkGeneratorSettings chunkProviderSettings;

	/*    Vanilla    */
	public WorldGenerator dirt;
	public WorldGenerator gravel;
	public WorldGenerator iron;
	public WorldGenerator gold;
	public WorldGenerator diamond;
	public WorldGenerator emerald;
	public WorldGenerator lapis;
	public WorldGenerator redstone;
	public WorldGenerator coal;

	/*     Thermal Foundation   */
	public WorldGenerator copper;
	public WorldGenerator tin;
	public WorldGenerator silver;
	public WorldGenerator lead;
	public WorldGenerator ferrous;
	public WorldGenerator iridium;
	public WorldGenerator aluminum;
	public WorldGenerator platinum;
	public WorldGenerator mithril;
	/*      Forestry            */
	public WorldGenerator apatite;
	/*   Applied Energistics    */
	public WorldGenerator certus;
	/*      RailCraft           */
	public WorldGenerator saltpeter;
	public WorldGenerator sulphur;
	/*      MFFS                */
	public WorldGenerator monazit;
	/*      TechReborn          */
	public WorldGenerator uranium;
	public WorldGenerator bauxite;
	public WorldGenerator galena;
	public WorldGenerator garneirite;
	/*     ProjectRed           */
	public WorldGenerator electrotine;
	public WorldGenerator ruby;
	public WorldGenerator saphire;
	public WorldGenerator peridot;
	/*     Deep Resonance       */
	public WorldGenerator resonating;
	/*     Big Reactors         */
	public WorldGenerator yellorite;

	public WorldGenerator cursedNodesGen;
	public int nodesPerChunk;

	public WorldGenerator flowersGen;
	public int flowersPerChunk;

	public WorldGenerator methIceGen;
	public int methIcePerChunk;

	/*       Mushrooms         */
	public int mushroomsPerChunk;
	public int bigMushroomsPerChunk;
	public WorldGenerator mushroomBlueGen = new WorldGenBush(ModBlocks.BLUE_MUSHROOM);
	public WorldGenerator mushroomPurpleGen = new WorldGenBush(ModBlocks.PURPLE_MUSHROOM);
	public WorldGenerator bigMushroomGen = new WorldGenLargeMushroom();
	/*       Trees             */
	public int treesPerChunk;
    public float extraTreeChance = 0.0F;
	/*       Moss and Grass    */
    public WorldGenerator mossGen = new WorldGenBush(ModBlocks.MOSS);
    public int mossPerChunk;
	public int grassPerChunk;

	public ACBiomeDecorator(Biome biomeGenBase) 
	{
		super();
	}
	@Override
	public void decorate(World worldIn, Random random, Biome biome, BlockPos pos)
	{
		if (this.decorating)
		{
			throw new RuntimeException("Already decorating");
		}
		else
		{
			this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
			this.chunkPos = pos;
			this.dirt     = new WorldGenACMinable(ModBlocks.ACDIRT.getDefaultState(), this.chunkProviderSettings.dirtSize);
			this.gravel   = new WorldGenACMinable(ModBlocks.GRAVEL.getDefaultState().withProperty(BlockACGravel.VARIANT, BlockACGravel.EnumType.BLUE), this.chunkProviderSettings.gravelSize);
			this.iron     = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.IRON), this.chunkProviderSettings.ironSize);
			this.gold     = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.GOLD), this.chunkProviderSettings.goldSize);
			this.diamond  = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.DIAMOND), this.chunkProviderSettings.diamondSize);
			this.lapis    = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.LAPIS), this.chunkProviderSettings.lapisSize);
			this.emerald  = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.EMERALD), 6);
			this.redstone = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.REDSTONE), this.chunkProviderSettings.redstoneSize);
			this.coal     = new WorldGenACMinable(ModBlocks.VANILLA_ORES.getDefaultState().withProperty(BlockVanillaOres.VARIANT, BlockVanillaOres.EnumType.COAL), this.chunkProviderSettings.coalSize);
			if (Loader.isModLoaded("thermalfoundation") || Config.forceOres)
			{
				this.aluminum  = new WorldGenACMinable(ModBlocks.oreAluminum.getDefaultState(), 6);
				this.copper    = new WorldGenACMinable(ModBlocks.oreCopper.getDefaultState(),     8);
				this.ferrous   = new WorldGenACMinable(ModBlocks.oreNickel.getDefaultState(),     4);
				this.lead      = new WorldGenACMinable(ModBlocks.oreLead.getDefaultState(),       8);
				this.silver    = new WorldGenACMinable(ModBlocks.oreSilver.getDefaultState(),     8);
				this.tin       = new WorldGenACMinable(ModBlocks.oreTin.getDefaultState(),       12);
				this.iridium   = new WorldGenACMinable(ModBlocks.oreIridium.getDefaultState(),    1);
				this.platinum   = new WorldGenACMinable(ModBlocks.orePlatinum.getDefaultState(),    3);
				this.mithril   = new WorldGenACMinable(ModBlocks.oreMithril.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("railcraft") || Config.forceOres)
			{
				this.sulphur   = new WorldGenACMinable(ModBlocks.oreSulfur.getDefaultState(),     8);
				this.saltpeter = new WorldGenACMinable(ModBlocks.oreSaltpeter.getDefaultState(), 12);
			}
			if (Loader.isModLoaded("forestry") || Config.forceOres)
			{
				this.apatite   = new WorldGenACMinable(ModBlocks.oreApatite.getDefaultState(),   12);
			}
			if (Loader.isModLoaded("techreborn") || Config.forceOres)
			{
				this.uranium   = new WorldGenACMinable(ModBlocks.oreIridium.getDefaultState(),    4);
				this.bauxite   = new WorldGenACMinable(ModBlocks.oreBauxite.getDefaultState(),    4);
				this.galena   = new WorldGenACMinable(ModBlocks.oreGalena.getDefaultState(),    4);
				this.garneirite   = new WorldGenACMinable(ModBlocks.oreGarneirite.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("mffs") || Config.forceOres)
			{
				this.monazit   = new WorldGenACMinable(ModBlocks.oreMonazit.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("projectred") || Config.forceOres)
			{
				this.electrotine   = new WorldGenACMinable(ModBlocks.oreElectrotine.getDefaultState(),    4);
				this.ruby   = new WorldGenACMinable(ModBlocks.oreRuby.getDefaultState(),    4);
				this.saphire   = new WorldGenACMinable(ModBlocks.oreSaphire.getDefaultState(),    4);
				this.peridot   = new WorldGenACMinable(ModBlocks.orePeridot.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("appliedenergistics") || Config.forceOres)
			{
				this.certus   = new WorldGenACMinable(ModBlocks.oreCertus.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("deepresonance") || Config.forceOres)
			{
				this.resonating   = new WorldGenACMinable(ModBlocks.oreResonating.getDefaultState(),    4);
			}
			if (Loader.isModLoaded("big-reactors") || Config.forceOres)
			{
				this.yellorite   = new WorldGenACMinable(ModBlocks.oreYellorite.getDefaultState(),    4);
			}
			this.genDecorations(biome, worldIn, random);
			this.decorating = false;
		}
	}
	/**
	 * The method that does the work of actually decorating chunks
	 */
	@Override
	protected void genDecorations(Biome biomeIn, World worldIn, Random random)
	{
		MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre(worldIn, random, chunkPos));
		this.generateOres(worldIn, random);

		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND))
			for (int i = 0; i < this.sandPatchesPerChunk; ++i)
			{
				int j = random.nextInt(16) + 8;
				int k = random.nextInt(16) + 8;
				this.sandGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(j, 0, k)));
			}
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2))
			for (int j1 = 0; j1 < this.gravelPatchesPerChunk; ++j1)
			{
				int i2 = random.nextInt(16) + 8;
				int j6 = random.nextInt(16) + 8;
				this.gravelGen.generate(worldIn, random, worldIn.getTopSolidOrLiquidBlock(this.chunkPos.add(i2, 0, j6)));
			}
		/*
        doGen = TerrainGen.decorate(currentWorld, randomGenerator, chunk_X, chunk_Z, CLAY);
        for (i = 0; doGen && i < this.methIcePerChunk; ++i)
        {
            j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
            k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
            this.methIceGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
        }
		 */

		/* ------------------------------------
		 *               Mushrooms    
		 --------------------------------------*/
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM))
	        for (int k2 = 0; k2 < this.bigMushroomsPerChunk; ++k2)
	        {
	            int l6 = random.nextInt(16) + 8;
	            int k10 = random.nextInt(16) + 8;
	            this.bigMushroomGen.generate(worldIn, random, worldIn.getHeight(this.chunkPos.add(l6, 0, k10)));
	        }
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM))
		{
			for (int l3 = 0; l3 < this.mushroomsPerChunk; ++l3)
			{
				if (random.nextInt(4) == 0)
				{
					int i8 = random.nextInt(16) + 8;
					int l11 = random.nextInt(16) + 8;
					BlockPos blockpos2 = worldIn.getHeight(this.chunkPos.add(i8, 0, l11));
					this.mushroomBlueGen.generate(worldIn, random, blockpos2);
				}

				if (random.nextInt(8) == 0)
				{
					int j8 = random.nextInt(16) + 8;
					int i12 = random.nextInt(16) + 8;
					int j15 = worldIn.getHeight(this.chunkPos.add(j8, 0, i12)).getY() * 2;

					if (j15 > 0)
					{
						int k18 = random.nextInt(j15);
						BlockPos blockpos5 = this.chunkPos.add(j8, k18, i12);
						this.mushroomPurpleGen.generate(worldIn, random, blockpos5);
					}
				}
			}

		
		} 
		/* -------------------------------------
		 *               Flowers
		 * -------------------------------------
		 */
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS))
			for (int l2 = 0; l2 < this.flowersPerChunk; ++l2)
			{
				int i7 = random.nextInt(16) + 8;
				int l10 = random.nextInt(16) + 8;
				int j14 = worldIn.getHeight(this.chunkPos.add(i7, 0, l10)).getY() + 32;

				if (j14 > 0)
				{
					int k17 = random.nextInt(j14);
					BlockPos blockpos1 = this.chunkPos.add(i7, k17, l10);
					BlockFlower.EnumFlowerType blockflower$enumflowertype = biomeIn.pickRandomFlower(random, blockpos1);
					BlockFlower blockflower = blockflower$enumflowertype.getBlockType().getBlock();

					if (blockflower.getDefaultState().getMaterial() != Material.AIR)
					{
						//TODO generate random flower.
						//this.yellowFlowerGen.setGeneratedBlock(blockflower, blockflower$enumflowertype);
						//this.yellowFlowerGen.generate(worldIn, random, blockpos1);

					}
				}
			}
		for (int j = 0; j < flowersPerChunk; ++j)
		{
			//k = chunk_X + randomGenerator.nextInt(16) + 8;
			//l = randomGenerator.nextInt(128);
			//i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
			//flowersGen.generate(worldIn, random, blockPos, l, i1);
		}
		for (int j = 0; j < nodesPerChunk; ++j)
		{
			//k = chunk_X + randomGenerator.nextInt(16) + 8;
			//l = randomGenerator.nextInt(128);
			// i1 = chunk_Z + randomGenerator.nextInt(16) + 8;
			//cursedNodesGen.generate(currentWorld, randomGenerator, k, l, i1);
		}
		
		/* --------------------------------------
		 *                Trees 
		 ---------------------------------------*/
		int k1 = this.treesPerChunk;

		if (random.nextFloat() < this.extraTreeChance)
		{
			++k1;
		}

		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE))
			for (int j2 = 0; j2 < k1; ++j2)
	        {
	            int k6 = random.nextInt(16) + 8;
	            int l = random.nextInt(16) + 8;
	            WorldGenAbstractTree worldgenabstracttree = biomeIn.getRandomTreeFeature(random);
	            //worldgenabstracttree.setDecorationDefaults();
	            BlockPos blockpos = worldIn.getHeight(this.chunkPos.add(k6, 0, l));

	            if (worldgenabstracttree.generate(worldIn, random, blockpos))
	            {
	                worldgenabstracttree.generateSaplings(worldIn, random, blockpos);
	            }
			}
		/* ----------------------------------
		 *           Grass and Moss
		   ----------------------------------*/
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CUSTOM))
			for (int g3 = 0; g3 < this.mossPerChunk; ++g3)
			{
				//TODO moss needs work, placement rules and can stay.
				int m7 = random.nextInt(16) + 8;
				int m11 = random.nextInt(16) + 8;
				int m14 = worldIn.getHeight(this.chunkPos.add(m7, 0, m11)).getY() * 2;
				if (m14 > 0)
				{
					int m18 = random.nextInt(m14);
					BlockPos blockposM = this.chunkPos.add(m7, m18, m11);
					this.mossGen.generate(worldIn, random, blockposM);
				}
			}
		if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, random, chunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
			for (int i3 = 0; i3 < this.grassPerChunk; ++i3)
			{
				int j7 = random.nextInt(16) + 8;
				int i11 = random.nextInt(16) + 8;
				int k14 = worldIn.getHeight(this.chunkPos.add(j7, 0, i11)).getY() * 2;
				if (k14 > 0)
				{
					int l17 = random.nextInt(k14);
					biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random, this.chunkPos.add(j7, l17, i11));
				}
			}
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post(worldIn, random, chunkPos));
	}
	
	/**
	 * Generates ores in the current chunk
	 */
	@Override
	protected void generateOres(World worldIn, Random random)
	{
		net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Pre(worldIn, random, chunkPos));

		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, dirtGen, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIRT))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.dirtCount, this.dirt, this.chunkProviderSettings.dirtMinHeight, this.chunkProviderSettings.dirtMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, gravel, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GRAVEL))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.gravelCount, this.gravel, this.chunkProviderSettings.gravelMinHeight, this.chunkProviderSettings.gravelMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, coal, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.coalCount, this.coal, this.chunkProviderSettings.coalMinHeight, this.chunkProviderSettings.coalMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, iron, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.ironCount, this.iron, this.chunkProviderSettings.ironMinHeight, this.chunkProviderSettings.ironMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, gold, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.goldCount, this.gold, this.chunkProviderSettings.goldMinHeight, this.chunkProviderSettings.goldMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, redstone, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.redstoneCount, this.redstone, this.chunkProviderSettings.redstoneMinHeight, this.chunkProviderSettings.redstoneMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, diamond, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND))
			this.genStandardOre1(worldIn, random, this.chunkProviderSettings.diamondCount, this.diamond, this.chunkProviderSettings.diamondMinHeight, this.chunkProviderSettings.diamondMaxHeight);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, lapis, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS))
			this.genStandardOre2(worldIn, random, this.chunkProviderSettings.lapisCount, this.lapis, this.chunkProviderSettings.lapisCenterHeight, this.chunkProviderSettings.lapisSpread);
		if (Loader.isModLoaded("thermalfoundation") || Config.forceOres) { genTFOres(worldIn, random); }
		if (Loader.isModLoaded("railcraft") || Config.forceOres) { genRCOres(worldIn, random); }
		if (Loader.isModLoaded("forestry") || Config.forceOres) { genForestryOres(worldIn, random); }
		if (Loader.isModLoaded("techreborn") || Config.forceOres) { genTechROres(worldIn, random); }
		if (Loader.isModLoaded("mffs") || Config.forceOres ) { genMFFSOres(worldIn, random); }
		if (Loader.isModLoaded("projectred") || Config.forceOres) { genPROres(worldIn, random); }
		if (Loader.isModLoaded("appliedenergistics") || Config.forceOres) { genAEOres(worldIn, random); }
		if (Loader.isModLoaded("deepresonance") || Config.forceOres) { genDROres(worldIn, random); }
		if (Loader.isModLoaded("big-reactors") || Config.forceOres) { genBROres(worldIn, random); }

		net.minecraftforge.common.MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(worldIn, random, chunkPos));

	}
	/**
	 * Standard ore generation helper. Generates most ores.
	 */
	@Override
	protected void genStandardOre1(World worldIn, Random random, int blockCount, WorldGenerator generator, int minHeight, int maxHeight)
	{
		if (maxHeight < minHeight)
		{
			int i = minHeight;
			minHeight = maxHeight;
			maxHeight = i;
		}
		else if (maxHeight == minHeight)
		{
			if (minHeight < 255)
			{
				++maxHeight;
			}
			else
			{
				--minHeight;
			}
		}

		for (int j = 0; j < blockCount; ++j)
		{
			BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(maxHeight - minHeight) + minHeight, random.nextInt(16));
			generator.generate(worldIn, random, blockpos);
		}
	}
	/**
	 * Standard ore generation helper. Vanilla uses this to generate Lapis Lazuli.
	 * The main difference between this and {@link #genStandardOre1} is that this takes takes center and spread, while
	 * genStandardOre1 takes min and max heights.
	 */
	@Override
	protected void genStandardOre2(World worldIn, Random random, int blockCount, WorldGenerator generator, int centerHeight, int spread)
	{
		for (int i = 0; i < blockCount; ++i)
		{
			BlockPos blockpos = this.chunkPos.add(random.nextInt(16), random.nextInt(spread) + random.nextInt(spread) + centerHeight - spread, random.nextInt(16));
			generator.generate(worldIn, random, blockpos);
		}
	}
	private void genTFOres(World worldIn, Random random)
	{
		//TODO maybe get ore spawn rates from TF. or set spawn rates based on FTB or something.
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, copper, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 12, this.copper, 40, 75);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, tin, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 9, this.tin, 20, 55);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, silver, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.silver, 5, 30);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, lead, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.lead, 2, 35);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, ferrous, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 2, this.ferrous, 5, 20);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, iridium, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.iridium, 0, 64);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, aluminum, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 2, this.aluminum, 0, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, platinum, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 2, this.platinum, 0, 32);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, mithril, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 2, this.mithril, 0, 32);
	}
	private void genRCOres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, saltpeter, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.saltpeter, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, sulphur, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.sulphur, 30, 128);
	}
	private void genForestryOres(World worldIn, Random random) 
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, apatite, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.apatite, 30, 128);
	}
	private void genTechROres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, uranium, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			this.genStandardOre1(worldIn, random, 4, this.uranium, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, bauxite, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.bauxite, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, galena, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.galena, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, garneirite, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.garneirite, 30, 128);
	}
	private void genMFFSOres(World worldIn, Random random) 
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, monazit, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.monazit, 30, 128);	
	}
	private void genPROres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, electrotine, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.electrotine, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, ruby, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.ruby, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, saphire, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.saphire, 30, 128);
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, peridot, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.peridot, 30, 128);
	}
	private void genAEOres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, certus, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.certus, 30, 128);
	}
	private void genDROres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, resonating, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.resonating, 30, 128);
	}
	private void genBROres(World worldIn, Random random)
	{
		if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(worldIn, random, yellorite, chunkPos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(worldIn, random, 4, this.yellorite, 30, 128);
	}
}
