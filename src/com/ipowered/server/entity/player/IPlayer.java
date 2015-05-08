package com.ipowered.server.entity.player;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import com.google.common.collect.Maps;
import com.ipowered.server.IOfflinePlayer;
import com.mojang.authlib.GameProfile;

public class IPlayer extends IHumanEntity implements Player {

	//Represents the offline player of this class
	private IOfflinePlayer offlinePlayer;
	
	private String displayName;
	
	private String playerListName;
	
	private Location compassTarget;
	
	private int foodLevel = 20;
	
	private boolean sneaking;
	
	private GameProfile profile;
	
	public IPlayer(Server server, Location location, GameProfile profile) {
		super(server, location, EntityType.PLAYER);
		
		this.offlinePlayer = new IOfflinePlayer(getName(), getUniqueId(), this.isOp());
		this.profile = profile;
	}

	@Override
	public boolean isConversing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void acceptConversationInput(String input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abandonConversation(Conversation conversation,
			ConversationAbandonedEvent details) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String message) {
	}

	@Override
	public void sendMessage(String[] messages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOnline() {
		return this.offlinePlayer.isOnline();
	}

	@Override
	public boolean isBanned() {
		return this.offlinePlayer.isBanned();
	}

	@Override
	public void setBanned(boolean banned) {
		this.offlinePlayer.setBanned(banned);
	}

	@Override
	public boolean isWhitelisted() {
		return this.offlinePlayer.isWhitelisted();
	}

	@Override
	public void setWhitelisted(boolean value) {
		this.offlinePlayer.setWhitelisted(value);
	}

	@Override
	public Player getPlayer() {
		return this.offlinePlayer.getPlayer() != null ? this.offlinePlayer.getPlayer() : this;
	}

	@Override
	public long getFirstPlayed() {
		return this.offlinePlayer.getFirstPlayed();
	}

	@Override
	public long getLastPlayed() {
		return this.offlinePlayer.getLastPlayed();
	}

	@Override
	public boolean hasPlayedBefore() {
		return this.offlinePlayer.hasPlayedBefore();
	}

	@Override
	public Map<String, Object> serialize() {
		
		Map<String, Object> result = Maps.newHashMap();
		
		result.put("name", getName());
		result.put("uuid", getUniqueId().toString());
		
		result.putAll(this.offlinePlayer.serialize());
		
		return result;
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		return this.displayName;
	}

	@Override
	public void setDisplayName(String name) {
		this.displayName = name;
	}

	@Override
	public String getPlayerListName() {
		return this.playerListName;
	}

	@Override
	public void setPlayerListName(String name) {
		this.playerListName = name;
	}

	@Override
	public void setCompassTarget(Location loc) {
		this.compassTarget = loc;
	}

	@Override
	public Location getCompassTarget() {
		return this.compassTarget;
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendRawMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kickPlayer(String message) {
	}

	@Override
	public void chat(String msg) {
		
	}

	@Override
	public boolean performCommand(String command) {
		return false;
	}

	@Override
	public boolean isSneaking() {
		return this.sneaking;
	}

	@Override
	public void setSneaking(boolean sneak) {
		this.sneaking = sneak;
	}

	@Override
	public boolean isSprinting() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSprinting(boolean sprinting) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSleepingIgnored(boolean isSleeping) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSleepingIgnored() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playNote(Location loc, byte instrument, byte note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playNote(Location loc, Instrument instrument, Note note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location location, Sound sound, float volume,
			float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playSound(Location location, String sound, float volume,
			float pitch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playEffect(Location loc, Effect effect, int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location loc, Effect effect, T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendBlockChange(Location loc, Material material, byte data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sendChunkChange(Location loc, int sx, int sy, int sz,
			byte[] data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendBlockChange(Location loc, int material, byte data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSignChange(Location loc, String[] lines)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMap(MapView map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void awardAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasAchievement(Achievement achievement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void incrementStatistic(Statistic statistic)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic statistic, int amount)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic, int amount)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic statistic, int newValue)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStatistic(Statistic statistic)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStatistic(Statistic statistic, Material material)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material,
			int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic, Material material,
			int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic statistic, Material material,
			int newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStatistic(Statistic statistic, EntityType entityType)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void incrementStatistic(Statistic statistic, EntityType entityType,
			int amount) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrementStatistic(Statistic statistic, EntityType entityType,
			int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatistic(Statistic statistic, EntityType entityType,
			int newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerTime(long time, boolean relative) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getPlayerTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPlayerTimeRelative() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPlayerTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerWeather(WeatherType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WeatherType getPlayerWeather() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetPlayerWeather() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveExp(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void giveExpLevels(int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getExp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setExp(float exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTotalExperience() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTotalExperience(int exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getExhaustion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setExhaustion(float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getSaturation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSaturation(float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFoodLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFoodLevel(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location getBedSpawnLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBedSpawnLocation(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBedSpawnLocation(Location location, boolean force) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAllowFlight(boolean flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hidePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canSee(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFlying(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFlySpeed(float value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWalkSpeed(float value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getFlySpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWalkSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTexturePack(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResourcePack(String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard)
			throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHealthScaled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHealthScaled(boolean scale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealthScale(double scale) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getHealthScale() {
		// TODO Auto-generated method stub
		return 0;
	}
}
