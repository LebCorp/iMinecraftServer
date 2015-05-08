package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

public class IBlaze extends IMonster implements Blaze {

	public IBlaze(Server server, Location location) {
		super(server, location, EntityType.BLAZE, CreatureType.BLAZE);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.BLAZE_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.BLAZE_DEATH;
	}
}
