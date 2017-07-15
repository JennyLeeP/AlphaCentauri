package com.cyborgJenn.alphaCentauri.module.dimension.biome;

import com.cyborgJenn.alphaCentauri.core.utils.Config;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBiomes {
	public static final RegistryNamespaced<ResourceLocation, Biome> REGISTRY = net.minecraftforge.fml.common.registry.GameData.getBiomeRegistry();
	
	public static Biome LUSHHILLS;
	public static Biome GREENRIVER;
	public static Biome LIVINGPLATEAU;
	public static Biome BEACH;
	public static Biome VioletBoscage;
	public static Biome Morass;
	public static Biome PrimevalForest;
	public static Biome Mangroves;
	public static Biome TreacherousHills;
	public static Biome HOODOO_VALLEY;
	public static Biome DESERT;
	public static Biome FUNGALFOREST;
	
    public static void initBiomes() 
    {
    	initBiomeTypes();
        registerBiomes();
    }
    public static void initBiomeTypes()
    {
    	// TODO Biome Properties.
        LUSHHILLS        = new BiomeGenLushHills(       new BiomeProperties("LushHills"       ).setTemperature(2.0f).setBaseHeight(2.0f).setHeightVariation(1.0f).setRainfall(0.3f).setWaterColor(2216227));
        GREENRIVER       = new BiomeGenGreenRiver(      new BiomeProperties("GreenRiver"      ).setTemperature(2.0f).setBaseHeight(1.5f).setHeightVariation(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227));
        LIVINGPLATEAU    = new BiomeGenLivingPlateau(   new BiomeProperties("LivingPlateau"   ).setTemperature(1.1f).setBaseHeight(0.8f).setHeightVariation(0.0f).setRainfall(1.0f).setWaterColor(2216227));
        BEACH            = new BiomeGenBeach(           new BiomeProperties("Beach"           ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        VioletBoscage    = new BiomeGenVioletBoscage(   new BiomeProperties("VioletBoscage"   ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        Morass           = new BiomeGenMorass(          new BiomeProperties("Morass"          ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(-0.5f).setHeightVariation(0.1f));
        PrimevalForest   = new BiomeGenPrimevalForest(  new BiomeProperties("PrimevalForest"  ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        Mangroves        = new BiomeGenMangroves(       new BiomeProperties("Mangroves"       ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        TreacherousHills = new BiomeGenTreacherousHills(new BiomeProperties("TreacherousHills").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        HOODOO_VALLEY    = new BiomeGenHoodooValley(    new BiomeProperties("HoodooValley"  ).setTemperature(1.7f).setRainfall(0.1f).setSnowEnabled().setWaterColor(8888844).setBaseHeight(0.7f).setHeightVariation(1.1f));
        DESERT           = new BiomeGenACDesert(        new BiomeProperties("Desert"          ).setTemperature(2.0F).setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
        FUNGALFOREST     = new BiomeFungalForest(       new BiomeProperties("FungalForest"    ).setTemperature(1.0F).setBaseHeight(0.125F).setHeightVariation(0.05F).setWaterColor(2216227));
    }
    public static void registerBiomes()
    {
    	registerBiome(Config.biomeLushHillsID, "LushHills", LUSHHILLS, Type.HILLS, Type.LUSH);
    	registerBiome(Config.biomeGreenRiverID, "GreenRiver", GREENRIVER, Type.RIVER);
    	registerBiome(Config.biomeLivingPlateauID, "LivingPlateau", LIVINGPLATEAU, Type.MESA);
    	registerBiome(Config.biomeBeachID, "Beach", BEACH, Type.BEACH);
    	registerBiome(Config.biomeVioletBoscageID, "VioletBoscage", VioletBoscage, Type.CONIFEROUS);
    	registerBiome(Config.biomeMorassID, "Morass", Morass, Type.WET);
    	registerBiome(Config.biomePrimevalForestID, "PrimevalForest", PrimevalForest, Type.JUNGLE);
    	registerBiome(Config.biomeMangrovesID, "Mangroves", Mangroves, Type.BEACH);
    	registerBiome(Config.biomeTreacherousHillsID, "TreacherousHills", TreacherousHills, Type.DEAD);
    	registerBiome(Config.biomeBloodMountainsID, "BloodMountains", HOODOO_VALLEY, Type.MOUNTAIN);
    	registerBiome(Config.desertID, "Desert", DESERT, Type.HOT);
    	registerBiome(Config.fungalID, "FungalForest", FUNGALFOREST, Type.MUSHROOM);
    }
    public static void registerBiome(int id, String name, Biome biome, Type ... types)
    {
    	REGISTRY.register(id, new ResourceLocation(name), biome);
    	BiomeDictionary.registerBiomeType(biome, types);
		BiomeManager.addSpawnBiome(biome);
    }
}
