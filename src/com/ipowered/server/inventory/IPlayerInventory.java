package com.ipowered.server.inventory;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class IPlayerInventory extends IInventory implements PlayerInventory {

	private HumanEntity player;
	
	private ItemStack inHand;
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	
	private ItemStack[] armorContents;
	
	public IPlayerInventory(String title, HumanEntity holder) {
		super(title, 36, InventoryType.PLAYER, (InventoryHolder) holder);
		
		this.player = holder;
	}

	@Override
	public ItemStack[] getArmorContents() {
		return armorContents;
	}

	@Override
	public ItemStack getHelmet() {
		return this.helmet != null ? this.helmet : this.getArmorContents()[0];
	}

	@Override
	public ItemStack getChestplate() {
		return this.chestplate != null ? this.chestplate : this.getArmorContents()[1];
	}

	@Override
	public ItemStack getLeggings() {
		return this.leggings != null ? this.leggings : this.getArmorContents()[2];
	}

	@Override
	public ItemStack getBoots() {
		return this.boots != null ? this.boots : this.getArmorContents()[3];
	}

	@Override
	public void setArmorContents(ItemStack[] items) {
		this.armorContents = items;
	}

	@Override
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}

	@Override
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}

	@Override
	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}

	@Override
	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}

	@Override
	public ItemStack getItemInHand() {
		return this.inHand;
	}

	@Override
	public void setItemInHand(ItemStack stack) {
		this.inHand = stack;
	}

	@Override
	public int getHeldItemSlot() {
		return 0;
	}

	@Override
	public void setHeldItemSlot(int slot) {
		// TODO 
	}

	@Override
	public int clear(int id, int data) {
		return 0;
	}

	@Override
	public HumanEntity getHolder() {
		return this.player;
	}
}
