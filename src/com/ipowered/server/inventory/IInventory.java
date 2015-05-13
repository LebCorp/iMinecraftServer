package com.ipowered.server.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

public class IInventory implements Inventory {

	private String title;
	private int size;
	private InventoryType type;

	private int maxStackSize;
	
	protected InventoryHolder holder;

	private ItemStack[] slots;

	private Set<HumanEntity> viewers;
	
	public SlotType[] slotTypes = new SlotType[getType().getDefaultSize()];

	private Map<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();

	public IInventory(String title, int size, InventoryHolder holder) {
		this(title, size, InventoryType.CHEST, holder);
	}

	public IInventory(String title, int size, InventoryType type,
			InventoryHolder holder) {
		this.title = title;
		this.size = size;
		this.type = type;
		this.holder = holder;
		this.slots = new ItemStack[size];
		this.viewers = new HashSet<HumanEntity>();
	}

	public SlotType[] getSlotTypes() {
		return slotTypes;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public int getMaxStackSize() {
		return maxStackSize;
	}

	@Override
	public void setMaxStackSize(int size) {
		this.maxStackSize = size;
	}

	@Override
	public String getName() {
		return this.title;
	}

	@Override
	public ItemStack getItem(int index) {
		return slots[index];
	}

	@Override
	public void setItem(int index, ItemStack item) {
		slots[index] = item;
	}

	@Override
	public HashMap<Integer, ItemStack> addItem(ItemStack... items)
			throws IllegalArgumentException {
		HashMap<Integer, ItemStack> result = new HashMap<Integer, ItemStack>();

		for (int i = 0; i < items.length; ++i) {
			ItemStack item = items[i];
			if (item == null)
				continue; // invalid items fail silently
			int maxStackSize = item.getType() == null ? 64 : item.getType()
					.getMaxStackSize();
			int toAdd = item.getAmount();

			for (int j = 0; toAdd > 0 && j < getSize(); ++j) {
				// Look for existing stacks to add to
				if (slots[j] != null && slots[j].isSimilar(item)) {
					int space = maxStackSize - slots[j].getAmount();
					if (space < 0)
						continue;
					if (space > toAdd)
						space = toAdd;

					slots[j].setAmount(slots[j].getAmount() + space);
					toAdd -= space;
				}
			}

			if (toAdd > 0) {
				// Look for empty slots to add to
				for (int j = 0; toAdd > 0 && j < getSize(); ++j) {
					if (slots[j] == null) {
						int num = toAdd > maxStackSize ? maxStackSize : toAdd;
						slots[j] = item.clone();
						slots[j].setAmount(num);
						toAdd -= num;
					}
				}
			}

			if (toAdd > 0) {
				// Still couldn't stash them all.
				ItemStack remaining = item.clone();
				remaining.setAmount(toAdd);
				result.put(i, remaining);
			}
		}

		return result;
	}

	@Override
	public HashMap<Integer, ItemStack> removeItem(ItemStack... items)
			throws IllegalArgumentException {
		HashMap<Integer, ItemStack> result = new HashMap<Integer, ItemStack>();

		for (int i = 0; i < items.length; ++i) {
			int mat = items[i].getTypeId();
			int toRemove = items[i].getAmount();
			short damage = items[i].getDurability();

			for (int j = 0; j < getSize(); ++j) {
				// Look for stacks to remove from.
				if (slots[j] != null && slots[j].getTypeId() == mat
						&& slots[j].getDurability() == damage) {
					if (slots[j].getAmount() > toRemove) {
						slots[j].setAmount(slots[j].getAmount() - toRemove);
					} else {
						toRemove -= slots[j].getAmount();
						slots[j] = null;
					}
				}
			}

			if (toRemove > 0) {
				// Couldn't remove them all.
				result.put(i, new ItemStack(mat, toRemove, damage));
			}
		}

		return result;
	}

	@Override
	public ItemStack[] getContents() {
		return slots;
	}

	@Override
	public void setContents(ItemStack[] items) throws IllegalArgumentException {
		this.slots = items;
	}

	@Override
	public boolean contains(int materialId) {
		return false;
	}

	@Override
	public boolean contains(Material material) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(ItemStack item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(int materialId, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Material material, int amount)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(ItemStack item, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAtLeast(ItemStack item, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(int materialId) {
		return null;
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
		return this.all(material.getId());
	}

	@Override
	public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
		return this.all(item.getType());
	}

	@Override
	public int first(int materialId) {
		for (int i = 0; i < slots.length; ++i) {
			if (slots[i] != null && slots[i].getTypeId() == materialId)
				return i;
		}
		return -1;
	}

	@Override
	public int first(Material material) throws IllegalArgumentException {
		return this.first(material.getId());
	}

	@Override
	public int first(ItemStack item) {
		return this.first(item.getType());
	}

	@Override
	public int firstEmpty() {
		return this.first(0);
	}

	@Override
	public void remove(int materialId) {
		ItemStack item = new ItemStack(materialId);
		
		for(ItemStack i : slots) {
			if(i == item) {
				slots[first(i)] = null;
			}
		}
	}

	@Override
	public void remove(Material material) throws IllegalArgumentException {
		this.remove(material.getId());
	}

	@Override
	public void remove(ItemStack item) {
		for (ItemStack items : slots) {
			for (int i = 0; i < slots.length; i++) {
				if (items == item) {
					if (slots[i] == item) {
						slots[i] = (ItemStack) (item != null ? null : item);
					}
				}
			}
		}
	}

	@Override
	public void clear(int index) {
		slots[index] = null;
	}

	@Override
	public void clear() {
		for (int i = 0; i < slots.length; i++) {
			slots[i] = null;
		}
	}

	@Override
	public List<HumanEntity> getViewers() {

		List<HumanEntity> result = new ArrayList<HumanEntity>();

		HumanEntity[] viewers = this.viewers
				.toArray(new HumanEntity[this.viewers.size()]);

		Collections.addAll(result, viewers);

		return result;
	}

	@Override
	public String getTitle() {
		return this.title != null ? title : this.type.getDefaultTitle();
	}

	@Override
	public InventoryType getType() {
		return this.type;
	}

	@Override
	public InventoryHolder getHolder() {
		return this.holder;
	}

	@Override
	public ListIterator<ItemStack> iterator() {
		
		List<ItemStack> items = Lists.newArrayList(this.slots);
		
		ListIterator<ItemStack> iterator = items.listIterator();
		
		return iterator;
	}

	@Override
	public ListIterator<ItemStack> iterator(int index) {
		
		List<ItemStack> byIndex = Lists.newArrayList(slots);
		
		return byIndex.listIterator(index);
	}
}