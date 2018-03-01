package com.cyborgJenn.alphaCentauri.item;

import java.util.List;

import javax.annotation.Nullable;

import com.cyborgJenn.alphaCentauri.AlphaCentauri;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Sword1 extends ItemSword 
{
	@SuppressWarnings("unused")
	private final Item.ToolMaterial material;
	@SuppressWarnings("unused")
	private float attackDamage;
	
	public Sword1(Item.ToolMaterial material)
	{
		super(material);
		this.material = material;
		this.setCreativeTab(AlphaCentauri.tabAlphaCentauri);
		this.attackDamage = 4.0F + material.getDamageVsEntity();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_PURPLE + "This is a sword, hit things with it");
    }
    
}
