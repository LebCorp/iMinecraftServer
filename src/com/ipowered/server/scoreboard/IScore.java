package com.ipowered.server.scoreboard;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class IScore implements Score {

	/** Represents the board of this score */
	private Scoreboard board;
	
	/** Represents the objective of this score */
	private Objective objective;
	
	/** Represents the tracked player of this score */
	private OfflinePlayer player;
	
	/** Represents the int value of this score */
	private int score;
 	
	public IScore(Scoreboard board, Objective objective, OfflinePlayer player) {
		this.board = board;
		this.objective = objective;
	}
	
	@Override
	public OfflinePlayer getPlayer() {
		return this.player;
	}

	@Override
	public String getEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Objective getObjective() {
		return this.objective;
	}

	@Override
	public int getScore() throws IllegalStateException {
		return this.score;
	}

	@Override
	public void setScore(int score) throws IllegalStateException {
		this.score = score;
	}

	@Override
	public Scoreboard getScoreboard() {
		return this.board;
	}
}
