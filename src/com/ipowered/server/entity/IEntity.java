package com.ipowered.server.entity;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.Validate;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import org.bukkit.event.entity.EntityPortalExitEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataStore;
import org.bukkit.metadata.MetadataStoreBase;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import com.google.common.collect.Lists;
import com.ipowered.server.Position;

public abstract class IEntity implements Entity {

	private static final class EntityMetadataStore extends
			MetadataStoreBase<Entity> implements MetadataStore<Entity> {
		@Override
		protected String disambiguate(Entity subject, String metadataKey) {
			return subject.getUniqueId() + ":" + metadataKey;
		}
	}

	protected Location location;
	protected Location previousLoc;
	protected boolean locationChanged;

	protected Vector velocity;
	protected boolean velocityChanged = false;

	protected World world;

	protected String customName;
	protected boolean customNameVisible;
	
	protected int id;
	
	protected int fireTicks;
	protected int maxFireTicks;
	
	protected UUID uuid;
	
	protected Entity vehicule;
	protected List<Entity> passengers;
	
	protected boolean isValid;
	
	protected boolean onGround;
	
	protected EntityType type;
	
	protected int tickLived;
	
	protected float fallDistance;
	
	protected EntityDamageEvent damageCause;

	protected MetadataStore<Entity> bukkitMetadatas = new EntityMetadataStore();

	protected Server server;
	
	protected EntityManager manager = new EntityManager();
	
	@SuppressWarnings("deprecation")
	public IEntity(Server server, Location location, EntityType type) {
		this.server = server;
		this.location = location;
		this.velocity = location.toVector();
		this.world = location.getWorld();
		this.previousLoc = location.clone();
		this.passengers = Lists.newArrayList();
		this.id = type.getTypeId();
		this.manager.register(this);
		this.type = type;
	}
	
	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		Validate.notNull(metadataKey, "The key cannot be null !");
		Validate.notNull(newMetadataValue,
				"The new metadata value cannot be null !");

		bukkitMetadatas.setMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return bukkitMetadatas.getMetadata(this, metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return bukkitMetadatas.hasMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		bukkitMetadatas.removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public Location getLocation(Location loc) {
		return Position.copyOf(this.location, loc);
	}

	@Override
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
		this.velocityChanged = true;
	}

	@Override
	public Vector getVelocity() {
		return this.velocity;
	}

	@Override
	public boolean isOnGround() {
		return this.onGround;
	}

	@Override
	public World getWorld() {
		return this.world;
	}

	@Override
	public boolean teleport(Location location) {
		
		Validate.notNull(location, "Cannot teleport player to this location (null) !");
		
		this.previousLoc = this.location;
		this.location = location;
		
		if(location.getWorld() != world) {
			World world = location.getWorld();
			
			this.world.getEntities().remove(this);
			this.manager.remove(this);
			world.getEntities().add(this);
			this.manager.register(this);
		}
		
		return this.locationChanged;
	}

	@Override
	public boolean teleport(Location location, TeleportCause cause) {
		return this.teleport(location);
	}

	@Override
	public boolean teleport(Entity destination) {
		return this.teleport(destination.getLocation());
	}

	@Override
	public boolean teleport(Entity destination, TeleportCause cause) {
		return this.teleport(destination.getLocation(), cause);
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getEntityId() {
		return this.id;
	}

	@Override
	public int getFireTicks() {
		return this.fireTicks;
	}

	@Override
	public int getMaxFireTicks() {
		return this.maxFireTicks;
	}

	@Override
	public void setFireTicks(int ticks) {
		this.fireTicks = ticks;
	}

	@Override
	public void remove() {
		this.locationChanged = false;
		this.velocityChanged = false;
		this.world.getEntities().remove(this);
		this.isValid = false;
	}

	@Override
	public boolean isDead() {
		return !isValid;
	}

	@Override
	public boolean isValid() {
		return isValid;
	}

	@Override
	public Server getServer() {
		return this.server;
	}

	@Override
	public Entity getPassenger() {
		return this.passengers.get(0);
	}

	@Override
	public boolean setPassenger(Entity passenger) {
		
		if(this.passengers.contains(passenger)) {
			return false;
		}
		
		return this.passengers.add(passenger);
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean eject() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public float getFallDistance() {
		return this.fallDistance;
	}

	@Override
	public void setFallDistance(float distance) {
		this.fallDistance = distance;
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {
		this.damageCause = event;
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		return this.damageCause;
	}

	@Override
	public UUID getUniqueId() {
		return this.uuid != null ? this.uuid : (this.uuid = UUID.randomUUID());
	}

	@Override
	public int getTicksLived() {
		return this.tickLived;
	}

	@Override
	public void setTicksLived(int value) {
		this.tickLived = value;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void playEffect(EntityEffect type) {
		this.world.playEffect(this.location, Effect.valueOf(type.name()), type.getData());
	}

	@Override
	public EntityType getType() {
		return this.type;
	}

	@Override
	public boolean isInsideVehicle() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean leaveVehicle() {
		
		IEntity entity = (IEntity) vehicule;
		
		entity.passengers.remove(this);
		
		this.vehicule = null;
		
		return true;
	}

	@Override
	public Entity getVehicle() {
		return this.vehicule;
	}

	@Override
	public void setCustomName(String name) {
		this.customName = name;
	}

	@Override
	public String getCustomName() {
		return this.customName;
	}

	@Override
	public void setCustomNameVisible(boolean flag) {
		this.customNameVisible = flag;
	}

	@Override
	public boolean isCustomNameVisible() {
		return this.customNameVisible;
	}
	
	public boolean locationChanged() {
		return this.locationChanged;
	}

	public boolean velocityChanged() {
		return this.velocityChanged;
	}
	
	public Location getPreviousLocation() {
		return previousLoc;
	}
	
	 public void pulse() {
	        this.tickLived++;

	        if (fireTicks > 0) {
	            --fireTicks;
	        }
	        
	        // metadata.setBit(MetadataIndex.STATUS, MetadataIndex.StatusFlags.ON_FIRE, fireTicks > 0);

	        // resend position if it's been a while
	        if (tickLived % (30 * 20) == 0) {
	            this.locationChanged = true;
	        }

	       //TODO: pulsePhysics();

	        if (locationChanged()) {
	            Block currentBlock = location.getBlock();
	            if (currentBlock.getType() == Material.ENDER_PORTAL) {
	               // EventFactory.callEvent(new EntityPortalEnterEvent(this, currentBlock.getLocation()));
	                if (server.getAllowEnd()) {
	                    Location previousLocation = location.clone();
	                    boolean success = false;
	                    if (getWorld().getEnvironment() == World.Environment.THE_END) {
	                    	// success = teleportToSpawn();
	                    } else {
	                       // success = teleportToEnd();
	                    }
	                    if (success) {
	                        //EntityPortalExitEvent e = EventFactory.callEvent(new EntityPortalExitEvent(this, previousLocation, location.clone(), velocity.clone(), new Vector()));
	                       // if (!e.getAfter().equals(velocity)) {
	                         //   setVelocity(e.getAfter());
	                        //}
	                    }
	                }
	            }
	        }
	    }
}
