/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.entity;

import de.invidit.libraries.lombok.strategy.MoveStrategy;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode(exclude = {"strategy"})
public class Player {

    @Getter @Setter @NonNull
	private String name;
    @Getter
	private String symbol;
    private MoveStrategy strategy;

	public Player() {
		this.name = "";
		this.strategy = null;
		this.symbol = "?";
	}
	
	public Player(@NonNull PlayerData playerData) {
		this.name = playerData.getName();
		this.symbol = playerData.getSymbol();
		this.strategy = playerData.getStrategy();
	}

    Player(@NonNull String name, @NonNull String symbol) {
        this.name = name;
        this.symbol = symbol;
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
