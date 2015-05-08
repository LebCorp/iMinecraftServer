package com.ipowered.server;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;

public class IWorldBorder implements WorldBorder {

	private double size;
	
	private int warningDistance;
	
	private int warningTime;
	
	private Location center;
	
	private double damageAmount;
	
	private double damageBuffer;

	private World world;
	
	public IWorldBorder(World world) {
		this.world = world;
	}
	
	@Override
	public void reset() {

	}

	@Override
	public double getSize() {
		return this.size;
	}

	@Override
	public void setSize(double newSize) {
		this.size = newSize;
	}

	@Override
	public void setSize(double newSize, long seconds) {
		WorldBorderRunnable runnable = new WorldBorderRunnable(seconds, newSize);
		runnable.run();
	}

	@Override
	public Location getCenter() {
		return this.center;
	}

	@Override
	public void setCenter(double x, double z) {
		this.center = new Location(world, x, 0.0D, z);
	}

	@Override
	public void setCenter(Location location) {
		this.center = location;
	}

	@Override
	public double getDamageBuffer() {
		return this.damageBuffer;
	}

	@Override
	public void setDamageBuffer(double blocks) {
		this.damageBuffer = blocks;
	}

	@Override
	public double getDamageAmount() {
		return this.damageAmount;
	}

	@Override
	public void setDamageAmount(double damage) {
		this.damageAmount = damage;
	}

	@Override
	public int getWarningTime() {
		return this.warningTime;
	}

	@Override
	public void setWarningTime(int seconds) {
		this.warningTime = seconds;
	}

	@Override
	public int getWarningDistance() {
		return this.warningDistance;
	}

	@Override
	public void setWarningDistance(int distance) {
		this.warningDistance = distance;
	}
	
	private class WorldBorderRunnable implements Runnable {

		private long seconds;
		
		private double newSize;
		
		public WorldBorderRunnable(long seconds, double newSize) {
			this.seconds = seconds;
			this.newSize = newSize;
		}
		
		@Override
		public void run() {
			long run = 0;
			
			while(run != seconds) {
				run++;
				
				setSize(newSize);
			}
		}
	}
 }
