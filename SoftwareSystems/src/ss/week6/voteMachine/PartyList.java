package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

public class PartyList {

	ArrayList<String> parties;
	
	public PartyList() {
		parties = new ArrayList<String>();
	}
	
	public boolean addParty(String party) {
		boolean result = false;
		if (!hasParty(party)) {
			parties.add(party);
			result = true;
		}
		
		return result;
	}
	
	public boolean hasParty(String party) {
		return parties.contains(party);
	}
	
	public List<String> getParties() {
		return parties;
	}
}
