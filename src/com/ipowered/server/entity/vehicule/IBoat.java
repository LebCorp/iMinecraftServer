package com.ipowered.server.entity.vehicule;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;

public class IBoat extends IVehicle implements Boat {

	private boolean workOnLand;
	
	private double maxSpeed;
	
	private double occupied;
	private double unoccupied;
	
	public IBoat(Server server, Location location) {
		super(server, location, EntityType.BOAT);
	}

	@Override
	public double getMaxSpeed() {
		return maxSpeed;
	}

	@Override
	public void setMaxSpeed(double speed) {
		this.maxSpeed = speed;
	}

	@Override
	public double getOccupiedDeceleration() {
		return this.occupied;
	}

	@Override
	public void setOccupiedDeceleration(double rate) {
		this.occupied = rate;
	}

	@Override
	public double getUnoccupiedDeceleration() {
		return this.unoccupied;
	}

	@Override
	public void setUnoccupiedDeceleration(double rate) {
		this.unoccupied = rate;
	}

	@Override
	public boolean getWorkOnLand() {
		return this.workOnLand;
	}

	@Override
	public void setWorkOnLand(boolean workOnLand) {
		this.workOnLand = workOnLand;
	}
}
