/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.entity;

import java.util.ArrayList;
import java.util.List;

import de.invidit.libraries.lombok.utility.GameException;

public class GameState {
	private static final String EMPTY_SQUARE = " ";
	protected String[] squares;
	protected Player currentPlayer;
	private List<Player> players;
	
	private enum WinnerChecks {
		ROW,
		COLUMN,
		LEFTTORIGHT,
		RIGHTTOLEFT
	}
	
	public GameState(String[] squares) {
		this.squares = squares;
		players = new ArrayList<Player>();
		initSquares();
	}
	
	public GameState(GameState state, int operand) throws GameException {
		this.squares = state.squares.clone();
		this.currentPlayer = state.currentPlayer;
		this.players = state.players;
		applyAction(operand);
	}
		
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public boolean equalsValue(int position, String value) throws GameException {
		return getValueAt(position).equals(value);
	}

	public void applyAction(int operand) throws GameException {
		setValueAt(currentPlayer.getSymbol(), operand);	
		nextPlayer();
	}
	
	public int amountOfValues() {
		return this.squares.length;
	}
	
	public boolean isEmptyAt(int position) {
		return squares[position] == EMPTY_SQUARE;
	}
		
	public boolean isGameTerminated() {
		for (int i = 0; i < squares.length; i++) {
			if (isEmptyAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public Player getFirstPlayer() {
		if (!players.isEmpty()) {
			return players.get(0);
		}
		else {
			return null;
		}
	}
	
	public void nextPlayer() {
		int indexOfCurrentPlayer = players.indexOf(currentPlayer);
		if (indexOfCurrentPlayer == players.size() - 1) {
			currentPlayer = players.get(0);
		}
		else {
			currentPlayer = players.get(indexOfCurrentPlayer + 1);
		}
	}
	
	public List<Integer> getOperators() {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < amountOfValues(); i++) {
			if (isEmptyAt(i)) {
				result.add(i);
			}
		}		
		return result;
	}
	
	private String getValueAt(int position) throws GameException {
		if (position >= amountOfValues()) {
			throw new GameException("Position does not exist.");
		}
		return this.squares[position]; 
	}
	
	private void setValueAt(String value, int position) throws GameException {
		if (position > amountOfValues()) {
			throw new GameException("Wrong position. Must be between '0' and '" 
					+ (amountOfValues()-1) + "'.");
		}
		this.squares[position] = value;
	}
	
	private void initSquares() {
		for (int i = 0; i < this.squares.length; i++) {
			this.squares[i] = EMPTY_SQUARE;
		}		
	}
	
	public Player getWinner() {
		for(Player player : players) {
			if (isWinner(player)) {
				return player;
			}
		}
		return null;
	}
	
	private boolean isWinner(Player player) {		
		String symbol = player.getSymbol();
		for (int i = 0; i < getPlayfieldDimension(); i++) {
			if (checkWinner(WinnerChecks.ROW, symbol, i) || 
					checkWinner(WinnerChecks.COLUMN, symbol, i)) {
				return true;
			}
		}
		
		if (checkWinner(WinnerChecks.LEFTTORIGHT, symbol, 0) || 
				checkWinner(WinnerChecks.RIGHTTOLEFT, symbol, 0)) {
			return true;
		}
		
		return false;
	}
	
	private int getPlayfieldDimension() {
		return (int) Math.sqrt(amountOfValues());
	}

	private boolean checkWinner(WinnerChecks check, String value, int parameter) {
		for (int i = 0; i < getPlayfieldDimension(); i++) {
			try {
				int position;
				switch (check) {
				case ROW:
					position = calcRow(i, parameter);
					break;
				case COLUMN:
					position = calcColumn(i, parameter);
					break;
				case LEFTTORIGHT:
					position = calcDiagLeftToRight(i);
					break;
				case RIGHTTOLEFT:
					position = calcDiagRightToLeft(i);
					break;
				default:
					position = 0;
					break;
				}
				
				if (!getValueAt(position).equals(value)) {
					return false;
				}
			} catch (GameException e) {
				// could not occur
			}
		}
		return true;
	}

	private int calcDiagRightToLeft(int iteration) {
		return (iteration + 1) * getPlayfieldDimension() - (iteration + 1);		
	}

	private int calcDiagLeftToRight(int iteration) {
		return iteration + iteration * getPlayfieldDimension();
	}

	private int calcColumn(int iteration, int column) {
		return iteration * getPlayfieldDimension() + column;
	}

	private int calcRow(int iteration, int row) {
		return iteration + row * getPlayfieldDimension();
	}
}
