package com.ipowered.server.entity.projectiles;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;

import com.ipowered.server.entity.IEntity;

public class IProjectile extends IEntity implements Projectile {

	private ProjectileSource psource;
	
	protected boolean bounce;
	
	public IProjectile(Server server, Location location, EntityType type) {
		super(server, location, type);
	}

	@Override
	public LivingEntity _INVALID_getShooter() {
		return (LivingEntity) this.psource;
	}

	@Override
	public ProjectileSource getShooter() {
		return this.psource;
	}

	@Override
	public void _INVALID_setShooter(LivingEntity shooter) {
		this.psource = (ProjectileSource) shooter;
	}

	@Override
	public void setShooter(ProjectileSource source) {
		this.psource = source;
	}

	@Override
	public boolean doesBounce() {
		return this.bounce;
	}

	@Override
	public void setBounce(boolean doesBounce) {
		this.bounce = doesBounce;
	}
}
