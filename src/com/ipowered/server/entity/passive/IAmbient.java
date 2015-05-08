package com.ipowered.server.entity.passive;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.EntityType;

import com.ipowered.server.entity.ILivingEntity;

public abstract class IAmbient extends ILivingEntity implements Ambient {

	public IAmbient(Server server, Location location, EntityType type) {
		super(server, location, type);
	}
}
