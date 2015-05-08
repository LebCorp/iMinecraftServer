package com.ipowered.server.entity.projectiles;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;

public class IArrow extends IProjectile implements Arrow {

	protected boolean critical;
	
	private int knockback;
	
	public IArrow(Server server, Location location) {
		super(server, location, EntityType.ARROW);
	}

	@Override
	public int getKnockbackStrength() {
		return this.knockback;
	}

	@Override
	public void setKnockbackStrength(int knockbackStrength) {
		this.knockback = knockbackStrength;
	}

	@Override
	public boolean isCritical() {
		return this.critical;
	}

	@Override
	public void setCritical(boolean critical) {
		this.critical = critical;
	}
}
