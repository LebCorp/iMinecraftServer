package com.ipowered.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryHolder;

public class IAnvilInventory extends IInventory implements AnvilInventory {

	public IAnvilInventory(String title, InventoryHolder holder) {
		super(title, 3, InventoryType.ANVIL, holder);
	}
}
