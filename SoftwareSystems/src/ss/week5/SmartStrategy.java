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
		boolean randomFallback = true;
		
		for (int move : moves) {
			Board copy = b.deepCopy();
			copy.setField(move, m);
			
			int score = Integer.MIN_VALUE;
			
			if (copy.isWinner(m)) {
				score = 100;
				randomFallback = false;
			} else if (canOtherMarkWin(copy, m)) {
				score = -100;
				randomFallback = false;
			} else if (move == 4) {
				// Prefer the middle if there are no better moves.
				score = 10;
				randomFallback = false;
			} else {
				score = 0;
			}
			
			if (score > bestScore) {
				bestScore = score;
				bestMove = move;
			}
		}
		
		if (randomFallback) {
			// It doesn't matter which move we do, so pick a random one.
			bestMove = moves.get((int) Math.floor(Math.random() * moves.size()));
		}
		
		return bestMove;
	}
	
	private boolean canOtherMarkWin(Board b, Mark m) {
		boolean result = false;
		Vector<Integer> otherMoves = b.getEmptyFields();
		
		for (int otherMove : otherMoves) {
			Board otherCopy = b.deepCopy();
			otherCopy.setField(otherMove, m.other());
			
			if (otherCopy.isWinner(m.other())) {
				result = true;
				break;
			}
		}
		
		return result;
	}

}
