package com.ipowered.server.entity.player;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;

import com.ipowered.server.entity.ILivingEntity;

public abstract class IHuman extends ILivingEntity {

	public IHuman(Server server, Location location, EntityType type) {
		super(server, location, type);
	}
}
