package com.ipowered.server.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

public class PowerCommand extends IPoweredCommand {

	protected PowerCommand() {
		super("power", "/power", Arrays.asList("pow", "force", "ipowered"));
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		
		boolean powered = super.isPowered();
		
		int count = 0;
		
		if(!powered && count == 0 || count == 0 || !powered) {
			sender.sendMessage("¤6Do you want to power this server if yes do /power one more time ?");
			powered = false;
		}
		
		if(count == 1) {
			super.power();
			sender.sendMessage("¤7The server is now powered !");
			count = 0;
		}
		
		
		count++;
		
		return false;
	}
}
