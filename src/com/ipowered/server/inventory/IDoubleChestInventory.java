package com.ipowered.server.inventory;

import org.bukkit.block.DoubleChest;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class IDoubleChestInventory extends IInventory implements DoubleChestInventory {

	private IInventory left, right;
	
	
	/**
	 * You mustn't or don't have to put an InventoryHolder in this constructor 
	 * */
	public IDoubleChestInventory(IInventory left, IInventory right, InventoryHolder holder) throws IllegalAccessException {
		super("Large Chest", InventoryType.CHEST.getDefaultSize() * 2, InventoryType.CHEST, holder);
	
		this.holder = getHolder();
	}

	@Override
	public Inventory getLeftSide() {
		return this.left;
	}

	@Override
	public Inventory getRightSide() {
		return this.right;
	}

	@Override
	public DoubleChest getHolder() {
		return new DoubleChest(this);
	}
}
