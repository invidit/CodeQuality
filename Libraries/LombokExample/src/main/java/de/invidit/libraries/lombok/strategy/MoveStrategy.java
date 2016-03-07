/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.strategy;

import de.invidit.libraries.lombok.entity.GameState;

/**
 * @author: Torsten Mingers
 * @since: 19.08.2015
 * @since: 55.10
 */
public interface MoveStrategy {
	int getNextPosition(GameState state);
}
