package com.ipowered.server.inventory.meta;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.meta.BannerMeta;

public class IBannerMeta extends IItemMeta implements BannerMeta {

	private DyeColor color;
	
	private List<Pattern> patterns = new ArrayList<Pattern>();
	
	@Override
	public DyeColor getBaseColor() {
		return this.color;
	}

	@Override
	public void setBaseColor(DyeColor color) {
		this.color = color;
	}

	@Override
	public List<Pattern> getPatterns() {
		return this.patterns;
	}

	@Override
	public void setPatterns(List<Pattern> patterns) {
		this.patterns = patterns;
	}

	@Override
	public void addPattern(Pattern pattern) {
		this.patterns.add(pattern);
	}

	@Override
	public Pattern getPattern(int i) {
		return this.patterns.get(i);
	}

	@Override
	public Pattern removePattern(int i) {
		return this.patterns.remove(i);
	}

	@Override
	public void setPattern(int i, Pattern pattern) {
		this.patterns.set(i, pattern);
	}

	@Override
	public int numberOfPatterns() {
		return this.patterns.size();
	}
}
