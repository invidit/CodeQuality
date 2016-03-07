/*
 *
 *  * Copyright (c) 2016, invidIT. All rights reserved.
 *  * Use is subject to license terms.
 *
 */

package de.invidit.libraries.lombok.strategy;

import java.util.Scanner;

import de.invidit.libraries.lombok.entity.GameState;

public class HumanStrategy implements MoveStrategy {

	public int getNextPosition(GameState state) {
		String input;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Bitte Zahl zwischen 1 und " + state.amountOfValues() + " für leeres Feld eingeben:");
			input = in.next();
		} while (!inputValid(state, input));
			
		int position = Integer.parseInt(input);		
		return position-1;
	}

	private boolean inputValid(GameState state, String input) {
		if (input.isEmpty()) {
			System.out.println("Eingabe ist leer.");
			return false;
		}
		
		int position;
		try {
			position = Integer.parseInt(input);
		}
		catch (NumberFormatException e) {
			System.out.println("Eingabe ist keine Zahl.");
			return false;
		}
		
		if (!state.isEmptyAt(position-1)) {
			System.out.println("Position ist bereits besetzt.");
			return false;
		}
		
		return true;
	}
}
