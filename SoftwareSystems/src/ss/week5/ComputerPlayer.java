package ss.week5;

public class ComputerPlayer extends Player {
	
	private Strategy strategy;
	
	ComputerPlayer(Mark mark) {
		this(mark, new NaiveStrategy());
	}
	
	ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName(), mark);
		this.strategy = strategy;
	}

	@Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, getMark());
	}
	
	@Override
	public String getName() {
		return super.getName() + " - " + getMark().toString();
	}

}
