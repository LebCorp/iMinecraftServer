package com.ipowered.server.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Criterias;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class IObjective implements Objective {

	private boolean registered;
	
	private String displayName;
	
	private String name;
	
	private DisplaySlot slot;
	
	private Scoreboard board;
	
	public IObjective(Scoreboard board, String name) {
		this.board = board;
		
		if(name != Criterias.DEATHS) {
			return;
		} else if(name != Criterias.HEALTH) {
			return;
		} else if(name != Criterias.PLAYER_KILLS) {
			return;
		} else if(name != Criterias.TOTAL_KILLS) {
			return;
		} else {
			this.name = name;
		}
	}
	
	@Override
	public String getName() throws IllegalStateException {
		
		if(!registered)
			throw new IllegalStateException("The objetive has been unregistered !");
		else
		
		return this.name;
	}

	@Override
	public String getDisplayName() throws IllegalStateException {
		
		if(!registered)
			throw new IllegalStateException("The objetive has been unregistered !");
		else
		
		return this.displayName;
	}

	@Override
	public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {
		if(displayName == null) 
			throw new IllegalArgumentException("The display name cannot be null");
		else
		
		if(displayName.length() > 32) 
			throw new IllegalArgumentException("The display name lenght cannot be upper than 32 characters");
		else
		
		if(!registered)
			throw new IllegalStateException("The objective " + getDisplayName() + " has been unregistered");
		
		else
		
		this.displayName = displayName;
	}

	@Override
	public String getCriteria() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModifiable() throws IllegalStateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Scoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unregister() throws IllegalStateException {
		this.registered = false;
	}

	@Override
	public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DisplaySlot getDisplaySlot() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Score getScore(String entry) throws IllegalArgumentException,
			IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}
}
