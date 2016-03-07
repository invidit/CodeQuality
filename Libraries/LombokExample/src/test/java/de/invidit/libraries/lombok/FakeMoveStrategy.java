/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok;

import de.invidit.libraries.lombok.entity.GameState;
import de.invidit.libraries.lombok.entity.GameState;
import de.invidit.libraries.lombok.strategy.MoveStrategy;

public class FakeMoveStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {
		return 0;
	}

}
