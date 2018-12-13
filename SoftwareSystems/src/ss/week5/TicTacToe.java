package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	public static void main(String[] args) {
		String name1 = "Alice";
		String name2 = "Bob";

		Player player1;
		Player player2;

		if (args.length >= 1) {
			player1 = createPlayerFromArgument(args[0], Mark.XX);
		} else {
			player1 = new HumanPlayer(name1, Mark.XX);
		}

		if (args.length >= 2) {
			player2 = createPlayerFromArgument(args[1], Mark.OO);
		} else {
			player2 = new HumanPlayer(name2, Mark.OO);
		}

		Game game = new Game(player1, player2);

		game.start();
	}

	private static Player createPlayerFromArgument(String arg, Mark m) {
		Player player = null;
		if (arg.equals("-N")) {
			// Create a naive computer player.
			player = new ComputerPlayer(m);
		} else {
			// Create a human player with the given name.
			player = new HumanPlayer(arg, m);
		}

		return player;
	}
}
