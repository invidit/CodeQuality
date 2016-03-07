/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok;

import de.invidit.libraries.lombok.entity.GameState;
import de.invidit.libraries.lombok.entity.Player;
import de.invidit.libraries.lombok.entity.PlayerData;
import de.invidit.libraries.lombok.entity.Playfield;
import de.invidit.libraries.lombok.entity.GameState;
import de.invidit.libraries.lombok.entity.Player;
import de.invidit.libraries.lombok.entity.PlayerData;
import de.invidit.libraries.lombok.entity.Playfield;
import de.invidit.libraries.lombok.strategy.HumanStrategy;
import de.invidit.libraries.lombok.utility.GameException;

public class TicTacToe {

	private Playfield playfield;
	
	public TicTacToe() {
		createPlayfield();
		createPlayers();
	}

	private void createPlayfield() {
		this.playfield = new Playfield(3);		
	}

	private void createPlayers() {
		playfield.addPlayer(new Player(new PlayerData("Player1", "X", new HumanStrategy())));
		playfield.addPlayer(new Player(new PlayerData("Player2", "O", new HumanStrategy())));
		playfield.setCurrentPlayer(playfield.getFirstPlayer());
	}
	
	public void run() {
		while (true) {
			System.out.println(this.playfield.toString());
	
			Player player = this.playfield.getCurrentPlayer();
			
			System.out.println("Player '" + player.getName() + "':");
			int nextPosition = player.getNextMove(getGameState());
			System.out.println("Set '" + player.getSymbol() + "' at position '" 
					+ (nextPosition+1) + "'.");
			try {
				this.playfield.applyAction(nextPosition);
			} catch (GameException e) {					
				e.printStackTrace();
			}	
				
			Player winner = this.playfield.getWinner();
			if (winner != null) {
				printGameResult("Winner is '" + winner.getName() + "'");
			}

			if (this.playfield.isGameTerminated()) {
				printGameResult("Game is a draw.");
			}
		}			
		
	}

	private void printGameResult(String gameResultText) {
		System.out.println("========================================");
		System.out.println(this.playfield.toString());
		System.out.println(gameResultText);
		System.out.println("========================================");
		System.exit(0);
	}

	private GameState getGameState() {
		return this.playfield;
	}		
}
