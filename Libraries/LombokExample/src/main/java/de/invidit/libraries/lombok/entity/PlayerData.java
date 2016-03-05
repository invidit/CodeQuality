/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.entity;

import de.invidit.libraries.lombok.strategy.MoveStrategy;
import lombok.Data;

@Data
public class PlayerData {
	private final String name;
    private final String symbol;
    private final MoveStrategy strategy;
}
