
package game;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import sim.actions.TileAction;

public class BoxTest {

	
	@Test
	public void testIsSolved() {
		Box box = BoxFactory.create();
		
		box.closeTile(1);
		box.closeTile(2);
		box.closeTile(3);
		box.closeTile(4);
		box.closeTile(5);
		box.closeTile(6);
		box.closeTile(7);
		box.closeTile(8);
		box.closeTile(9);
		
		assertTrue("Game should be over for a completely closed box", box.isGameOver(1));
		assertTrue("Game should be solved for a competely closed box", box.isSolved());
	}
	

	@Test
	public void testIsLost() {
		Box box = BoxFactory.create();
		
		box.closeTile(1);
		box.closeTile(2);
		box.closeTile(3);
		// 4 is only tile left 
		box.closeTile(5);
		box.closeTile(6);
		box.closeTile(7);
		box.closeTile(8);
		box.closeTile(9);
		
		assertTrue("Game should be over for an incorrect final roll", box.isGameOver(5));
		assertFalse("Game should be lost for an incorrect final roll", box.isSolved());
	}
	
	
	
	
	
	@Test
	public void testGetSumPairs() {

		List<Integer> values = Arrays.asList(2, 45, 7, 3, 5, 1, 8, 9);
		int total = 10;

		Box box = new Box();
		Map<Integer, Integer> pairs = box.getSumPairs(values, total);

		System.out.println("Pairs: " + pairs);

	}

	@Test
	public void testGetAvailableActions() {
		
		Box box = BoxFactory.create();
		
		box.closeTile(4);
		box.closeTile(5);
		box.closeTile(8);
		
		List<List<TileAction>> actions = box.getAvailableActions(5);
		
		System.out.println("Actions: " + actions);

		
	}
	
	
	
	
	
	
	
}
