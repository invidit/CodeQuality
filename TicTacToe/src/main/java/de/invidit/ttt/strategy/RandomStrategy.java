package de.invidit.ttt.strategy;

import java.util.List;
import java.util.Random;

import de.invidit.ttt.entity.GameState;

public class RandomStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {
		List<Integer> operators = state.getOperators();

		long startTime = System.currentTimeMillis();

		Random randomGenerator = new Random();
		int result;
		do {
			result = operators.get(randomGenerator.nextInt(operators.size()));
		} while (!resultValid(state, result));

		System.out.println("[Calc in: " + (System.currentTimeMillis() - startTime) + " ms]");

		return result;
	}

	private boolean resultValid(GameState state, int result) {
		return state.isEmptyAt(result - 1);
	}
}
