package sim.actions;

import static org.junit.Assert.*;
import game.Box;
import game.BoxFactory;

import org.junit.Test;

public class CloseTileActionTest {

	@Test
	public void testCloseTile() {

		Box box = BoxFactory.create();
		
		
		int tileValue = 5;
		TileAction action = new CloseTileAction(tileValue);
		
		action.execute(box);
		
		
		assertFalse("Tile value " + tileValue + " should be closed", box.getOpenValues().contains(tileValue));
		
		
		
	
	
	}

}
