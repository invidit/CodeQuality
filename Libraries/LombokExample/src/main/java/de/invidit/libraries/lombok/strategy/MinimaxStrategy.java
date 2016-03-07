/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.strategy;

import java.util.HashMap;

import de.invidit.libraries.lombok.entity.GameState;
import de.invidit.libraries.lombok.utility.GameException;

public class MinimaxStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {	
		long startTime = System.currentTimeMillis();		
		int result = minimaxDecision(state);		
		System.out.println("[Calc in: " + (System.currentTimeMillis() - startTime) + " ms]");
		
		return result;
	}

	private int minimaxDecision(GameState state) {
		HashMap<Integer, Integer> opValues = new HashMap<Integer, Integer>();
		
		for(Integer operator : state.getOperators()) {
			GameState nextState = null;
			try {
				nextState = new GameState(state, operator);
			} catch (GameException e) {
				// could not occur because of valid operators
			}
			opValues.put(operator, minimaxValue(nextState));
		}		
		
		if (state.getCurrentPlayer().equals(state.getFirstPlayer())) {
			return getKeyOfMaxValue(opValues);
		}
		else {
			return getKeyOfMinValue(opValues);
		}
	}

	private int minimaxValue(GameState state) {
		if (state.getCurrentPlayer().equals(state.getFirstPlayer())) {
			return maxValue(state);
		}
		else {
			return minValue(state);
		}
	}
	
	private int maxValue(GameState state) {	
		if (state.isGameTerminated()) {
			return getUtility(state);
		}
		else {
			int value = Integer.MIN_VALUE;
			for(Integer operator : state.getOperators()) {
				try {
					value = Math.max(value, minValue(new GameState(state, operator)));
				} catch (GameException e) {
					// could not occur because of valid operators
				}
			}
			return value;
		}
	}
	
	private int minValue(GameState state) {	
		if (state.isGameTerminated()) {
			return getUtility(state);
		}
		else {
			int value = Integer.MAX_VALUE;
			for(Integer operator : state.getOperators()) {
				try {
					value = Math.min(value, maxValue(new GameState(state, operator)));
				} catch (GameException e) {
					// could not occur because of valid operators
				}
			}
			return value;
		}
	}
	
	private int getUtility(GameState state) {
		if (state.getWinner() == null) {
			return 0;
		} else if (state.getWinner().equals(state.getFirstPlayer())) {
			return 1;
		} else {
			return -1;
		}
	}

	private int getKeyOfMaxValue(HashMap<Integer, Integer> opValues) {
		int max = Integer.MIN_VALUE;
		int operator = -1;
		
		for(Integer key : opValues.keySet()) {
			if (max < opValues.get(key)) {
				max = opValues.get(key);
				operator = key;
			}
		}
		
		return operator;
	}
	
	private int getKeyOfMinValue(HashMap<Integer, Integer> opValues) {
		int min = Integer.MAX_VALUE;
		int operator = -1;
		
		for(Integer key : opValues.keySet()) {
			if (min > opValues.get(key)) {
				min = opValues.get(key);
				operator = key;
			}
		}
		
		return operator;
	}

}
