package game;
import java.util.ArrayList;
import java.util.List;


public class BoxFactory {

	public BoxFactory() {
		// TODO Auto-generated constructor stub
	}

	
	public static Box create() {
		return create(9);
	}
	
	public static Box create(int numTiles) {
		List<Tile> tiles = new ArrayList<>();
		for (int i=1; i<numTiles+1; i++) {
			tiles.add(new Tile(i));
		}
		Box box = new Box();
		box.setTiles(tiles);
		return box;
	}
	
	
}
