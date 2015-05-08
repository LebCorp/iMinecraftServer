package com.ipowered.server;

public abstract interface IPowered {
	
	public static String MINECRAFT_VERSION = "1.8";
	public static String I_MINECRAFT_VERSION = MINECRAFT_VERSION + "(implementing BukkitAPI)";
	
	public void power();
	
	public boolean isPowered();
}
