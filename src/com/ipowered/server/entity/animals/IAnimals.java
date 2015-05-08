package com.ipowered.server.entity.animals;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.Animals;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import com.ipowered.server.entity.ILivingEntity;

public abstract class IAnimals extends ILivingEntity implements Animals {

	private int age;
	
	private boolean lock;
	
	private LivingEntity target;
	
	private boolean breed;
	
	public IAnimals(Server server, Location location, EntityType type) {
		super(server, location, type);
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		if(!getAgeLock())
		this.age = age;
	}

	@Override
	public void setAgeLock(boolean lock) {
		this.lock = lock;
	}

	@Override
	public boolean getAgeLock() {
		return lock;
	}

	@Override
	public void setBaby() {
		this.age = 1;
	}

	@Override
	public void setAdult() {
		this.age = 3;
	}

	@Override
	public boolean isAdult() {
		return age == 3;
	}

	@Override
	public boolean canBreed() {
		return breed;
	}

	@Override
	public void setBreed(boolean breed) {
		this.breed = breed;
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
