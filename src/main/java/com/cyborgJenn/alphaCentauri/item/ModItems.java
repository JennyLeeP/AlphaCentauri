package com.cyborgJenn.alphaCentauri.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{
	
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
}
