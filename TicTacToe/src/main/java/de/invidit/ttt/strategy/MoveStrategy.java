package de.invidit.ttt.strategy;

import de.invidit.ttt.entity.GameState;

/**
 * @author: Torsten Mingers
 * @since: 19.08.2015
 * @since: 55.10
 */
public interface MoveStrategy {
	int getNextPosition(GameState state);
}
