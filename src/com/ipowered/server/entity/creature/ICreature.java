package com.ipowered.server.entity.creature;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Creature;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import com.ipowered.server.entity.ILivingEntity;

public abstract class ICreature extends ILivingEntity implements Creature {

	private LivingEntity target;
	
	@SuppressWarnings("deprecation")
	private CreatureType ctype;
	
	public ICreature(Server server, Location location, EntityType type, @SuppressWarnings("deprecation") CreatureType ctype) {
		super(server, location, type);
		
		this.ctype = ctype;
	}

	@SuppressWarnings("deprecation")
	public CreatureType getCreatureType() {
		return ctype;
	}
	
	@Override
	public void setTarget(LivingEntity target) {
		this.target = target;
	}

	@Override
	public LivingEntity getTarget() {
		return this.target;
	}
}
