package com.ipowered.server.entity.animals;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

public class ISheep extends IAnimals implements Sheep {

	private DyeColor color;
	private boolean sheared;
	
	public ISheep(Server server, Location location, DyeColor color) {
		super(server, location, EntityType.SHEEP);
		
		this.color = color;
	}

	@Override
	public DyeColor getColor() {
		return this.color;
	}

	@Override
	public void setColor(DyeColor color) {
		this.color = color;
	}

	@Override
	public boolean isSheared() {
		return this.sheared;
	}

	@Override
	public void setSheared(boolean flag) {
		this.sheared = flag;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.SHEEP_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.SHEEP_DEATH;
	}
}
