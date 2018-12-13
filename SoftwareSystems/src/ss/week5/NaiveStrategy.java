package ss.week5;

import java.util.Vector;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

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
