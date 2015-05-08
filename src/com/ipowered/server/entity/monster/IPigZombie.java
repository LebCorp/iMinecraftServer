package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;

public class IPigZombie extends IZombie implements PigZombie {

	private boolean angry;
	private int anger;
	
	public IPigZombie(Server server, Location location) {
		super(server, location, EntityType.PIG_ZOMBIE, CreatureType.PIG_ZOMBIE);
	}

	@Override
	public int getAnger() {
		return this.anger;
	}

	@Override
	public void setAnger(int level) {
		this.anger = level;
	}

	@Override
	public void setAngry(boolean angry) {
		this.angry = angry;
	}

	@Override
	public boolean isAngry() {
		return this.angry;
	}
}
