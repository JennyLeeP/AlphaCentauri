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
	public static Biome BloodMountains;
	public static Biome DESERT;
	
    public static void initBiomes() 
    {
    	initBiomeTypes();
        registerBiomes();
    }
    public static void initBiomeTypes()
    {
    	// TODO Biome Properties.
        LUSHHILLS        = new BiomeGenLushHills(       new BiomeProperties("LushHills").setTemperature(2.0f).setRainfall(0.3f).setWaterColor(2216227).setBaseHeight(2.0f).setHeightVariation(1.0f));
        GREENRIVER       = new BiomeGenGreenRiver(      new BiomeProperties("GreenRiver").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        LIVINGPLATEAU    = new BiomeGenLivingPlateau(   new BiomeProperties("LivingPlateau").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        BEACH            = new BiomeGenBeach(           new BiomeProperties("Beach").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        VioletBoscage    = new BiomeGenVioletBoscage(   new BiomeProperties("VioletBoscage").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        Morass           = new BiomeGenMorass(          new BiomeProperties("Morass").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(-0.5f).setHeightVariation(0.1f));
        PrimevalForest   = new BiomeGenPrimevalForest(  new BiomeProperties("PrimevalForest").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        Mangroves        = new BiomeGenMangroves(       new BiomeProperties("Mangroves").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        TreacherousHills = new BiomeGenTreacherousHills(new BiomeProperties("TreacherousHills").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        BloodMountains   = new BiomeGenBloodMountains(  new BiomeProperties("BloodMountains").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        DESERT           = new BiomeGenACDesert(        new BiomeProperties("Desert").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());
    }
    public static void registerBiomes()
    {
    	registerBiome(Config.biomeLushHillsID, "LushHills", LUSHHILLS, Type.HILLS);
    	registerBiome(Config.biomeGreenRiverID, "GreenRiver", GREENRIVER, Type.RIVER);
    	registerBiome(Config.biomeLivingPlateauID, "LivingPlateau", LIVINGPLATEAU, Type.MESA);
    	registerBiome(Config.biomeBeachID, "Beach", BEACH, Type.BEACH);
    	registerBiome(Config.biomeVioletBoscageID, "VioletBoscage", VioletBoscage, Type.CONIFEROUS);
    	registerBiome(Config.biomeMorassID, "Morass", Morass, Type.WET);
    	registerBiome(Config.biomePrimevalForestID, "PrimevalForest", PrimevalForest, Type.JUNGLE);
    	registerBiome(Config.biomeMangrovesID, "Mangroves", Mangroves, Type.BEACH);
    	registerBiome(Config.biomeTreacherousHillsID, "TreacherousHills", TreacherousHills, Type.DEAD);
    	registerBiome(Config.biomeBloodMountainsID, "BloodMountains", BloodMountains, Type.MOUNTAIN);
    	registerBiome(Config.desertID, "Desert", DESERT, Type.HOT);
    }
    public static void registerBiome(int id, String name, Biome biome, Type ... types)
    {
    	REGISTRY.register(id, new ResourceLocation(name), biome);
    	BiomeDictionary.registerBiomeType(biome, types);
		BiomeManager.addSpawnBiome(biome);
    }
}
