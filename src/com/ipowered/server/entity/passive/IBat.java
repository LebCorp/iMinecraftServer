package com.ipowered.server.entity.passive;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;


public class IBat extends IAmbient implements Bat {

	protected boolean awake;
	
	public IBat(Server server, Location location) {
		super(server, location, EntityType.BAT);
	}

	@Override
	public boolean isAwake() {
		return this.awake;
	}

	@Override
	public void setAwake(boolean state) {
		this.awake = state;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.BAT_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.BAT_DEATH;
	}
}
