package com.ipowered.server.entity.golem;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Golem;

import com.ipowered.server.entity.creature.ICreature;

public abstract class IGolem extends ICreature implements Golem {

	public IGolem(Server server, Location location, EntityType type, CreatureType ctype) {
		super(server, location, type, ctype);
	}
}
