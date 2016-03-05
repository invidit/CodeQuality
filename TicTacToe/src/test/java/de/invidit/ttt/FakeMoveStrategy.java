package de.invidit.ttt;

import de.invidit.ttt.entity.GameState;
import de.invidit.ttt.strategy.MoveStrategy;

public class FakeMoveStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {
		return 0;
	}

}
