package com.ipowered.server.inventory.meta;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import com.avaje.ebean.ValuePair;
import com.google.common.collect.Maps;

public class IItemMeta implements ItemMeta {

	private boolean hasDisplayName;
	private String displayName;
	private Map<Enchantment, Integer> enchants;
	private Set<ItemFlag> flags;

	private List<String> lore;

	public IItemMeta() {
	}

	@Override
	public Map<String, Object> serialize() {
		
		Map<String, Object> value = Maps.newHashMap();
		
		value.put("hasDisplayName", this.hasDisplayName);
		value.put("displayName", this.displayName);
		value.put("enchants", this.enchants);
		value.put("flags", this.flags);
		
		return value;
	}

	@Override
	public boolean hasDisplayName() {
		return this.hasDisplayName;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public void setDisplayName(String name) {
		this.displayName = name;
	}

	@Override
	public boolean hasLore() {
		return this.lore != null || this.lore.size() != 0;
	}

	@Override
	public List<String> getLore() {
		return this.lore;
	}

	@Override
	public void setLore(List<String> lore) {
		this.lore = lore;
	}

	@Override
	public boolean hasEnchants() {
		return enchants != null || enchants.size() != 0;
	}

	@Override
	public boolean hasEnchant(Enchantment ench) {
		return enchants.containsValue(ench);
	}

	@Override
	public int getEnchantLevel(Enchantment ench) {
		return enchants.get(ench);
	}

	@Override
	public Map<Enchantment, Integer> getEnchants() {
		return this.enchants;
	}

	@Override
	public boolean addEnchant(Enchantment ench, int level,
			boolean ignoreLevelRestriction) {
		enchants.put(ench, new Integer(level));
		return true;
	}

	@Override
	public boolean removeEnchant(Enchantment ench) {
		enchants.remove(ench);
		return true;
	}

	@Override
	public boolean hasConflictingEnchant(Enchantment ench) {
		return enchants.containsKey(ench);
	}

	@Override
	public void addItemFlags(ItemFlag... itemFlags) {
		for(ItemFlag flag : itemFlags) {
			this.flags.add(flag);
		}
	}

	@Override
	public void removeItemFlags(ItemFlag... itemFlags) {
		for (ItemFlag f : itemFlags) {
			ItemFlag flag = f;
			
			this.flags.remove(flag);
		}
	}

	@Override
	public Set<ItemFlag> getItemFlags() {
		return flags;
	}

	@Override
	public boolean hasItemFlag(ItemFlag flag) {
		return flags.contains(flag);
	}

	@Override
	public ItemMeta clone() {
		
		IItemMeta target = new IItemMeta();
		
		target.displayName = getDisplayName();
		target.enchants = getEnchants();
		target.flags = getItemFlags();
		target.lore = getLore();
		
		return target;
	}
}
