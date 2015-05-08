package com.ipowered.server;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.BanEntry;
import org.bukkit.BanList;

import com.google.common.collect.Maps;

public class IBanList implements BanList {

	private HashMap<String, BanEntry> entries = Maps.newHashMap();
	
	@Override
	public BanEntry getBanEntry(String target) {
		return entries.get(target);
	}

	@Override
	public BanEntry addBan(String target, String reason, Date expires, String source) {
		
		BanEntry result = new IBanEntry(target, reason, expires, source, new Date());
		entries.put(target, result);
		result.save();
		
		return result;
	}

	@Override
	public Set<BanEntry> getBanEntries() {
		
		Set<BanEntry> result = new HashSet<BanEntry>();
		Collections.addAll(result, entries.values().toArray(new BanEntry[entries.values().size()]));
		 
		return result;
	}

	@Override
	public boolean isBanned(String target) {
		return entries.containsKey(target);
	}

	@Override
	public void pardon(String target) {
		entries.remove(target);
		IConfig.getBanEntries().set("ban." + target, null);
	}
}
