package com.ipowered.server.inventory;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class IHorseInventory extends IInventory implements HorseInventory {

	protected final int SADDLE_SLOT = 0;
	protected final int ARMOR_SLOT = 1;
	
	public IHorseInventory(String title, int size, InventoryHolder holder) {
		super(title, size, InventoryType.CHEST, holder);
		
		this.slotTypes[SADDLE_SLOT] = SlotType.CONTAINER;
		this.slotTypes[ARMOR_SLOT] = SlotType.CONTAINER;
	}

	@Override
	public ItemStack getSaddle() {
		return getItem(SADDLE_SLOT);
	}

	@Override
	public ItemStack getArmor() {
		return getItem(ARMOR_SLOT);
	}

	@Override
	public void setSaddle(ItemStack stack) {
		setItem(SADDLE_SLOT, stack);
	}

	@Override
	public void setArmor(ItemStack stack) {
		setItem(ARMOR_SLOT, stack);
	}
}
