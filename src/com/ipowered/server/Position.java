package com.ipowered.server;

import org.apache.commons.lang3.Validate;
import org.bukkit.Location;

public class Position {

	public static Location copyOf(Location source, Location target) {
		
		Validate.notNull(source, "Source Location cannot be null !");
		Validate.notNull(target, "Target Location cannot be null !");
		
		target.setWorld(source.getWorld());
		target.setX(source.getX());
		target.setY(source.getY());
		target.setZ(source.getZ());
		target.setYaw(source.getYaw());
		target.setPitch(source.getPitch());
		
		return target;
	}
}
