package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class IHorse extends IAnimals implements Horse {

	private int domestication;
	private int maxDomestication;

	private double jumpStrength;

	private boolean tamed;
	private boolean chest;

	private AnimalTamer tamer;

	private Variant variant;
	private Color color;
	private Style style;

	private HorseInventory inventory;

	public IHorse(Server server, Location location, Variant variant,
			HorseInventory inventory, Color color, Style style) {
		super(server, location, EntityType.HORSE);

		this.variant = variant;
		this.inventory = inventory;
		this.color = color;
		this.style = style;
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
		return this.tamer;
	}

	@Override
	public void setOwner(AnimalTamer tamer) {
		setTamed(true);
		this.tamer = tamer;
	}

	@Override
	public Variant getVariant() {
		return this.variant;
	}

	@Override
	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Style getStyle() {
		return this.style;
	}

	@Override
	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public boolean isCarryingChest() {
		return this.chest;
	}

	@Override
	public void setCarryingChest(boolean chest) {
		this.chest = chest;
	}

	@Override
	public int getDomestication() {
		return this.domestication;
	}

	@Override
	public void setDomestication(int level) {
		this.domestication = level;
	}

	@Override
	public int getMaxDomestication() {
		return this.maxDomestication;
	}

	@Override
	public void setMaxDomestication(int level) {
		this.maxDomestication = level;
	}

	@Override
	public double getJumpStrength() {
		return this.jumpStrength;
	}

	@Override
	public void setJumpStrength(double strength) {
		this.jumpStrength = strength;
	}

	@Override
	public HorseInventory getInventory() {
		return this.inventory;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.HORSE_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.HORSE_DEATH;
	}
}
