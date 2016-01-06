package sim.strategy;

import java.util.List;

import sim.actions.TileAction;
import game.Box;

public interface GameStrategy {

	public List<TileAction> getActions(Box box, int roll);
	
}
