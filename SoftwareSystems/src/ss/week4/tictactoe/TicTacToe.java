package ss.week4.tictactoe;

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
    	if (args.length >= 2) {
    		name1 = args[0];
    		name2 = args[1];
    	}
        Game game = new Game(new HumanPlayer(name1, Mark.XX), new HumanPlayer(name2, Mark.OO));
        
        game.start();
    }
}
