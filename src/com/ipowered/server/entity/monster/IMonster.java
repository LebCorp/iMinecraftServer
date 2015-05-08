package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;

import com.ipowered.server.entity.creature.ICreature;

public abstract class IMonster extends ICreature implements Monster {

	public IMonster(Server server, Location location, EntityType type, CreatureType ctype) {
		super(server, location, type, ctype);
	}
}
