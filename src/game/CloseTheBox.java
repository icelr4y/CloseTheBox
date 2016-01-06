package game;

import sim.GameSimulator;
import sim.strategy.GameStrategy;
import sim.strategy.HighTileStrategy;
import sim.strategy.LowTileStrategy;

public class CloseTheBox {


	public static void main(String[] args) {

		int numTrials = 1000;
		int numWins = 0;

		for (int i=0; i<numTrials; i++) {
			System.out.println("====== GAME " + i + " ======");
			Box box = BoxFactory.create();

			GameStrategy strategy = new LowTileStrategy();
			GameSimulator sim = new GameSimulator(box, strategy);

			sim.play();


			if (box.isSolved()) {
				numWins++;
			}


		}

		System.out.println("\n=====================================");
		System.out.println("Strategy gets " + numWins + "/" + numTrials + " wins");



	}



}
