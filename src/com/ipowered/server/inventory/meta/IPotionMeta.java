package com.ipowered.server.inventory.meta;

import java.util.Arrays;
import java.util.List;

import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IPotionMeta extends IItemMeta implements PotionMeta {

	private List<PotionEffect> effects;
	private List<PotionEffectType> customEffects;
	
	private PotionEffectType main;
	
	public IPotionMeta() {
		this(null, Arrays.asList(PotionEffectType.CONFUSION));
	}
	
	public IPotionMeta(List<PotionEffect> effects, List<PotionEffectType> customs) {
		this.effects = effects;
		this.customEffects = customs;
	}
	
	@Override
	public boolean hasCustomEffects() {
		return effects.size() != 0;
	}

	@Override
	public List<PotionEffect> getCustomEffects() {
		return this.effects;
	}

	@Override
	public boolean addCustomEffect(PotionEffect effect, boolean overwrite) {
		return effects.add(effect);
	}

	@Override
	public boolean removeCustomEffect(PotionEffectType type) {
		return customEffects.remove(type);
	}

	@Override
	public boolean hasCustomEffect(PotionEffectType type) {
		return customEffects.contains(type);
	}

	@Override
	public boolean setMainEffect(PotionEffectType type) {
		this.main = type;
		return true;
	}

	@Override
	public boolean clearCustomEffects() {
		return customEffects.removeAll(customEffects);
	}

	@Override
	public PotionMeta clone() {
		return (PotionMeta) super.clone();
	}
}
