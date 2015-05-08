package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

public class IRabbit extends IAnimals implements Rabbit {

	private Type rabbitType;
	
	public IRabbit(Server server, Location location, Type type) {
		super(server, location, EntityType.RABBIT);
		this.rabbitType = type;
	}

	@Override
	public Type getRabbitType() {
		return this.rabbitType;
	}

	@Override
	public void setRabbitType(Type type) {
		this.rabbitType = type;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.RABBIT_HURT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.RABBIT_DEATH;
	}
}
