package sim.strategy;

import game.Box;

import java.util.ArrayList;
import java.util.List;

import sim.actions.TileAction;

public class HighTileStrategy implements GameStrategy {

	@Override
	public List<TileAction> getActions(Box box, int roll) {

		List<List<TileAction>> availableActions = box.getAvailableActions(roll);
		System.out.println("Strategy: Selecting from actions: " + availableActions);
		List<TileAction> actions = new ArrayList<>();
		int highestTile = 0;
		for (List<TileAction> a : availableActions) {
			
			if (actions.isEmpty() || getHighestTileAction(a) > highestTile) {
				actions = a;
				highestTile = getHighestTileAction(a);
			}
		}
		
		return actions;
		
	}

	
	private static int getHighestTileAction(List<TileAction> actions) {
		int i = 0;
		for (TileAction a : actions) {
			if (a.getValue() > i) {
				i = a.getValue();
			}
		}
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
