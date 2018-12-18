package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

public class VoteTUIView implements VoteView {
	
	VoteMachine voteMachine;
	
	public VoteTUIView(VoteMachine machine) {
		voteMachine = machine;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		System.out.println("This is a voting machine.");
		
		showHelpMessage();
		
		Scanner scan = new Scanner(System.in);
		
		boolean running = true;
		
		while (running) {
			scan.hasNextLine();
			
			String input = scan.nextLine();
			
			Scanner words = new Scanner(input);
			
			
			words.close();
		}
		
		scan.close();
	}

	@Override
	public void showVotes(Map<String, Integer> votes) {
		System.out.println("The current vote tally:");
		for (Map.Entry<String, Integer> vote : votes.entrySet()) {
			System.out.println(String.format("%s: %15d", vote.getKey(), vote.getValue()));
		}

	}

	@Override
	public void showParties(List<String> parties) {
		System.out.println("The following parties are participating in the election:");
		for (String party : parties) {
			System.out.println(party);
		}
	}

	@Override
	public void showError(String message) {
		// TODO Auto-generated method stub

	}
	
	private void showHelpMessage() {
		System.out.println("Use one of the following commands:");
		System.out.println("VOTE [party]");
		System.out.println("ADD PARTY [party]");
		System.out.println("VOTES");
		System.out.println("PARTIES");
		System.out.println("EXIT");
		System.out.println("HELP");
	}

}
