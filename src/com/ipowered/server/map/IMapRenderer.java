package com.ipowered.server.map;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class IMapRenderer extends MapRenderer {

	private MapView view;
	
	public IMapRenderer(MapView view) {
		super(false);
		
		this.view = view;
	}
	
	@Override
	public void render(MapView map, MapCanvas canvas, Player player) {
		//TODO
	}
}
