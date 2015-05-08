package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;

public class IExperienceOrb extends IEntity implements ExperienceOrb {

	private int xp = 0;
	
	public IExperienceOrb(Server server, Location location) {
		super(server, location, EntityType.EXPERIENCE_ORB);
	}

	@Override
	public int getExperience() {
		return xp;
	}

	@Override
	public void setExperience(int value) {
		this.xp = value;
	}
}
