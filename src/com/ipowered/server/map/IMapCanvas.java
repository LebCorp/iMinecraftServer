package com.ipowered.server.map;

import java.awt.Image;

import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

public class IMapCanvas implements MapCanvas {

	private MapView view;
	
	private MapCursorCollection mpCollection;
	
	public IMapCanvas(MapView view) {
		this.view = view;
	}
	
	@Override
	public MapView getMapView() {
		return this.view;
	}

	@Override
	public MapCursorCollection getCursors() {
		return mpCollection;
	}

	@Override
	public void setCursors(MapCursorCollection cursors) {
		this.mpCollection = cursors;
	}

	@Override
	public void setPixel(int x, int y, byte color) {
		
	}

	@Override
	public byte getPixel(int x, int y) {
		return 0;
	}

	@Override
	public byte getBasePixel(int x, int y) {
		return 0;
	}

	@Override
	public void drawImage(int x, int y, Image image) {
		
	}

	@Override
	public void drawText(int x, int y, MapFont font, String text) {
		
	}
}
