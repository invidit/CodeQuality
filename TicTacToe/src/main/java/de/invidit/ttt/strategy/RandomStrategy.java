package de.invidit.ttt.strategy;

import java.util.List;
import java.util.Random;

import de.invidit.ttt.entity.GameState;

public class RandomStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {				
		List<Integer> operators = state.getOperators();

		long startTime = System.currentTimeMillis();
		
		Random randomGenerator = new Random();
		int result = operators.get(randomGenerator.nextInt(operators.size()));
		
		System.out.println("[Calc in: " + (System.currentTimeMillis() - startTime) + " ms]");
		
	    return result;
	}

}
