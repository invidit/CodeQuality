package de.invidit.ttt.entity;

import de.invidit.ttt.strategy.MoveStrategy;

public class PlayerData {
	private final String name;
	private final String symbol;
	private final MoveStrategy strategy;

	public PlayerData(String name, String symbol, MoveStrategy strategy) {
		this.name = name;
		this.symbol = symbol;
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public MoveStrategy getStrategy() {
		return strategy;
	}
}
