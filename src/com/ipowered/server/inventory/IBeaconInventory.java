package com.ipowered.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.BeaconInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class IBeaconInventory extends IInventory implements BeaconInventory {

	protected final int ITEM_SLOT = 0;
	
	private ItemStack item;
	
	public IBeaconInventory(String title, InventoryHolder holder) {
		super(title, 1, InventoryType.BEACON, holder);
		
		this.slotTypes[ITEM_SLOT] = SlotType.CRAFTING;
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
}
