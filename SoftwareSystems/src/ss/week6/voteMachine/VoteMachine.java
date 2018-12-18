package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

public class VoteMachine {
	
	PartyList parties;
	VoteList votes;
	
	VoteTUIView view;
	
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
		
		view = new VoteTUIView(this);
	}
	
	public void start() {
		view.start();
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	/*
	 * Adds a vote to the given party.
	 * Returns `false` if the party does not exist.
	 */
	public boolean vote(String party) {
		boolean result = false;
		if (parties.hasParty(party)) {
			votes.addVote(party);
			result = true;
		}
		
		return result;
	}
	
	public List<String> getParties() {
		return parties.getParties();
	}
	
	public Map<String, Integer> getVotes() {
		return votes.getVotes();
	}

	public static void main(String[] args) {
		VoteMachine machine = new VoteMachine();

		machine.start();
	}

}
