package com.cyborgJenn.alphaCentauri.core.proxy;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.core.handlers.KeyInputHandler;
import com.cyborgJenn.alphaCentauri.core.item.ModItems;
import com.cyborgJenn.alphaCentauri.core.utils.Reference;
import com.cyborgJenn.alphaCentauri.module.accessories.gui.GuiAccessory;
import com.cyborgJenn.alphaCentauri.module.accessories.render.RenderHud;
import com.cyborgJenn.alphaCentauri.module.dimension.blocks.ModBlocks;
import com.cyborgJenn.alphaCentauri.module.dimension.util.Registry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerHudRenderer()
	{
		MinecraftForge.EVENT_BUS.register(new RenderHud(Minecraft.getMinecraft()));

	}
	@Override
	public void registerAccessoryRenderers()
	{
		registerItemRenderers(ModItems.FancyCompass);
		registerItemRenderers(ModItems.ClimbingClaws);
		registerItemRenderers(ModItems.ClimbingGear);
		registerItemRenderers(ModItems.DepthMeter);
		registerItemRenderers(ModItems.GPS);
		registerItemRenderers(ModItems.Sextant);
		registerItemRenderers(ModItems.ShoeSpikes);
		registerItemRenderers(ModItems.StopWatch);
		registerItemRenderers(ModItems.TallyCounter);
		registerItemRenderers(ModItems.BalloonPufferfish);
		registerItemRenderers(ModItems.SailfishBoots);
		registerItemRenderers(ModItems.FlightBoost);
		registerItemRenderers(ModItems.Flippers);
		registerItemRenderers(ModItems.SwimGoggles);
		registerItemRenderers(ModItems.LuckyHorshoe);
		registerItemRenderers(ModItems.Pda);
	}
	@Override
	public void registerCombatRenderers()
	{
		registerItemRenderers(ModItems.Sword1);
		registerItemRenderers(ModItems.Sword2);
		registerItemRenderers(ModItems.Sword3);
		registerItemRenderers(ModItems.Sword4);
		registerItemRenderers(ModItems.Sword5);
	}
	@Override
	public void registerDimensionRenderers()
	{
		registerItemBlockRender(ModBlocks.gateAlphaCentauri);
		registerItemBlockRender(ModBlocks.alphaCentauriPortal);
		registerItemBlockRender(ModBlocks.acStone);
		registerItemBlockRender(ModBlocks.acStone);
		registerItemBlockRender(ModBlocks.acDirt);
		registerItemBlockRender(ModBlocks.acGrass);
		registerItemBlockRender(ModBlocks.marble);
		registerItemBlockRender(ModBlocks.granite);
		registerItemBlockRender(ModBlocks.peat);
		registerItemBlockRender(ModBlocks.darkSand);
		registerItemBlockRender(ModBlocks.lightSand);
		registerItemBlockRender(ModBlocks.blueGravel);
		registerItemBlockRender(ModBlocks.darkGravel);
		registerItemBlockRender(ModBlocks.purpleGravel);
		registerItemBlockRender(ModBlocks.redGravel);
		registerItemBlockRender(ModBlocks.rustyGravel);
		registerItemBlockRender(ModBlocks.acCobble);
		registerItemBlockRender(ModBlocks.cursedStone);
		registerItemBlockRender(ModBlocks.vines);
		/* Flowers  */
		registerItemBlockRender(ModBlocks.whiteFlower);
		registerItemBlockRender(ModBlocks.orangeFlower);
		registerItemBlockRender(ModBlocks.magentaFlower);
		registerItemBlockRender(ModBlocks.blackFlower);
		registerItemBlockRender(ModBlocks.blueFlower);
		registerItemBlockRender(ModBlocks.brownFlower);
		registerItemBlockRender(ModBlocks.cyanFlower);
		registerItemBlockRender(ModBlocks.grayFlower);
		registerItemBlockRender(ModBlocks.greenFlower);
		registerItemBlockRender(ModBlocks.lightBlueFlower);
		registerItemBlockRender(ModBlocks.lightGrayFlower);
		registerItemBlockRender(ModBlocks.limeFlower);
		registerItemBlockRender(ModBlocks.pinkFlower);
		registerItemBlockRender(ModBlocks.purpleFlower);
		registerItemBlockRender(ModBlocks.redFlower);
		registerItemBlockRender(ModBlocks.yellowFlower);
		/*    Ore's    */
		registerItemBlockRender(ModBlocks.oreAluminum);
		registerItemBlockRender(ModBlocks.oreApatite);
		registerItemBlockRender(ModBlocks.oreBauxite);
		registerItemBlockRender(ModBlocks.oreCertus);
		registerItemBlockRender(ModBlocks.oreCoal);
		registerItemBlockRender(ModBlocks.oreCopper);
		registerItemBlockRender(ModBlocks.oreDiamond);
		registerItemBlockRender(ModBlocks.oreElectrotine);
		registerItemBlockRender(ModBlocks.oreEmerald);
		registerItemBlockRender(ModBlocks.oreGalena);
		registerItemBlockRender(ModBlocks.oreGarneirite);
		registerItemBlockRender(ModBlocks.oreGold);
		registerItemBlockRender(ModBlocks.oreIridium);
		registerItemBlockRender(ModBlocks.oreIron);
		registerItemBlockRender(ModBlocks.oreLapis);
		registerItemBlockRender(ModBlocks.oreLead);
		registerItemBlockRender(ModBlocks.oreMethane);
		registerItemBlockRender(ModBlocks.oreMithril);
		registerItemBlockRender(ModBlocks.oreMonazit);
		registerItemBlockRender(ModBlocks.oreNickel);
		registerItemBlockRender(ModBlocks.orePeridot);
		registerItemBlockRender(ModBlocks.orePlatinum);
		registerItemBlockRender(ModBlocks.oreRedstone);
		registerItemBlockRender(ModBlocks.oreResonating);
		registerItemBlockRender(ModBlocks.oreRuby);
		registerItemBlockRender(ModBlocks.oreSaltpeter);
		registerItemBlockRender(ModBlocks.oreSaphire);
		registerItemBlockRender(ModBlocks.oreSilver);
		registerItemBlockRender(ModBlocks.oreSulfur);
		registerItemBlockRender(ModBlocks.oreTin);
		registerItemBlockRender(ModBlocks.oreUranium);
		registerItemBlockRender(ModBlocks.oreYellorite);
		registerItemBlockRender(ModBlocks.FUNGUS);
		/*   Plants   */
		registerItemBlockRender(ModBlocks.PURPLE_MUSHROOM);
		registerItemBlockRender(ModBlocks.BLUE_MUSHROOM);
		registerMetaBlockRender(ModBlocks.LOG1, 0, "spiral_log");
		registerMetaBlockRender(ModBlocks.LOG1, 1, "splotch_log");
		registerMetaBlockRender(ModBlocks.SAPLINGS1, 0, "spiral_sapling");
		registerMetaBlockRender(ModBlocks.SAPLINGS1, 1, "splotch_sapling");
		
		registerItemBlockRender(ModBlocks.MOSS);
		registerItemBlockRender(ModBlocks.BLOCK_MUSHROOM_PURPLE);
		registerItemBlockRender(ModBlocks.BLOCK_MUSHROOM_BLUE);
		
		
	}
	@Override
	public void registerKeyBindings() 
	{
		keyHandler = new KeyInputHandler();
		MinecraftForge.EVENT_BUS.register(keyHandler);

	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (world instanceof WorldClient) 
		{
			switch (ID) 
			{
			case Reference.ACCESSORYGUI: return new GuiAccessory(player);
			}
		}
		return null;
	}
	@Override
	public World getClientWorld() 
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}
	public static void registerItemBlockRender(Block block) 
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	public static void registerMetaBlockRender(Block block, int meta, String file) 
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + file, "inventory"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ModelResourceLocation(Reference.MODID + ":" + file, "inventory"));
	}
	public static void registerItemRenderers(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
