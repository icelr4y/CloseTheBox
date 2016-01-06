package game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class DiceTest {

	@Test
	public void testRollOne() {

		int numDice = 1;
		Dice dice = new Dice(numDice);

		int numRolls = 1000;
		List<Integer> rolls = new ArrayList<>(numRolls);
		for (int i=0; i<numRolls; i++) {
			int roll = dice.roll();
			rolls.add(roll);
		}
		
		Map<Integer, Integer> freqs = new HashMap<>();
		for (int i=1; i<7; i++) {
			freqs.put(i, Collections.frequency(rolls, i));
		}
		
		System.out.println("Freqs: " + freqs);

	}

	
	@Test
	public void testRollTwo() {

		int numDice = 2;
		Dice dice = new Dice(numDice);

		int numRolls = 1000;
		List<Integer> rolls = new ArrayList<>(numRolls);
		for (int i=0; i<numRolls; i++) {
			int roll = dice.roll();
			rolls.add(roll);
		}
		
		Map<Integer, Integer> freqs = new HashMap<>();
		for (int i=1; i<13; i++) {
			freqs.put(i, Collections.frequency(rolls, i));
		}
		
		System.out.println("Freqs: " + freqs);

	}
	
}
