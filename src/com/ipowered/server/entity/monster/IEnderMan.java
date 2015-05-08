package com.ipowered.server.entity.monster;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.material.MaterialData;

public class IEnderMan extends IMonster implements Enderman {

	private MaterialData carried;
	
	public IEnderMan(Server server, Location location) {
		super(server, location, EntityType.ENDERMAN, CreatureType.ENDERMAN);
	}

	@Override
	public MaterialData getCarriedMaterial() {
		return this.carried;
	}

	@Override
	public void setCarriedMaterial(MaterialData material) {
		this.carried = material;
	}

	@Override
	public Sound getHurtSound() {
		return Sound.ENDERMAN_HIT;
	}

	@Override
	public Sound getDeathSound() {
		return Sound.ENDERMAN_DEATH;
	}
}
