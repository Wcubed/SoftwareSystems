package ss.week5;

import java.util.Vector;

public class NaiveStrategy implements Strategy {

	@Override
	public String getName() {
		return "Naive";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		// Do a random move.
		Vector<Integer> moves = b.getEmptyFields();
		return moves.get((int) Math.floor(Math.random() * moves.size()));
	}

}
