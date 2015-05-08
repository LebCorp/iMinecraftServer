package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Spider;

public class ISpider extends IMonster implements Spider {

	public ISpider(Server server, Location location) {
		super(server, location, EntityType.SPIDER, CreatureType.SPIDER);
	}

	@Override
	public Sound getHurtSound() {
		return Sound.SPIDER_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.SPIDER_DEATH;
	}
}
