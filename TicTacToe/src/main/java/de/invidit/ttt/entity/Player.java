package de.invidit.ttt.entity;

import de.invidit.ttt.strategy.MoveStrategy;

public class Player {

	private String name;
	private MoveStrategy strategy;
	private String symbol;

	public Player() {
		this.name = "";
		this.strategy = null;
		this.symbol = "?";
	}
	
	public Player(PlayerData playerData) {
		this.name = playerData.getName();
		this.symbol = playerData.getSymbol();
		this.strategy = playerData.getStrategy();
	}

	Player(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	public int getNextMove(GameState state) {
		return this.strategy.getNextPosition(state);
	}
	
	public Player clone() {
		Player player = new Player();
		
		player.name = this.name;
		player.symbol = this.symbol;
		player.strategy = this.strategy;
		
		return player;
	}
}
