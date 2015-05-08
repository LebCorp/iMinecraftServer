package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;

public class ICow extends IAnimals implements Cow {

	public ICow(Server server, Location location) {
		super(server, location, EntityType.COW);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.COW_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.COW_IDLE;
	}
}
