package com.cyborgJenn.alphaCentauri.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;
import com.cyborgJenn.alphaCentauri.interfaces.IItemWithMeshDefinition;
import com.cyborgJenn.alphaCentauri.utils.IMetaLookup;
import com.cyborgJenn.alphaCentauri.utils.Reference;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod.EventBusSubscriber
@ObjectHolder(Reference.MODID)
public class CommonProxy {

	private List<Block> blocksToReg = new ArrayList<Block>();
	private List<Item>  itemsToReg  = new ArrayList<Item>();
	protected HashMap<Block,Item> blockItems = new HashMap<Block,Item>();
	
	/**
	 * Registers simple Block, with no item.
	 * Nothing is added to CreativeTab.
	 * @param block
	 * @param registryname
	 */
	public static void registerBlock(Block block, String registryname) {
		AlphaCentauri.proxy._registerBlock(block, registryname);
	}
	/**
	 * Registers Block with ItemBlocks.
	 * This is the typical goto Registry for most blocks.
	 * Block is automatically added to CreativeTab
	 * @param block
	 * @param registryname
	 */
	public static void registerBlockWithItem(Block block, String registryname) {
		AlphaCentauri.proxy._registerBlockWithItem(block, registryname);
	}
	/**
	 * Register Blocks with custom item, I.E for example custom ItemBlock.class.
	 * Block and variants are automatically added to CreativeTab
	 * @param block
	 * @param iBlock
	 * @param registryname
	 */
	public static void registerBlockWithCustomItem(Block block, ItemBlock iBlock, String registryname) {
		AlphaCentauri.proxy._registerBlockWithCustomItem(block, iBlock, registryname);
	}
	/**
	 * Register Item's
	 * @param item
	 * @param registryname
	 */
	public static void registerItem(Item item, String registryname) {
		AlphaCentauri.proxy._registerItem(item, registryname);
	}
	/**
	 * Register Item with Variants
	 * @param item
	 * @param registryname
	 * @param variant
	 */
	public static <T extends IMetaLookup> void registerItemWithVariants(Item item, String registryname, T variant) {
		AlphaCentauri.proxy._registerItemWithVariants(item, registryname, variant);
	}
	/**
	 * Register Item with Resource location and Unlocalized name.
	 * @param item
	 * @param registryname
	 * @param unlocalized
	 */
	public static void registerItem(Item item, ResourceLocation registryname, String unlocalized) {
		AlphaCentauri.proxy._registerItem(item, registryname, unlocalized);
	}
	/**
	 * Registers a specific model for variant item stack.
	 * @param item - Must implement IItemWithMeshDefinition
	 * @param variantStack
	 */
	public static <T extends Item & IItemWithMeshDefinition> void registerSpecificItemVariantsWithBakery(T item, ItemStack variantStack) {
		AlphaCentauri.proxy._registerSpecificItemVariantsWithBakery(item, variantStack);
	}
	
	/*===========================================================================
	 * 
	 * Below are Internal proxy methods, 
	 * 	not called from outside CommonProxy or ClientProxy.
	 * 
	 */
	public void _registerBlock(Block block, String registryname) 
	{
		block.setRegistryName(registryname);
		block.setUnlocalizedName(block.getRegistryName().toString());
		block.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		blocksToReg.add(block);
	}
	
	public void _registerBlockWithItem(Block block, String registryname) 
	{
		block.setRegistryName(registryname);
		block.setUnlocalizedName(block.getRegistryName().toString());
		ItemBlock ib = new ItemBlock(block);
		ib.setRegistryName(registryname);
		block.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		blocksToReg.add(block);
		itemsToReg.add(ib);
		blockItems.put(block, ib);
	}
	public void _registerBlockWithCustomItem(Block block, ItemBlock iBlock, String registryname) {
		block.setRegistryName(registryname);
		block.setUnlocalizedName(block.getRegistryName().toString());
		iBlock.setRegistryName(registryname);
		block.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		blocksToReg.add(block);
		itemsToReg.add(iBlock);
		blockItems.put(block, iBlock);
	}
	
	public void _registerItem(Item item, String registryname) 
	{
		item.setRegistryName(registryname);
		item.setUnlocalizedName(item.getRegistryName().toString());
		itemsToReg.add(item);
	}
	
	public <T extends Item & IItemWithMeshDefinition> void _registerSpecificItemVariantsWithBakery(T item, ItemStack variantStack) {
		//client only
	}
	
	public <T extends IMetaLookup> void _registerItemWithVariants(Item item, String registryname, T variant) 
	{
		item.setRegistryName(registryname);
		item.setUnlocalizedName(item.getRegistryName().toString());
		itemsToReg.add(item);
	}
	
	public void _registerItem(Item item, ResourceLocation registryname, String unlocalized) {
		item.setRegistryName(registryname);
		item.setUnlocalizedName(unlocalized);
		itemsToReg.add(item);
	}
	/**
	 * Does the actual work of Registering Blocks.
	 * @param event
	 */
	@SubscribeEvent
	public void registerAllBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(blocksToReg.toArray(new Block[blocksToReg.size()]));
		AlphaCentauri.logger.info("Registered " + blocksToReg.size() + " Blocks");
	}
	/**
	 * Does the actual work of Registering Items.
	 * @param event
	 */
	@SubscribeEvent
    public void registerAllItems(RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().registerAll(itemsToReg.toArray(new Item[itemsToReg.size()]));
		AlphaCentauri.logger.info("Registered " + itemsToReg.size() + " Items");
	}
}
