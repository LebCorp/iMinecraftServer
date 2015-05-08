package com.ipowered.server.inventory;

import org.bukkit.block.BrewingStand;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;

public class IBrewerInventory extends IInventory implements BrewerInventory {

	protected final int INGREDIENT_SLOT = 0;

	private BrewingStand holder;
	private ItemStack ingredient;

	public IBrewerInventory(String title, BrewingStand holder) {
		super(title, 4, InventoryType.BREWING, holder);

		this.holder = holder;

		this.slotTypes[INGREDIENT_SLOT] = InventoryType.SlotType.FUEL;
		for (int slot = 1; slot < 4; slot++) {
			this.slotTypes[slot] = InventoryType.SlotType.CRAFTING;
		}
	}

	@Override
	public ItemStack getIngredient() {
		return this.ingredient != null ? ingredient : super.getItem(INGREDIENT_SLOT);
	}

	@Override
	public void setIngredient(ItemStack ingredient) {
		this.ingredient = ingredient;
		super.setItem(INGREDIENT_SLOT, ingredient);
	}

	@Override
	public BrewingStand getHolder() {
		return this.holder;
	}
}
