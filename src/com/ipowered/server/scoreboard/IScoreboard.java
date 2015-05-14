package com.ipowered.server.scoreboard;

import java.util.Set;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class IScoreboard implements Scoreboard {

	@Override
	public Objective registerNewObjective(String name, String criteria)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Objective getObjective(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Objective> getObjectivesByCriteria(String criteria)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Objective> getObjectives() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Objective getObjective(DisplaySlot slot)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Score> getScores(OfflinePlayer player)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Score> getScores(String entry) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetScores(OfflinePlayer player)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetScores(String entry) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team getPlayerTeam(OfflinePlayer player)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team getTeam(String teamName) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Team> getTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team registerNewTeam(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OfflinePlayer> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
}
