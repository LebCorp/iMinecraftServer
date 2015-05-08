package com.ipowered.server.entity.golem;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

public class IIronGolem extends IGolem implements IronGolem {

	private boolean playerCreated;
	
	public IIronGolem(Server server, Location location) {
		super(server, location, EntityType.IRON_GOLEM, CreatureType.fromEntityType(EntityType.IRON_GOLEM));
	}

	@Override
	public boolean isPlayerCreated() {
		return this.playerCreated;
	}

	@Override
	public void setPlayerCreated(boolean playerCreated) {
		this.playerCreated = playerCreated;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.IRONGOLEM_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.IRONGOLEM_DEATH;
	}
}
