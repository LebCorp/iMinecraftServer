package com.ipowered.server.inventory;

import java.util.Arrays;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;

public class ICraftingInventory extends IInventory implements CraftingInventory {

	protected final int RESULT = 0;	
	protected final int MATRIX = 1;
	protected final int MATRIX_MAX = getSize();
	
	private ItemStack result;
	
	private ItemStack[] matrix;
	
	private Recipe recipe;
	
	public ICraftingInventory(String title, InventoryHolder holder) {
		super(title, 9, InventoryType.CRAFTING, holder);
		
		this.slotTypes[RESULT] = SlotType.RESULT;
		Arrays.fill(slotTypes, MATRIX, MATRIX_MAX, InventoryType.SlotType.CRAFTING);
		this.slotTypes[9] = SlotType.OUTSIDE;
		
		this.recipe = new ShapelessRecipe(result);
	}

	@Override
	public ItemStack getResult() {
		return this.result;
	}

	@Override
	public ItemStack[] getMatrix() {
		return this.matrix;
	}

	@Override
	public void setResult(ItemStack newResult) {
		this.result = newResult;
		super.setItem(RESULT, newResult);
	}

	@Override
	public void setMatrix(ItemStack[] contents) {
		this.matrix = contents;
		for(int i = MATRIX; i < MATRIX_MAX && i < matrix.length; i++) {
			super.setItem(i, matrix[i]);
		}
	}

	@Override
	public Recipe getRecipe() {
		return this.recipe;
	}
}
