package com.ipowered.server.entity;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.EntityType;

public class IComplexEntityPart extends IEntity implements ComplexEntityPart {

	public IComplexEntityPart(Server server, Location location, EntityType type) {
		super(server, location, type);
	}

	@Override
	public ComplexLivingEntity getParent() {
		return null;
	}
}
