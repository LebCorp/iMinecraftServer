package com.ipowered.server.map;

import java.awt.Image;

import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

public class IMapCanvas implements MapCanvas {

	private MapView view;

	protected static final int MAP_SIZE = 128;

	private MapCursorCollection mpCollection = new MapCursorCollection();

	private byte[] buffer = new byte[MAP_SIZE * MAP_SIZE];

	private byte[] base;

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
		if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE)
			return;
		if (buffer[y * MAP_SIZE + x] != color) {
			buffer[y * MAP_SIZE + x] = color;
			// TODO: mark dirty
		}
	}

	@Override
	public byte getPixel(int x, int y) {
		if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE)
			return 0;
		return buffer[y * MAP_SIZE + x];
	}

	@Override
	public byte getBasePixel(int x, int y) {
		if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE) return 0;
		return base[y * MAP_SIZE + x];
	}

	@Override
	public void drawImage(int x, int y, Image image) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void drawText(int x, int y, MapFont font, String text) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
