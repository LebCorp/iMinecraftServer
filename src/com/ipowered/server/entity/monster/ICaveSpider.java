package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.EntityType;

public class ICaveSpider extends ISpider implements CaveSpider {

	public ICaveSpider(Server server, Location location) {
		super(server, location);
		
		if(type == EntityType.SPIDER) {
			this.type = EntityType.CAVE_SPIDER;
		} else {
			return;
		}
	}
}
