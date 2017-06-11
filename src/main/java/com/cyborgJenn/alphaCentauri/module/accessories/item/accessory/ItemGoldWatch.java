package com.cyborgJenn.alphaCentauri.module.accessories.item.accessory;

import com.cyborgJenn.alphaCentauri.api.AccessoryType;
import com.cyborgJenn.alphaCentauri.api.IAccessory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGoldWatch extends Item implements IAccessory {

	@Override
	public AccessoryType getAccessoryType(ItemStack itemstack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub
		return false;
	}

}
