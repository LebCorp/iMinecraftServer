package com.ipowered.server;

import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.collect.Maps;
import com.ipowered.server.inventory.meta.IBannerMeta;
import com.ipowered.server.inventory.meta.IBookMeta;
import com.ipowered.server.inventory.meta.IItemMeta;
import com.ipowered.server.inventory.meta.IPotionMeta;
import com.ipowered.server.inventory.meta.ISkullMeta;

public class IItemFactory implements ItemFactory {

	private static HashMap<Material, IItemMeta> metas = Maps.newHashMap();
	
	public IItemFactory() {
		loadMetas();
	}
	
	@Override
	public ItemMeta getItemMeta(Material material) {
		return this.from(material);
	}

	@Override
	public boolean isApplicable(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		return true;
	}

	@Override
	public boolean isApplicable(ItemMeta meta, Material material) throws IllegalArgumentException {
		return true;
	}

	@Override
	public boolean equals(ItemMeta meta1, ItemMeta meta2) throws IllegalArgumentException {
		return meta1.equals(meta2) | meta2.equals(meta1);
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, ItemStack stack) throws IllegalArgumentException {
		return asMetaFor(meta, stack.getType());
	}

	@Override
	public ItemMeta asMetaFor(ItemMeta meta, Material material) throws IllegalArgumentException {		
		return from(material) != null ? from(material) : null;
	}

	public IItemMeta from(Material material) {
		return metas.get(material);
	}
	
	public void loadMetas() {
		metas.put(Material.BANNER, new IBannerMeta());
		metas.put(Material.POTION, new IPotionMeta());
		metas.put(Material.BOOK, new IBookMeta());
		metas.put(Material.SKULL_ITEM, new ISkullMeta());
	}
	
	@Override
	public Color getDefaultLeatherColor() {
		return Color.fromRGB(0xA06540);
	}
}
