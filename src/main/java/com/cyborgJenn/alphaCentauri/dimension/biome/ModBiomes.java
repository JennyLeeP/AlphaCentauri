package com.cyborgJenn.alphaCentauri.dimension.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {
	public static final IForgeRegistry<Biome> REGISTRY =  net.minecraftforge.fml.common.registry.ForgeRegistries.BIOMES;
	
	public static Biome LUSHHILLS;
	public static Biome GREENRIVER;
	public static Biome LIVINGPLATEAU;
	public static Biome BEACH;
	public static Biome SPIRAL_FOREST;
	public static Biome Morass;
	public static Biome PrimevalForest;
	public static Biome Mangroves;
	public static Biome HOODOOVALLEY;
	public static Biome PAINTED_CLIFFS;
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
        LUSHHILLS      = new BiomeGenLushHills(     new BiomeProperties("LushHills"     ).setTemperature(2.0f).setBaseHeight(2.0f).setHeightVariation(1.0f).setRainfall(0.3f).setWaterColor(2216227));
        GREENRIVER     = new BiomeGenGreenRiver(    new BiomeProperties("GreenRiver"    ).setTemperature(2.0f).setBaseHeight(1.5f).setHeightVariation(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227));
        LIVINGPLATEAU  = new BiomeGenLivingPlateau( new BiomeProperties("LivingPlateau" ).setTemperature(1.1f).setBaseHeight(0.8f).setHeightVariation(0.0f).setRainfall(1.0f).setWaterColor(2216227));
        BEACH          = new BiomeGenBeach(         new BiomeProperties("Beach"         ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        
        SPIRAL_FOREST  = new BiomeGenSpiralForest(  new BiomeProperties("Spiral_Forest" ).setTemperature(0.8f).setRainfall(1.0f).setWaterColor(2216227).setHeightVariation(0.2f));
        
        Morass         = new BiomeGenMorass(        new BiomeProperties("Morass"        ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(-0.5f).setHeightVariation(0.1f));
        PrimevalForest = new BiomeGenPrimevalForest(new BiomeProperties("PrimevalForest").setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        Mangroves      = new BiomeGenMangroves(     new BiomeProperties("Mangroves"     ).setTemperature(2.0f).setRainfall(1.0f).setSnowEnabled().setWaterColor(2216227).setBaseHeight(1.5f).setHeightVariation(2.0f));
        HOODOOVALLEY   = new BiomeGenHoodooValley(  new BiomeProperties("HoodooValley"  ).setTemperature(2.0f).setBaseHeight(0.8f  ).setHeightVariation(1.2f ).setRainfall(1.0f).setWaterColor(2216227));
        //PAINTED_CLIFFS = new BiomeGenPaintedCliffs( new BiomeProperties("PaintedCliffs" ).setTemperature(1.7f).setBaseHeight(0.7f  ).setHeightVariation(1.1f ).setRainfall(0.1f).setWaterColor(8888844));
        DESERT         = new BiomeGenACDesert(      new BiomeProperties("Desert"        ).setTemperature(2.0F).setBaseHeight(0.125F).setHeightVariation(0.05F).setRainfall(0.0F).setRainDisabled());
        FUNGALFOREST   = new BiomeFungalForest(     new BiomeProperties("FungalForest"  ).setTemperature(1.0F).setBaseHeight(0.125F).setHeightVariation(0.08F).setRainfall(2.0F).setWaterColor(0x222a38));
    }
    public static void registerBiomes()
    {
    	registerBiome("LushHills", LUSHHILLS, Type.HILLS, Type.LUSH);
    	registerBiome("GreenRiver", GREENRIVER, Type.RIVER);
    	registerBiome("LivingPlateau", LIVINGPLATEAU, Type.MESA);
    	registerBiome("Beach", BEACH, Type.BEACH);
    	registerBiome("Spiral_Forest", SPIRAL_FOREST, Type.FOREST, Type.DENSE);
    	registerBiome("Morass", Morass, Type.WET);
    	registerBiome("PrimevalForest", PrimevalForest, Type.JUNGLE);
    	registerBiome("Mangroves", Mangroves, Type.BEACH);
    	registerBiome("HoodooValley", HOODOOVALLEY, Type.DEAD);
    	//registerBiome("PaintedCliffs", PAINTED_CLIFFS, Type.MOUNTAIN);
    	registerBiome("Desert", DESERT, Type.HOT);
    	registerBiome("FungalForest", FUNGALFOREST, Type.MUSHROOM);
    }
    public static void registerBiome(String name, Biome biome, Type ... types)
    {
    	biome.setRegistryName(name);
    	ForgeRegistries.BIOMES.register(biome);
    	BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
    }
}
