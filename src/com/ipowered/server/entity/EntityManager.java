package com.ipowered.server.entity;

import java.util.HashMap;

public final class EntityManager {

	private final HashMap<Integer, IEntity> entities = new HashMap<Integer, IEntity>();
	
	public EntityManager() {
	}
	
	void register(IEntity entity) {
		entities.put(entity.getEntityId(), entity);
	}
	
	void remove(IEntity entity) {
		entities.remove(entity.getEntityId());
	}
	
	HashMap<Integer, IEntity> getEntities() {
		return entities;
	}
}
