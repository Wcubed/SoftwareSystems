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
		String arg1 = "Alice";
		if (args.length >= 1) {
			arg1 = args[0];
		}
		
		String arg2 = "Bob";
		if (args.length >= 2) {
			arg2 = args[1];
		}
		
		
		Player player1 = createPlayerFromArgument(arg1, Mark.XX);
		Player player2 = createPlayerFromArgument(arg2, Mark.OO);

		Game game = new Game(player1, player2);

		game.start();
	}

	private static Player createPlayerFromArgument(String arg, Mark m) {
		Player player;
		if (arg.equals("-N")) {
			// Create a naive computer player.
			player = new ComputerPlayer(m);
		} else if (arg.equals("-S")) {
			// Create a smart computer player.
			player = new ComputerPlayer(m, new SmartStrategy());
		} else {
			// Create a human player with the given name.
			player = new HumanPlayer(arg, m);
		}

		return player;
	}
}
