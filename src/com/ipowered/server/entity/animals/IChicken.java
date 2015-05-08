package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

public class IChicken extends IAnimals implements Chicken {

	public IChicken(Server server, Location location) {
		super(server, location, EntityType.CHICKEN);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.CHICKEN_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.CHICKEN_DEATH;
	}
}
