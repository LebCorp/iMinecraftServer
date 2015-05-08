package com.ipowered.server.entity.monster.boss;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;

import com.ipowered.server.entity.monster.IMonster;

public class IEnderDragon extends IMonster implements EnderDragon {

	private Set<ComplexEntityPart> parts;
	
	public IEnderDragon(Server server, Location location) {
		super(server, location, EntityType.ENDER_DRAGON, CreatureType.ENDER_DRAGON);
		
		this.parts = new HashSet<ComplexEntityPart>();
	}

	@Override
	public Set<ComplexEntityPart> getParts() {
		return parts;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.ENDERDRAGON_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.ENDERDRAGON_DEATH;
	}
}
