package sim.strategy;

import static org.junit.Assert.*;

import java.util.List;

import game.Box;
import game.BoxFactory;
import game.Dice;

import org.junit.Test;

import sim.actions.TileAction;

public class HighTileStrategyTest {

	
	@Test
	public void testStrategyForNewBoard() {
		
		
		Box box = BoxFactory.create();
		
		GameStrategy strategy = new HighTileStrategy();
		
		int numRolls = 1000;
		Dice dice = new Dice(2);
		
		for (int i = 0; i<numRolls; i++) {
			
			int roll = dice.roll();
			List<TileAction> actions = strategy.getActions(box, roll);
			assertFalse("Strategy should always have an option with a fresh board", actions.isEmpty());
			
		}

	}
	
	
	@Test
	public void testStrategyWhenRollIsAvailable() {
		
		Box box = BoxFactory.create();
		
		GameStrategy strategy = new HighTileStrategy();
		
		int roll = 9;
		List<TileAction> actions = strategy.getActions(box, roll);
		System.out.println("Strategy for roll: " + actions);
		assertTrue("Strategy should recommend the roll when available", actions.get(0).getValue() == roll);

	}

	@Test
	public void testStrategyWhenRollIsNotAvailable() {
		
		Box box = BoxFactory.create();
		box.closeTile(9);
		
		GameStrategy strategy = new HighTileStrategy();
		
		int roll = 9;
		List<TileAction> actions = strategy.getActions(box, roll);
		System.out.println("Strategy for roll: " + actions);


	}
	
}
