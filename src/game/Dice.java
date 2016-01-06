package game;

import java.util.Random;

public class Dice {

	private final Random rand = new Random();
	private int numDice;
	private int numFaces = 6;
	
	public Dice(int numDice) {
		this.numDice = numDice;
	}
	
	public int roll() {
		int sum = 0;
		for (int i=0; i<numDice; i++) {
			int roll = 1 + rand.nextInt(numFaces);
			sum += roll;
		}
		return sum;
	}
	
	
	
}
