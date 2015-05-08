package com.ipowered.server.entity.golem;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowman;

public class ISnowGolem extends IGolem implements Snowman {

	public ISnowGolem(Server server, Location location) {
		super(server, location, EntityType.SNOWMAN, CreatureType.SNOWMAN);
	}

	/** Nor sure this is the good sound */
	@Override
	public Sound getHurtSound() {
		return Sound.DIG_SNOW;
	}

	/** Not sure this is the good sound */
	@Override
	public Sound getDeathSound() {
		return Sound.DIG_SNOW;
	}
}
