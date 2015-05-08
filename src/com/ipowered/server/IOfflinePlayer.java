package com.ipowered.server;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class IOfflinePlayer implements OfflinePlayer {

	private boolean online;

	private String name;
	private UUID uuid;

	private boolean banned;
	private boolean whitelisted;
	private boolean playedBefore;

	private long lastPlayed;
	private long firstPlay;

	private Location bedSpawnLocation;

	private Player player;

	private BanEntry entry;
	private BanList list = new IBanList();

	public IOfflinePlayer(String name, UUID uuid, boolean op) {
		this.name = name;
		this.uuid = uuid;
		entry = list.getBanEntry(name);
	}

	@Override
	public boolean isOp() {
		return getPlayer().isOp();
	}

	@Override
	public void setOp(boolean value) {
		getPlayer().setOp(value);;
	}

	@Override
	public Map<String, Object> serialize() {

		Map<String, Object> result = new HashMap<String, Object>();

		result.put("op", isOp());
		result.put("online", this.online);
		result.put("name", this.name);
		result.put("uuid", this.uuid.toString());
		result.put("whitelisted", this.whitelisted);
		result.put("banned", this.banned);
		result.put("playedBefore", this.playedBefore);
		result.put("player", this.player.getName());
		result.put("lastPlayed", this.lastPlayed);
		result.put("firstPlayed", this.firstPlay);

		return result;
	}

	@Override
	public boolean isOnline() {
		return this.online;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public UUID getUniqueId() {
		return this.uuid;
	}

	@Override
	public boolean isBanned() {
		return this.banned;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setBanned(boolean banned) {
		this.banned = banned;

		if (banned && this.entry == null) {
			this.entry = new IBanEntry(name, "You're now banned !", new Date(
					2075, 12, 22), "Server", new Date());
		} else if (!banned && this.entry != null) {
			this.list.pardon(name);
		}
	}

	@Override
	public boolean isWhitelisted() {
		return this.whitelisted;
	}

	@Override
	public void setWhitelisted(boolean value) {
		this.whitelisted = value;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	@Override
	public long getFirstPlayed() {
		return this.firstPlay;
	}

	@Override
	public long getLastPlayed() {
		return this.lastPlayed;
	}

	@Override
	public boolean hasPlayedBefore() {
		return this.playedBefore;
	}

	@Override
	public Location getBedSpawnLocation() {
		return this.bedSpawnLocation;
	}
}
