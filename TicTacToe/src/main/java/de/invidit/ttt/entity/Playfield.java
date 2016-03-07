package de.invidit.ttt.entity;


public class Playfield extends GameState {

	private int dimension;
	
	public Playfield(int dimension) {
		super(new String[dimension * dimension]);
		this.dimension = dimension;
	}
	
	public int getDimension() {
		return this.dimension;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < amountOfValues(); i++) {
			if (i > 0 && i % this.dimension == 0) {
				sb.append("\n-----\n");
			}			
			sb.append(this.squares[i]);
			if ((i+1) % this.dimension != 0) {
				sb.append("|");
			}
		}
		
		return sb.toString();
	}
}
