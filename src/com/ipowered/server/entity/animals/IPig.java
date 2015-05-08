package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

public class IPig extends IAnimals implements Pig {

	private boolean saddled;
	
	public IPig(Server server, Location location) {
		super(server, location, EntityType.PIG);
	}

	@Override
	public boolean hasSaddle() {
		return saddled;
	}

	@Override
	public void setSaddle(boolean saddled) {
		this.saddled = saddled;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.PIG_IDLE;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.PIG_DEATH;
	}
}
