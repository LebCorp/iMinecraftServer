package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.EntityType;

public class IEndermite extends IMonster implements Endermite {

	public IEndermite(Server server, Location location) {
		super(server, location, EntityType.ENDERMITE, CreatureType.ENDERMITE);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.SILVERFISH_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.SILVERFISH_KILL;
	}
}
