package com.cyborgJenn.alphaCentauri.combat.item;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class Sword1 extends ItemSword 
{
	private final Item.ToolMaterial material;
	private float attackDamage;
	
	public Sword1(Item.ToolMaterial material, String name)
	{
		super(material);
		this.material = material;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.setUnlocalizedName(name);
		this.attackDamage = 4.0F + material.getDamageVsEntity();
	}
	/*
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add(TextFormatting.DARK_PURPLE + "This is a sword, hit things with it");
    }
    */
}
