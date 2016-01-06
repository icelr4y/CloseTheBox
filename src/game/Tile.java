package game;

public class Tile {

	private int value;
	private boolean isClosed;
	
	public Tile(int value) {
		this(value, false);
	}
	
	public Tile(int value, boolean isClosed) {
		this.value = value;
		this.isClosed = isClosed;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isClosed() {
		return isClosed;
	}
	
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	
}
