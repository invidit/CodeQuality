/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.utility;

public class GameException extends Exception {
	private static final long serialVersionUID = 1L;

	public GameException(String message) {
		super(message);
	}
}
