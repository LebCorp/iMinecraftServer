package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

public class ITNTPrimed extends IExplosive implements TNTPrimed {

	private Entity source;
	
	private int fuseTicks;
	
	public ITNTPrimed(Server server, Location location, Entity source) {
		super(server, location, EntityType.PRIMED_TNT);
		
		this.source = source;
	}

	@Override
	public void setFuseTicks(int fuseTicks) {
		this.fuseTicks = fuseTicks;
	}

	@Override
	public int getFuseTicks() {
		return this.fuseTicks;
	}

	@Override
	public Entity getSource() {
		return this.source;
	}
}
