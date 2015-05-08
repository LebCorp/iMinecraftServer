package com.ipowered.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.BanList;
import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning.WarningState;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.collect.Lists;
import com.ipowered.server.inventory.meta.IBookMeta;


public class IServer implements Server {

	private SimpleCommandMap commandMap = new SimpleCommandMap(this);
	private PluginManager pluginManager = new SimplePluginManager(this, commandMap);
	
	private Collection<Player> onlinePlayers = Lists.newArrayList();
	private Collection<World> worlds = Lists.newArrayList();
	
	public static final Logger logger = Logger.getLogger("IPowered");
	
	private IConfig server_config = IConfig.getServerConfig();
	
	private ItemFactory factory = new IItemFactory();
	
	private boolean loaded;
	
	public IServer() {
	}
	
	public void load() {

		if (loaded == true) {
			return;
		} else {

			server_config.set("maxPlayers", "24");
			server_config.set("port", "25565");
			server_config.set("ip", "localhost");
			server_config.set("worldType", "normal");
			server_config.set("generateStructures", "true");
			server_config.set("allowEnd", "true");
			server_config.set("allowNether", "true");
			server_config.set("whitelist", "false");
			server_config.set("motd", "A default IPowered server'");
			server_config.set("serverName", "IPowered");

			loaded = true;
		}
	}
	
	public static void main(String[] args) {
		
		Bukkit.setServer(new IServer());
		
		ItemStack book = new ItemStack(Material.BOOK);
		BookMeta meta = (BookMeta) book.getItemMeta();
		meta.setDisplayName("Book");
		meta.setLore(Arrays.asList("A simple book !"));
		meta.setTitle("Book by Benjamin");
		meta.setAuthor("LebCorp");
		
		if(book.setItemMeta(meta))
		System.out.println(meta.getDisplayName());
		
		System.out.println(book.getItemMeta().getDisplayName());
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
	public String getName() {
		return "IServer (implementing bukkit api)";
	}

	@Override
	public String getVersion() {
		return "V0.1";
	}

	@Override
	public String getBukkitVersion() {
		return "Bukkit 1.8 API";
	}

	@Override
	public Player[] _INVALID_getOnlinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Player> getOnlinePlayers() {
		return onlinePlayers;
	}

	@Override
	public int getMaxPlayers() {
		return Integer.valueOf(server_config.<String>get("maxPlayers"));
	}

	@Override
	public int getPort() {
		return Integer.valueOf(server_config.<String>get("port"));
	}

	@Override
	public int getViewDistance() {
		return 0;
	}

	@Override
	public String getIp() {
		return server_config.<String>get("ip");
	}

	@Override
	public String getServerName() {
		return server_config.<String>get("serverName");
	}

	@Override
	public String getServerId() {
		return null;
	}

	@Override
	public String getWorldType() {
		return server_config.<String>get("worldType");
	}

	@Override
	public boolean getGenerateStructures() {
		return Boolean.valueOf(server_config.<String>get("generateStructures"));
	}

	@Override
	public boolean getAllowEnd() {
		return Boolean.valueOf(server_config.<String>get("allowEnd"));
	}

	@Override
	public boolean getAllowNether() {
		return Boolean.valueOf(server_config.<String>get("allowNether"));
	}

	@Override
	public boolean hasWhitelist() {
		return Boolean.valueOf(server_config.<String>get("whitelist"));
	}

	@Override
	public void setWhitelist(boolean value) {
		server_config.set("whitelist", String.valueOf(value));
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reloadWhitelist() {
		getWhitelistedPlayers().removeAll(getWhitelistedPlayers());
	}

	@Override
	public int broadcastMessage(String message) {
		return 0;
	}

	@Override
	public String getUpdateFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getConnectionThrottle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Player getPlayer(String name) {
		
		Player player = null;
		
		for(Player p : onlinePlayers) {
			player = p;
			
			if(player.getName() == name)
			return player;
		}
		
		return null;
	}

	@Override
	public Player getPlayerExact(String name) {
		return getPlayer(name);
	}

	@Override
	public List<Player> matchPlayer(String name) {
		
		String trimedName = name.trim();
		trimedName = trimedName.toLowerCase();
		
		List<Player> matchers = Lists.newArrayList();
		
		for(Player player : onlinePlayers) {
			if(player.getName().equalsIgnoreCase(trimedName)) {
				matchers.add(player);
			}
		}
		
		return matchers;
	}

	@Override
	public Player getPlayer(UUID id) {
		
		for(Player player : onlinePlayers) {
			if(player.getUniqueId() == id) {
				return player;
			}
		}
		
		return null;
	}

	@Override
	public PluginManager getPluginManager() {
		return this.pluginManager;
	}

	@Override
	public BukkitScheduler getScheduler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicesManager getServicesManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<World> getWorlds() {
		return (List<World>) this.worlds;
	}

	@Override
	public World createWorld(WorldCreator creator) {
		
		return null;
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public World getWorld(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getWorld(UUID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapView getMap(short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapView createMap(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Logger getLogger() {
		return logger;
	}

	@Override
	public PluginCommand getPluginCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePlayers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean dispatchCommand(CommandSender sender, String commandLine)
			throws CommandException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSpawnRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSpawnRadius(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getOnlineMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHardcore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int broadcast(String message, String permission) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer getOfflinePlayer(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getIPBans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void banIP(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbanIP(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BanList getBanList(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameMode getDefaultGameMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getWorldContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Messenger getMessenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type,
			String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size,
			String title) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmbientSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPrimaryThread() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMotd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShutdownMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WarningState getWarningState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemFactory getItemFactory() {
		return factory;
	}

	@Override
	public ScoreboardManager getScoreboardManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CachedServerIcon getServerIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CachedServerIcon loadServerIcon(File file)
			throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CachedServerIcon loadServerIcon(BufferedImage image)
			throws IllegalArgumentException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdleTimeout(int threshold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UnsafeValues getUnsafe() {
		// TODO Auto-generated method stub
		return null;
	}
}
