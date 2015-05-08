package com.ipowered.server.entity.vehicule;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vehicle;
import org.bukkit.util.Vector;

import com.ipowered.server.entity.IEntity;

public class IVehicle extends IEntity implements Vehicle {

	public IVehicle(Server server, Location location, EntityType type) {
		super(server, location, type);
	}
	
	@Override
	public void setVelocity(Vector velocity) {
		super.setVelocity(velocity);
	}
	
	@Override
	public Vector getVelocity() {
		return super.getVelocity();
	}
}
