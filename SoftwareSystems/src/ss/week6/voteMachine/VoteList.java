package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {

	HashMap<String, Integer> votes;
	
	public VoteList() {
		votes = new HashMap<String, Integer>();
	}
	
	public void addVote(String party) {
		if (votes.containsKey(party)) {
			votes.put(party, votes.get(party) + 1);
		} else {
			votes.put(party, 1);
		}
	}
	
	public Map<String, Integer> getVotes() {
		return votes;
	}
}
