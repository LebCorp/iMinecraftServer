package com.ipowered.server.entity.animals;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

public class IWolf extends IAnimals implements Wolf {

	private AnimalTamer owner;
	
	private boolean tamed;
	private boolean angry;
	private boolean sitting;
	
	private DyeColor colarColor;
	
	public IWolf(Server server, Location location) {
		super(server, location, EntityType.WOLF);
	}

	@Override
	public boolean isTamed() {
		return this.tamed;
	}

	@Override
	public void setTamed(boolean tame) {
		this.tamed = tame;
	}

	@Override
	public AnimalTamer getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		this.owner = tamer;
	}

	@Override
	public boolean isAngry() {
		return this.angry;
	}

	@Override
	public void setAngry(boolean angry) {
		this.angry = angry;
	}

	@Override
	public boolean isSitting() {
		return this.sitting;
	}

	@Override
	public void setSitting(boolean sitting) {
		this.sitting = sitting;
	}

	@Override
	public DyeColor getCollarColor() {
		return this.colarColor;
	}

	@Override
	public void setCollarColor(DyeColor color) {
		this.colarColor = color;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.WOLF_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.WOLF_DEATH;
	}
}
