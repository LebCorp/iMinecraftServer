package com.ipowered.server.entity;

import java.util.HashMap;

public final class EntityManager {

	public static final HashMap<Integer, IEntity> entities = new HashMap<Integer, IEntity>();
	
	public EntityManager() {
	}
	
	public void register(IEntity entity) {
		entities.put(entity.getEntityId(), entity);
	}
	
	public void remove(IEntity entity) {
		entities.remove(entity.getEntityId());
	}
	
	public static HashMap<Integer, IEntity> getEntities() {
		return entities;
	}
}
