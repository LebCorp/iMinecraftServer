package com.ipowered.server.command;

import java.util.List;

import org.bukkit.command.defaults.BukkitCommand;

import com.ipowered.server.IPowered;

public abstract class IPoweredCommand extends BukkitCommand implements IPowered {

	private boolean powered = false;
	
	protected IPoweredCommand(String name) {
		super(name);
	}

	protected IPoweredCommand(String name, String usageMessage, List<String> aliases) {
		super(name, "¤6An IPowered command", usageMessage, aliases);
	}
	
	@Override
	public void power() {
		powered = true;
	}
	
	@Override
	public boolean isPowered() {
		return powered;
	}
}
