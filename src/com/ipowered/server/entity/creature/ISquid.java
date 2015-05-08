package com.ipowered.server.entity.creature;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Squid;


public class ISquid extends ICreature implements Squid {

	public ISquid(Server server, Location location) {
		super(server, location, EntityType.SQUID, CreatureType.SQUID);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.SQUID_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.SQUID_DEATH;
	}
}
