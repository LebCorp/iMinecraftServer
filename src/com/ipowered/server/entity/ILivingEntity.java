package com.ipowered.server.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.ipowered.server.entity.projectiles.IArrow;
import com.ipowered.server.entity.projectiles.IEgg;
import com.ipowered.server.entity.projectiles.ISnowBall;

public abstract class ILivingEntity extends IEntity implements LivingEntity {

	private double health;
	private double maxHealth;
	
	private Player source;
	
	private double speed;
	private double maxSpeed;
	
	private int air;
	private int maxAir;
	
	private double lastDamage;
	
	private int noDamage;
	private int maxNoDamage;
	
	private boolean canPickup;
	
	private boolean removeFarAway;
	
	public ILivingEntity(Server server, Location location, EntityType type) {
		super(server, location, type);
	}

	@Override
	public void damage(double amount) {
		this.health -= amount;
		
		this.lastDamage = amount;
		
		if(this.health < 0) {
			this.setHealth(0);
		}
		
		if(this.health == 0) {
			this.isValid = false;
			this.world.playSound(this.location, getDeathSound(), 5.0f, this.location.getPitch());
		} else {
			this.world.playSound(this.location, getHurtSound(), 5.0f, this.location.getPitch());
		}
	}

	@Override
	public void _INVALID_damage(int amount) {
		this.damage((double)amount); 
	}

	@Override
	public void damage(double amount, Entity source) {
		this.damage(amount);
		
		if(source instanceof Player) {
			this.source = (Player) source;
		} 
	}

	@Override
	public void _INVALID_damage(int amount, Entity source) {
		this.damage((double)amount, source);
	}

	@Override
	public double getHealth() {
		return this.health;
	}

	@Override
	public int _INVALID_getHealth() {
		return (int) this.health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
	}

	@Override
	public void _INVALID_setHealth(int health) {
		setHealth((double)health); 
	}

	@Override
	public double getMaxHealth() {
		return this.maxHealth;
	}

	@Override
	public int _INVALID_getMaxHealth() {
		return (int) this.maxHealth;
	}

	@Override
	public void setMaxHealth(double health) {
		this.maxHealth = health;
	}

	@Override
	public void _INVALID_setMaxHealth(int health) {
		this.maxHealth = (double) health;
	}

	@Override
	public void resetMaxHealth() {
		this.maxHealth = 20.0d;
		this.health = maxHealth;
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
		return this.launchProjectile(projectile, this.velocity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
		
		Projectile projectil = null;
		
		if(projectile.isAssignableFrom(IArrow.class)) {
			projectil = new IArrow(server, location);
		}
		
		if(projectile.isAssignableFrom(IEgg.class)) {
			projectil = new IEgg(server, location);
		}
		
		if(projectile.isAssignableFrom(ISnowBall.class)) {
			projectil = new ISnowBall(server, location);
		}
		
		projectil.setVelocity(velocity);
		
		return (T) projectil;
	}

	@Override
	public double getEyeHeight() {
		return 0.8;
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getEyeLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent,
			int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(Set<Material> transparent,
			int maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Egg throwEgg() {
		return this.launchProjectile(Egg.class, this.velocity);
	}

	@Override
	public Snowball throwSnowball() {
		return this.launchProjectile(Snowball.class, this.velocity);
	}

	@Override
	public Arrow shootArrow() {
		return this.launchProjectile(IArrow.class, this.velocity);
	}

	@Override
	public int getRemainingAir() {
		return this.air;
	}

	@Override
	public void setRemainingAir(int ticks) {
		this.air = ticks;
	}

	@Override
	public int getMaximumAir() {
		return this.maxAir;
	}

	@Override
	public void setMaximumAir(int ticks) {
		this.maxAir = ticks;
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return this.maxNoDamage;
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {
		this.maxNoDamage = ticks;
	}

	@Override
	public double getLastDamage() {
		return this.lastDamage;
	}

	@Override
	public int _INVALID_getLastDamage() {
		return (int) this.lastDamage;
	}

	@Override
	public void setLastDamage(double damage) {
		this.lastDamage = damage;
	}

	@Override
	public void _INVALID_setLastDamage(int damage) {
		this.lastDamage = (double) damage;
	}

	@Override
	public int getNoDamageTicks() {
		return this.noDamage;
	}

	@Override
	public void setNoDamageTicks(int ticks) {
		this.noDamage = ticks;
	}

	@Override
	public Player getKiller() {
		return this.source;
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect, boolean force) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> effects) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLineOfSight(Entity other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		return this.removeFarAway;
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove) {
		this.removeFarAway = remove;
	}

	@Override
	public EntityEquipment getEquipment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCanPickupItems(boolean pickup) {
		this.canPickup = pickup;
	}

	@Override
	public boolean getCanPickupItems() {
		return this.canPickup;
	}

	@Override
	public boolean isLeashed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setLeashHolder(Entity holder) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract Sound getHurtSound();
	
	public abstract Sound getDeathSound();
}
