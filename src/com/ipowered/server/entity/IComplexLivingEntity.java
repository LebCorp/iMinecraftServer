package com.ipowered.server.entity;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.entity.EntityType;

public class IComplexLivingEntity extends ILivingEntity implements ComplexLivingEntity {

	private Set<ComplexEntityPart> parts;
	
	public IComplexLivingEntity(Server server, Location location) {
		super(server, location, EntityType.COMPLEX_PART);
		
		this.parts = new HashSet<ComplexEntityPart>();
	}

	@Override
	public Set<ComplexEntityPart> getParts() {
		return parts;
	}

	/**
	 * 	No sounds 'cause complex entity part's 
	 * @return nothing
	 * */
	@Override
	public Sound getHurtSound() {
		throw new UnsupportedOperationException("No sounds available");
	}

	/**
	 * 	No sounds 'cause complex entity part's 
	 * @return nothing
	 * */
	@Override
	public Sound getDeathSound() {
		throw new UnsupportedOperationException("No sounds available");
	}
}
