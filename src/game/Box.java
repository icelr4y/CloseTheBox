package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import sim.actions.CloseTileAction;
import sim.actions.TileAction;


public class Box {

	private List<Tile> tiles;

	public Box() {

	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}



	public boolean isSolved() {
		for (Tile tile : tiles) {
			if (!tile.isClosed()) {
				return false;
			}
		}
		return true;
	}



	public int getNumDiceAllowed() {
		Tile maxTile = getMaxVisibleTile();
		if (maxTile.getValue() <= 6) {
			return 1;
		} else {
			return 2;
		}
	}

	/**
	 * 
	 * @return visible Tile with max value (NULL if no tiles are visible);
	 */
	public Tile getMaxVisibleTile() {
		Tile maxTile = null;

		for (Tile tile : tiles) {

			boolean isOpen = !tile.isClosed();
			boolean greaterThanCurrentMax = maxTile == null || tile.getValue() > maxTile.getValue();

			if (isOpen && greaterThanCurrentMax) {
				maxTile = tile;
			}
		}
		return maxTile;
	}

	public boolean isGameOver(int roll) {

		// if the game is already solved
		if (isSolved()) {
			return true;
		}

		// if there are no actions available for the current roll
		List<List<TileAction>> actions = getAvailableActions(roll);
		if (actions.isEmpty()) {
			return true;
		}

		return false;
	}

	public List<List<TileAction>> getAvailableActions(int roll) {

		List<List<TileAction>> actions = new ArrayList<>();

		actions.addAll(getSingleTileActions(roll));
		actions.addAll(getTilePairActions(roll));

		return actions;
	}


	public Box closeTile(int value) {

		for (Tile tile : tiles) {
			if (tile.getValue() == value) {
				if (tile.isClosed()) {
					throw new IllegalStateException("Tile " + value + " was already closed");
				} else {
					tile.setClosed(true);
				}
			}
		}

		return this;
	}

	public List<List<TileAction>> getSingleTileActions(int roll) {
		// If the roll is directly available we can use it
		List<List<TileAction>> actions = new ArrayList<>();
		if (isOpen(roll)) {
			actions.add(Arrays.asList(new CloseTileAction(roll)));
		}
		return actions;
	}


	public List<List<TileAction>> getTilePairActions(int roll) {
		List<List<TileAction>> actions = new ArrayList<>();
		List<Integer> values = getOpenValues();
		Map<Integer, Integer> pairs = getSumPairs(values, roll);
		for (Integer v : pairs.keySet()) {
			actions.add(Arrays.asList(
					new CloseTileAction(v),
					new CloseTileAction(pairs.get(v))));
		}
		return actions;
	}

	public Map<Integer, Integer> getSumPairs(List<Integer> values, Integer total) {
		// algorithm from http://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number
		Map<Integer, Integer> possiblePairs = new HashMap<>();
		Map<Integer, Integer> pairs = new HashMap<>();
		for (Integer v : values) {
			if (possiblePairs.containsKey(v)) {
				// found a pair which adds up to the total
				pairs.put(total-v, v);
			} else {
				possiblePairs.put(total-v, v);
			}
		}

		return pairs;
	}


	public boolean isOpen(int value) {
		return getOpenValues().contains(value);
	}

	public List<Integer> getOpenValues() {
		List<Integer> values = new ArrayList<>();
		for (Tile tile : tiles) {
			if (!tile.isClosed()) {
				values.add(tile.getValue());
			}
		}
		return values;
	}


	@Override
	public String toString() {
		Map<Integer, String> status = new TreeMap<>();
		for (Tile tile : tiles) {
			if (tile.isClosed()) {
				status.put(tile.getValue(), "x");
			} else {
				status.put(tile.getValue(), "o");
			}
		}
		return status.toString();
	}



}
