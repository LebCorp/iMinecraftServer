package com.ipowered.server.inventory;

import org.bukkit.block.Furnace;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class IFurnaceInventory extends IInventory implements FurnaceInventory {
   
	protected final int SMELTING_SLOT = 0; 
    protected final int FUEL_SLOT = 1;
	protected final int RESULT_SLOT = 2;
	
	private ItemStack result;
	private ItemStack fuel;
	private ItemStack smelting;
	
	public IFurnaceInventory(String title, int size, InventoryHolder holder) {
		super(title, size, InventoryType.FURNACE, holder);
		
		this.slotTypes[SMELTING_SLOT] = SlotType.CRAFTING;
		this.slotTypes[FUEL_SLOT] = SlotType.FUEL;
		this.slotTypes[RESULT_SLOT] = SlotType.RESULT;
	}

	@Override
	public ItemStack getResult() {
		return this.result;
	}

	@Override
	public ItemStack getFuel() {
		return this.fuel;
	}

	@Override
	public ItemStack getSmelting() {
		return this.smelting;
	}

	@Override
	public void setFuel(ItemStack stack) {
		this.fuel = stack;
		super.setItem(FUEL_SLOT, stack);
	}

	@Override
	public void setResult(ItemStack stack) {
		this.result = stack;
		super.setItem(RESULT_SLOT, stack);
	}

	@Override
	public void setSmelting(ItemStack stack) {
		this.smelting = stack;
		super.setItem(SMELTING_SLOT, stack);
	}

	@Override
	public Furnace getHolder() {
		return (Furnace) super.getHolder();
	}
}
