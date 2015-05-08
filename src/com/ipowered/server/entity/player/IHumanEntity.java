package com.ipowered.server.entity.player;

import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import com.ipowered.server.entity.ILivingEntity;
import com.ipowered.server.inventory.ICraftingInventory;
import com.ipowered.server.inventory.IEnchantingInventory;
import com.ipowered.server.inventory.IInventory;
import com.ipowered.server.inventory.IInventoryView;
import com.ipowered.server.inventory.IPlayerInventory;

public class IHumanEntity extends ILivingEntity implements HumanEntity {

	private PermissibleBase permissions;

	private String name;

	private PlayerInventory pinv;

	private boolean sleeping;
	private int sleepTicks;

	private GameMode gameMode;

	private Inventory enderChest;

	private InventoryView currentView;
	
	private ItemStack onCusor;
	private ItemStack inHand;
	
	private int xpToLvl;
	
	private boolean blocking;
	
	private boolean op;

	public IHumanEntity(Server server, Location location, EntityType type) {
		super(server, location, type);

		this.permissions = new PermissibleBase(this);
		this.pinv = new IPlayerInventory("Inventory", this);
		this.enderChest = new IInventory("Enderchest",
				InventoryType.CHEST.getDefaultSize(), this);
	}

	@Override
	public boolean isPermissionSet(String name) {
		return permissions.isPermissionSet(name);
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		return permissions.isPermissionSet(perm);
	}

	@Override
	public boolean hasPermission(String name) {
		return permissions.hasPermission(name);
	}

	@Override
	public boolean hasPermission(Permission perm) {
		return permissions.hasPermission(perm);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return permissions.addAttachment(plugin);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return permissions.addAttachment(plugin, ticks);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value) {
		return permissions.addAttachment(plugin, name, value);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value, int ticks) {
		return permissions.addAttachment(plugin, name, value, ticks);
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {
		permissions.removeAttachment(attachment);
	}

	@Override
	public void recalculatePermissions() {
		permissions.recalculatePermissions();
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return permissions.getEffectivePermissions();
	}

	@Override
	public boolean isOp() {
		return this.op;
	}

	@Override
	public void setOp(boolean value) {
		this.op = value;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public PlayerInventory getInventory() {
		return this.pinv;
	}

	@Override
	public Inventory getEnderChest() {
		return this.enderChest;
	}

	@Override
	public boolean setWindowProperty(InventoryView.Property prop, int value) {
		// ps: doesn't send anything
		return prop.getType() == currentView.getType();
	}

	@Override
	public InventoryView getOpenInventory() {
		return this.currentView;
	}

	@Override
	public InventoryView openInventory(Inventory inventory) {
		this.currentView = new IInventoryView(inventory, this);
		return this.currentView;
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean force) {
		CraftingInventory craft = new ICraftingInventory("Crafting", this);

		if (location == null) {
			location = getLocation();
		}

		if (!force && location.getBlock().getType() != Material.WORKBENCH) {
			return null;
		}

		return openInventory(craft);
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean force) {
		EnchantingInventory ench = new IEnchantingInventory(
				InventoryType.ENCHANTING.getDefaultTitle(), this);

		if (location == null) {
			location = getLocation();
		}

		if (!force
				&& location.getBlock().getType() != Material.ENCHANTMENT_TABLE) {
			return null;
		}

		return openInventory(ench);
	}

	@Override
	public void openInventory(InventoryView inventory) {
		this.currentView = inventory;
	}

	@Override
	public void closeInventory() {
		
		if(!this.getGameMode().equals(GameMode.CREATIVE) && getItemOnCursor() != null) {
			this.getWorld().dropItem(getLocation(), getItemOnCursor());
		}
		
		setItemOnCursor(null);
		openInventory(new IInventoryView(this));
	}

	@Override
	public ItemStack getItemInHand() {
		return this.inHand;
	}

	@Override
	public void setItemInHand(ItemStack item) {
		this.inHand = item;
		getInventory().setItemInHand(item);
	}

	@Override
	public ItemStack getItemOnCursor() {
		return getOpenInventory().getCursor();
	}

	@Override
	public void setItemOnCursor(ItemStack item) {
		getOpenInventory().setCursor(item);
	}

	@Override
	public boolean isSleeping() {
		return this.sleeping;
	}

	@Override
	public int getSleepTicks() {
		return this.sleepTicks;
	}

	@Override
	public GameMode getGameMode() {
		return this.gameMode;
	}

	@Override
	public void setGameMode(GameMode mode) {
		this.gameMode = mode;
	}

	@Override
	public boolean isBlocking() {
		return this.blocking;
	}

	@Override
	public int getExpToLevel() {
		return this.xpToLvl;
	}

	@Override
	public Sound getHurtSound() {
		throw new UnsupportedOperationException(
				"There is no hurt sound for players");
	}

	@Override
	public Sound getDeathSound() {
		throw new UnsupportedOperationException(
				"There is no death sound for players");
	}
}
