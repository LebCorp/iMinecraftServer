package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

public class IZombie extends IMonster implements Zombie {

	private boolean baby;
	private boolean villager;
	
	public IZombie(Server server, Location location) {
		this(server, location, EntityType.ZOMBIE, CreatureType.ZOMBIE);
	}
	
	//Constructor for pig zombies
	public IZombie(Server server, Location location, EntityType type, CreatureType ctype) {
		super(server, location, type, ctype);
	}

	@Override
	public boolean isBaby() {
		return this.baby;
	}

	@Override
	public void setBaby(boolean flag) {
		this.baby = flag;
	}

	@Override
	public boolean isVillager() {
		return this.villager;
	}

	@Override
	public void setVillager(boolean flag) {
		this.villager = flag;
		// Maybe after : this.type = EntityType.VILLAGER;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.ZOMBIE_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.ZOMBIE_DEATH;
	}
}
