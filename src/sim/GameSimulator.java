package sim;

import java.util.List;

import sim.actions.TileAction;
import sim.strategy.GameStrategy;
import game.Box;
import game.Dice;

public class GameSimulator {

	private Box box;
	private GameStrategy strategy;


	public GameSimulator(Box box, GameStrategy strategy) {
		this.box = box;
		this.strategy = strategy;
	}


	public void play() {

		boolean isGameOver = false;
		int numRolls = 0;
		
		while (!isGameOver) {

			// Roll the dice and decide what to do next
			Dice dice = new Dice(box.getNumDiceAllowed());
			int roll = dice.roll();
			numRolls++;
			System.out.println("=== ROLL " + numRolls + ": " + roll);
			
			isGameOver = box.isGameOver(roll);
			if (isGameOver) {
				break;
			}

			List<TileAction> actions = strategy.getActions(box, roll);
			System.out.println("Strategy recommends action(s): " + actions);
			for (TileAction a : actions) {
				a.execute(box);
			}
			
			System.out.println("Box: " + box);
			
			isGameOver = box.isSolved();

		}

		System.out.println("Game Over with box: " + box.toString());

	}



}
