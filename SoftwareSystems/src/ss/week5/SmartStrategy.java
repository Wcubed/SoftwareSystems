package ss.week5;

import java.util.Vector;

public class SmartStrategy implements Strategy {

	@Override
	public String getName() {
		return "Smart";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		// Do a random move.
		Vector<Integer> moves = b.getEmptyFields();
		
		int bestMove = -1;
		int bestScore = Integer.MIN_VALUE;
		
		for (int move : moves) {
			Board copy = b.deepCopy();
			b.setField(move, m);
			
			int score = Integer.MIN_VALUE;
			
			if (copy.isWinner(m)) {
				score = 100;
			} else if (copy.isWinner(m.other())) {
				score = -100;
			} else if (move == 4) {
				// Prefer the middle if there are no winning or losing moves.
				score = 10;
			} else {
				score = 0;
			}
			
			if (score > bestScore) {
				bestScore = score;
				bestMove = move;
			}
		}

		if (bestScore == 0) {
			// It  doesn't matter which move we make, so do a random one.
			bestMove = moves.get((int) Math.floor(Math.random() * moves.size()));
		}
		
		return bestMove;
	}

}
