package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

public class IGuardian extends IMonster implements Guardian {

	private boolean elder;
	
	public IGuardian(Server server, Location location) {
		super(server, location, EntityType.GUARDIAN, CreatureType.GUARDIAN);
	}

	@Override
	public boolean isElder() {
		return this.elder;
	}

	@Override
	public void setElder(boolean shouldBeElder) {
		this.elder = shouldBeElder;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.GUARDIAN_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.GUARDIAN_DEATH;
	}
}
