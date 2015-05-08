package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.EntityType;

public class IEnderCrystal extends IEntity implements EnderCrystal {

	public IEnderCrystal(Server server, Location location) {
		super(server, location, EntityType.ENDER_CRYSTAL);
	}
}
