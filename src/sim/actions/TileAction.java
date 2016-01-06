package sim.actions;

import game.Box;

public interface TileAction {

	public Box execute(Box box);
	public int getValue();
}
