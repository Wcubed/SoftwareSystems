package ss.week1;

public class DollarsAndCentsCounter {
	private int dollar_value;
	private int cent_value;
	
	public int dollars() {
		return dollar_value;
	}
	
	public int cents() {
		return cent_value;
	}
	
	public void add(int dollars, int cents) {
		if (dollars > 0) {
			dollar_value += dollars;
		}
		if (cents > 0) {
			cent_value += cents;
			dollar_value += cent_value / 100;
			cent_value = cent_value % 100;
		}
	}
	
	public void reset() {
		dollar_value = 0;
		cent_value = 0;
	}
}
