package com.ipowered.server;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import com.google.common.collect.Lists;
import com.ipowered.server.entity.EntityManager;
import com.ipowered.server.entity.IEntity;

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

	public List<Entity> getEntities(double x, double y, double z) {
		
		Collection<IEntity> entities = EntityManager.getEntities().values();
		
		for(Entity entity : entities) {
			if(entity.getLocation().distance(new Location(entity.getWorld(), x, y, z)) <= 50) {
				List<Entity> result = Lists.newArrayList();
				result.add(entity);
				return result;
			}
		}
		
		return null;
	}

	public static class BoundingBox {

		private double x, y, z;

		public BoundingBox(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public boolean isActive() {
			return (this != null);
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

		public double getZ() {
			return z;
		}

		public void setZ(double z) {
			this.z = z;
		}
	}
}
