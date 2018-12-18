package ss.week6.voteMachine;

public class VoteMachine {
	
	PartyList parties;
	VoteList votes;
	
	public VoteMachine() {
		parties = new PartyList();
		votes = new VoteList();
	}
	
	public void start() {
		
	}
	
	public void addParty(String party) {
		parties.addParty(party);
	}
	
	public void vote(String party) {
		votes.addVote(party);
	}

	public static void main(String[] args) {
		VoteMachine machine = new VoteMachine();

		machine.start();
	}

}
