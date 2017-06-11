package com.cyborgJenn.alphaCentauri.core.item;

import com.cyborgJenn.alphaCentauri.module.accessories.item.ItemPda;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemBalloonPufferfish;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemDepthMeter;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemFancyCompass;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemFlightBoost;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemFlippers;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemGPS;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemLuckyHorshoe;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemSailfishBoots;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemSextant;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemShoeSpikes;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemStopWatch;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemSwimGoggles;
import com.cyborgJenn.alphaCentauri.module.accessories.item.accessory.ItemTallyCounter;
import com.cyborgJenn.alphaCentauri.module.combat.item.Sword1;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems 
{
	/* 
	 * Accessory Items 
	 */
	public static Item FancyCompass;
	public static Item DepthMeter;
	public static Item GPS;
	public static Item Sextant;
	public static Item ShoeSpikes;
	public static Item ClimbingClaws;
	public static Item ClimbingGear;
	public static Item StopWatch;
	public static Item TallyCounter;
	public static Item BalloonPufferfish;
	public static Item SailfishBoots;
	public static Item FlightBoost;
	public static Item Flippers;
	public static Item SwimGoggles;
	public static Item LuckyHorshoe;
	public static Item Pda;
	
	public static Item Sword1;
	public static Item Sword2;
	public static Item Sword3;
	public static Item Sword4;
	public static Item Sword5;
	
	public static ToolMaterial DOUBLEHELIX = EnumHelper.addToolMaterial("DOUBLEHELIX", 3, 1561, 12.0F, 3.0F, 30);
	public static ToolMaterial PHANTOMMETAL = EnumHelper.addToolMaterial("PHANTOMMETAL", 3, 1561, 12.0F, 3.0F, 30);
	public static ToolMaterial TUTORIAL3 = EnumHelper.addToolMaterial("TUTORIAL3", 3, 1561, 12.0F, 3.0F, 30);
	public static ToolMaterial TUTORIAL4 = EnumHelper.addToolMaterial("TUTORIAL4", 3, 1561, 12.0F, 3.0F, 30);
	public static ToolMaterial TUTORIAL5 = EnumHelper.addToolMaterial("TUTORIAL5", 3, 1561, 12.0F, 3.0F, 30);
	
		
	public static void initAccessoryItems() 
	{	
		FancyCompass 		= new ItemFancyCompass();
		DepthMeter 			= new ItemDepthMeter();
		GPS 				= new ItemGPS();
		Sextant				= new ItemSextant();
		ShoeSpikes			= new ItemShoeSpikes("shoeSpikes");
		ClimbingClaws		= new ItemShoeSpikes("climbingClaws");
		ClimbingGear		= new ItemShoeSpikes("climbingGear");
		StopWatch			= new ItemStopWatch();
		TallyCounter		= new ItemTallyCounter();
		BalloonPufferfish 	= new ItemBalloonPufferfish();
		SailfishBoots		= new ItemSailfishBoots();
		FlightBoost			= new ItemFlightBoost();
		Flippers			= new ItemFlippers();
		SwimGoggles			= new ItemSwimGoggles();
		LuckyHorshoe		= new ItemLuckyHorshoe();
		Pda					= new ItemPda();
		
	}
	@SuppressWarnings("deprecation")
	public static void registerAccessoryItems()
	{
		GameRegistry.registerItem(FancyCompass,"fancyCompass");
		GameRegistry.registerItem(DepthMeter,"depthMeter");
		GameRegistry.registerItem(GPS,"gps");
		GameRegistry.registerItem(Sextant,"sextant");
		GameRegistry.registerItem(ShoeSpikes,"shoeSpikes");
		GameRegistry.registerItem(ClimbingClaws,"climbingClaws");
		GameRegistry.registerItem(ClimbingGear,"climbingGear");
		GameRegistry.registerItem(StopWatch,"stopWatch");
		GameRegistry.registerItem(TallyCounter,"tallyCounter");
		GameRegistry.registerItem(BalloonPufferfish,"balloonPufferfish");
		GameRegistry.registerItem(SailfishBoots,"sailfishBoots");
		GameRegistry.registerItem(FlightBoost, "flightBoost");
		GameRegistry.registerItem(Flippers, "flippers");
		GameRegistry.registerItem(SwimGoggles, "swimGoggles");
		GameRegistry.registerItem(LuckyHorshoe, "luckyHorseshoe");
		GameRegistry.registerItem(Pda, "pda");
	}
	/* 
	 * Combat Items 
	 */
	public static void initCombatItems()
	{
		Sword1 = new Sword1(DOUBLEHELIX,"sword1");
		Sword2 = new Sword1(PHANTOMMETAL,"sword2");
		Sword3 = new Sword1(TUTORIAL3,"sword3");
		Sword4 = new Sword1(TUTORIAL4,"sword4");
		Sword5 = new Sword1(TUTORIAL5,"sword5");
	}
	@SuppressWarnings("deprecation")
	public static void registerCombatItems()
	{
		GameRegistry.registerItem(Sword1,"sword1");
		GameRegistry.registerItem(Sword2,"sword2");
		GameRegistry.registerItem(Sword3,"sword3");
		GameRegistry.registerItem(Sword4,"sword4");
		GameRegistry.registerItem(Sword5,"sword5");
	}
}
