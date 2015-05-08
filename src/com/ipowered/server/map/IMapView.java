package com.ipowered.server.map;

import java.util.List;

import org.bukkit.World;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import com.google.common.collect.Lists;

public class IMapView implements MapView {

	private List<MapRenderer> renderers;
	
	private short id;
	
	private boolean virtual;
	
	private Scale scale;
	
	private int cx, cz;
	
	private World world;
	
	public IMapView(World world) {
		this(world, Scale.NORMAL);
	}
	
	public IMapView(World world, Scale scale) {
		this.renderers = Lists.newArrayList();
		this.world = world;
		this.scale = scale;
	}
	
	@Override
	public short getId() {
		return this.id;
	}

	@Override
	public boolean isVirtual() {
		return this.virtual;
	}

	@Override
	public Scale getScale() {
		return this.scale;
	}

	@Override
	public void setScale(Scale scale) {
		this.scale = scale;
	}

	@Override
	public int getCenterX() {
		return this.cx;
	}

	@Override
	public int getCenterZ() {
		return this.cz;
	}

	@Override
	public void setCenterX(int x) {
		this.cx = x;
	}

	@Override
	public void setCenterZ(int z) {
		this.cz = z;
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public void setWorld(World world) {
		this.world = world;
	}

	@Override
	public List<MapRenderer> getRenderers() {
		return renderers;
	}

	@Override
	public void addRenderer(MapRenderer renderer) {
		renderers.add(renderer);
	}

	@Override
	public boolean removeRenderer(MapRenderer renderer) {
		return renderers.remove(renderer);
	}
}
