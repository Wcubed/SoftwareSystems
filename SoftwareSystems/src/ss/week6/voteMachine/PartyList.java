package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

public class PartyList {

	ArrayList<String> parties;
	
	public PartyList() {
		parties = new ArrayList<String>();
	}
	
	public void addParty(String party) {
		parties.add(party);
	}
	
	public boolean hasParty(String party) {
		return parties.contains(party);
	}
	
	public List<String> getParties() {
		return parties;
	}
}
