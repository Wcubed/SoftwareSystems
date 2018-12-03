package ss.week3.pw;

public class TimedPassword extends Password {
	/**
	 * Seconds for which this password is valid.
	 */
	private long validTime;
	private long initTime;
	
	public TimedPassword() {
		this(60 * 60 * 24 * 7); // valid for 1 week.
	}
	
	public TimedPassword(long validTime) {
		super();
		this.validTime = validTime * 1000;
		this.initTime = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > initTime + validTime;
	}
	
	@Override
	public boolean setWord(String oldPass, String newPass) {
		boolean result = false;
		if (super.setWord(oldPass, newPass)) {
			initTime = System.currentTimeMillis();
			result = true;
		}
		return result;
	}
}
