package sim.actions;

import game.Box;

public class CloseTileAction implements TileAction {

	private int value;
	
	
	public CloseTileAction(int value) {
		this.value = value;
	}
	
	
	public Box execute(Box box) {
		if (box.isOpen(value)) {
			box.closeTile(value);
		}
		
		return box;
	}
	
	
	@Override
	public String toString() {
		return "CloseTile" + value;
	}


	@Override
	public int getValue() {
		return value;
	}
}
