package com.ipowered.server.entity.projectiles;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;

public class IEgg extends IProjectile implements Egg {

	public IEgg(Server server, Location location) {
		super(server, location, EntityType.EGG);
	}
}
