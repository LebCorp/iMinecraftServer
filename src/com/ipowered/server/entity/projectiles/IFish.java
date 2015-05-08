package com.ipowered.server.entity.projectiles;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fish;

@SuppressWarnings("deprecation")
public class IFish extends IProjectile implements Fish {

	private double biteChance;
	
	public IFish(Server server, Location location) {
		super(server, location, EntityType.FISHING_HOOK);
	}

	@Override
	public double getBiteChance() {
		return this.biteChance;
	}

	@Override
	public void setBiteChance(double chance) throws IllegalArgumentException {
		this.biteChance = chance;
	}
}
