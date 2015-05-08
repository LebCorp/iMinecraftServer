package com.ipowered.server.entity.monster.boss;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wither;

import com.ipowered.server.entity.monster.IMonster;

public class IWither extends IMonster implements Wither {

	public IWither(Server server, Location location) {
		super(server, location, EntityType.WITHER, CreatureType.fromEntityType(EntityType.WITHER));
	}

	@Override
	public Sound getHurtSound() {
		return Sound.WITHER_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.WITHER_DEATH;
	}
}
