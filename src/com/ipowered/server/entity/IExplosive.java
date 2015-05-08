package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Explosive;

public class IExplosive extends IEntity implements Explosive {

	private float yield;
	
	private boolean incendiary;
	
	public IExplosive(Server server, Location location, EntityType type) {
		super(server, location, type);
	}

	@Override
	public void setYield(float yield) {
		this.yield = yield;
	}

	@Override
	public float getYield() {
		return this.yield;
	}

	@Override
	public void setIsIncendiary(boolean isIncendiary) {
		this.incendiary = isIncendiary;
	}

	@Override
	public boolean isIncendiary() {
		return this.incendiary;
	}
}
