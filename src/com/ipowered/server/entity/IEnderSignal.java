package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;

public class IEnderSignal extends IEntity implements EnderSignal {

	public IEnderSignal(Server server, Location location) {
		super(server, location, EntityType.ENDER_SIGNAL);
	}
}
