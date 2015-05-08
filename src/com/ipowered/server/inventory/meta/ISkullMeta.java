package com.ipowered.server.inventory.meta;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.SkullMeta;

public class ISkullMeta extends IItemMeta implements SkullMeta {

	@SuppressWarnings("deprecation")
	private String owner = EntityType.SKELETON.getName();
	
	public ISkullMeta() {
	}
	
	@Override
	public String getOwner() {
		return this.owner;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean hasOwner() {
		return owner != EntityType.SKELETON.getName();
	}

	@Override
	public boolean setOwner(String owner) {
		this.owner = owner;
		return this.owner.length() <= 16;
	}

	@Override
	public SkullMeta clone() {
		
		ISkullMeta meta = (ISkullMeta) super.clone();
		meta.owner = this.owner;
		
		return meta;
	}
}
