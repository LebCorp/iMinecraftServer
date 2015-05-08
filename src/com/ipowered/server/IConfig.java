package com.ipowered.server;

import java.io.File;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public final class IConfig {

	private File config;
	private FileConfiguration configuration;

	private boolean loaded;

	private static IConfig server = new IConfig("properties");
	private static IConfig banEntries = new IConfig("bans");
	
	public static IConfig getServerConfig() {
		return server;
	}
	
	public static IConfig getBanEntries() {
		return banEntries;
	}
	
	public IConfig(String fileName) {
		config = new File(fileName + ".yml");

		if (!config.exists()) {
			try {
				config.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		configuration = YamlConfiguration.loadConfiguration(config);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String path) {
		return (T) configuration.get(path);
	}

	public Set<String> getKeys() {
		return configuration.getKeys(false);
	}

	public void set(String path, Object value) {
		configuration.set(path, value);
		save();
	}

	public boolean contains(String path) {
		return configuration.contains(path);
	}

	public ConfigurationSection createSection(String path) {
		ConfigurationSection section = configuration.createSection(path);
		save();
		return section;
	}

	public void save() {
		try {
			configuration.save(config);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
