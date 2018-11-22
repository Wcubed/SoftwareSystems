package ss.week2.hotel;


public class Safe {
	//@ invariant isOpen() ==> isActive();
	
	Password pass;
	boolean active;
	boolean open;
	
	/**
	 * Creates a new Safe object with the default password..
	 */
	//@ ensures getPassword().testWord(Password.INITIAL) == true;
	//@ ensures isOpen() == false;
	//@ ensures isActive() == false;
	public Safe() {
		pass = new Password();
	}
	
	/**
	 * Activates the safe if the password is correct.
	 * @param passAttempt The password.
	 * @return True when the safe is now active.
	 */
	/*@ ensures getPassword().testWord(passAttempt) == true
	  @         ==> isActive() == true && \result == true;
	  @ ensures getPassword().testWord(passAttempt) == false
	  @         ==> \result == false;
	  @ ensures isOpen() == \old(isOpen());
	  @*/
	public boolean activate(String passAttempt) {
		boolean success = false;
		if (getPassword().testWord(passAttempt)) {
			active = true;
			success = true;
		}
		return success;
	}
	
	/**
	 * Closes and deactivates the safe.
	 */
	//@ ensures isActive() == false;
	//@ ensures isOpen() == false;
	public void deactivate() {
		active = false;
		open = false;
	}
	
	/**
	 * Opens the safe if the password is correct.
	 * @param passAttempt The password.
	 * @return True when the safe is now open.
	 */
	/*@ ensures getPassword().testWord(passAttempt) == true
	  @         && isActive() == true
	  @         ==> isOpen() == true && \result == true;
	  @ ensures isActive() == \old(isActive());
	  @*/
	public boolean open(String passAttempt) {
		boolean success = false;
		if (isActive() && getPassword().testWord(passAttempt)) {
			open = true;
			success = true;
		}
		return success;
	}
	
	/**
	 * Closes the safe.
	 */
	//@ ensures isOpen() == false;
	//@ ensures isActive() == \old(isActive());
	public void close() {
		open = false;
	}
	
	/**
	 * True when the safe is open.
	 * @return
	 */
	//@ pure
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * True when the safe is active.
	 * @return
	 */
	//@ pure
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Gets the password object.
	 * @return
	 */
	//@ pure
	public Password getPassword() {
		return pass;
	}
}
