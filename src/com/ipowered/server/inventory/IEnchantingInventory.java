package com.ipowered.server.inventory;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class IEnchantingInventory extends IInventory implements EnchantingInventory {

	protected final int ITEM_SLOT = 0;
	protected final int LAPIS_SLOT = 1;
	
	private ItemStack item;
	
	//by default a lapis
	private ItemStack secondary;
	
	public IEnchantingInventory(String title, InventoryHolder holder) {
		super(title, 3, InventoryType.ENCHANTING, holder);
	
		this.slotTypes[ITEM_SLOT] = SlotType.CRAFTING;
		this.slotTypes[LAPIS_SLOT] = SlotType.CRAFTING;
		
		if(secondary == null) {
			secondary = new ItemStack(Material.LAPIS_ORE);
		}
	}

	@Override
	public void setItem(ItemStack item) {
		this.item = item;
		super.setItem(ITEM_SLOT, item);
	}

	@Override
	public ItemStack getItem() {
		return this.item;
	}

	@Override
	public void setSecondary(ItemStack item) {
		this.secondary = item;
		super.setItem(LAPIS_SLOT, item);
	}

	@Override
	public ItemStack getSecondary() {
		return this.secondary;
	}
}
