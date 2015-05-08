package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;

public class ICreeper extends IMonster implements Creeper {

	private boolean powered;
	
	public ICreeper(Server server, Location location) {
		super(server, location, EntityType.CREEPER, CreatureType.CREEPER);
	}

	@Override
	public boolean isPowered() {
		return this.powered;
	}

	@Override
	public void setPowered(boolean value) {
		this.powered = value;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.CREEPER_HISS;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.CREEPER_DEATH;
	}
}
