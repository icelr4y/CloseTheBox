package game;

import static org.junit.Assert.*;
import game.Box;
import game.BoxFactory;
import game.Tile;

import org.junit.Test;


public class BoxFactoryTest {

	@Test
	public void testNewBoxShouldNotBeSolved() {
		Box box = BoxFactory.create();
		assertFalse("New box should not be solved", box.isSolved());
	}

	@Test
	public void testSolvedBox() {
		Box box = BoxFactory.create();
		for (Tile tile : box.getTiles()) {
			tile.setClosed(true);
		}
		assertTrue("Box should be solved with all tiles closed", box.isSolved());
	}
	
}
