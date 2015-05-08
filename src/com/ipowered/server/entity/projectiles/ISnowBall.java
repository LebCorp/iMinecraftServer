package com.ipowered.server.entity.projectiles;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowball;

public class ISnowBall extends IProjectile implements Snowball {

	public ISnowBall(Server server, Location location) {
		super(server, location, EntityType.SNOWBALL);
	}
}
