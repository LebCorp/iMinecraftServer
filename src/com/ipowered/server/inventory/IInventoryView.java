package com.ipowered.server.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class IInventoryView extends InventoryView {

	private Inventory top, bottom;

	private InventoryType type;

	private HumanEntity human;

	public IInventoryView(HumanEntity human) {
		this(human.getInventory(), human);
	}

	public IInventoryView(Inventory top, HumanEntity human) {
		this(top, human.getInventory(), top.getType(), human);
	}

	public IInventoryView(Inventory top, Inventory bottom, InventoryType type,
			HumanEntity human) {
		this.top = top;
		this.bottom = bottom;
		this.type = type;
		this.human = human;
	}

	public void setItem(int slot, ItemStack stack) {
		checkSlot(slot);
		
		super.setItem(slot, stack);
	}
	
	private void checkSlot(int slot) {
		if (slot == OUTSIDE)
			return;

		int size = countSlots();
		if (isDefault(this))
			size += 4; // armor slots
		if (slot < 0 || slot >= size) {
			throw new IllegalArgumentException("Slot out of range [0," + size
					+ "): " + slot);
		}
	}

	@Override
	public Inventory getTopInventory() {
		return this.top;
	}

	@Override
	public Inventory getBottomInventory() {
		return this.bottom;
	}

	@Override
	public HumanEntity getPlayer() {
		return this.human;
	}

	@Override
	public InventoryType getType() {
		return this.type;
	}

	private boolean isDefault(InventoryView view) {
		return view.getBottomInventory() instanceof PlayerInventory
				&& view.getTopInventory() == view.getBottomInventory();
	}
}
