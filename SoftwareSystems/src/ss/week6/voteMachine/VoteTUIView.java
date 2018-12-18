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
		if ("vote".equals(arg1)) {
			System.out.println("The vote tally changed.");
		} else if ("party".equals(arg1)) {
			System.out.println("The party list changed.");
		}
	}

	@Override
	public void start() {
		System.out.println("Hello human, I am a voting machine.");

		showHelpMessage();

		Scanner scan = new Scanner(System.in);

		boolean running = true;

		while (running) {
			System.out.print(">> ");
			
			scan.hasNextLine();

			String input = scan.nextLine();

			Scanner words = new Scanner(input);

			try {
				
				switch (words.next()) {
					case "VOTES":
						showVotes(voteMachine.getVotes());
						break;
						
					case "PARTIES":
						showParties(voteMachine.getParties());
						break;
						
					case "EXIT":
						System.out.println("Goodbye!");
						running = false;
						break;
						
					case "HELP":
						showHelpMessage();
						break;
						
					case "ADD":
						if (words.next().equals("PARTY")) {
							if (words.hasNext()) {
								String party = words.next();
								if (voteMachine.addParty(party)) {
									System.out.printf("Added \"%s\" to the election.\n", party);
								} else {
									System.out.printf("Sorry, \"%s\" is already participating.\n", 
											party);
								}
							} else {
								System.out.println("Please specify a name for the party.");
							}
						}
						break;
						
					case "VOTE":
						String party = words.next();
						if (!party.equals("")) {
							if (voteMachine.vote(party)) {
								System.out.printf("Voted for \"%s\".\n", party);
							} else {
								System.out.printf("Sorry, the party \"%s\" does not exist.\n",
										party);
								showParties(voteMachine.getParties());
							}
						}
						break;
						
				}
				
			} catch (java.util.NoSuchElementException e) {
		    	// No input, don't do anything.
				// Just loop around and show the prompt again.
		    }

			words.close();
		}

		scan.close();
	}

	@Override
	public void showVotes(Map<String, Integer> votes) {
		System.out.println("The current vote tally:");
		for (Map.Entry<String, Integer> vote : votes.entrySet()) {
			System.out.println(String.format("%-15s %10d", vote.getKey(), vote.getValue()));
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
		System.out.println("This is a voting machine that can be used to "
				+ "vote on parties in the current election.");
		System.out.println("It supports the following commands:");
		System.out.println("");
		System.out.println("VOTE [party]       - Vote for the given party.");
		System.out.println("ADD PARTY [party]  - Add a party to the election.");
		System.out.println("VOTES              - Show all the tallied votes.");
		System.out.println("PARTIES            - Show all the parties "
				+ "participating in this election.");
		System.out.println("EXIT               - Exit the program.");
		System.out.println("HELP               - Show this help message.");
		System.out.println("");
	}

}
