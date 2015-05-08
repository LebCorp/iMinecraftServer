package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Silverfish;

public class ISilverfish extends IMonster implements Silverfish {

	public ISilverfish(Server server, Location location) {
		super(server, location, EntityType.SILVERFISH, CreatureType.SILVERFISH);
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
