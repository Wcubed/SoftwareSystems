package ss.week3.pw;

public class Password {
	private String pass;
	private String factoryPassword;
	private Checker checker;
	

	public Password() {
		this(new BasicChecker());
	}
	
	public Password(Checker checker) {
		this.checker = checker;
		factoryPassword = Checker.INITPASS;
		pass = Checker.INITPASS;
	}
	
	/**
	 * Test if a given string is an acceptable password.
	 * Not acceptable: A word with less than 6 characters 
     * or a word that contains a space.
	 * @param suggestion The string to test.
	 * @return true if the suggestion is acceptable.
	 */
	public boolean acceptable(String suggestion) {
	    return checker.acceptable(suggestion);
	}
	
	/**
	 * Changes the password to the new password.
	 * If oldPass matches the current password,
	 * and the new password is acceptable.
	 * @param oldPass The current password.
	 * @param newPass The new password.
	 * @return true If oldPass matches the current password,
	 *         and the new password is acceptable.
	 */
	public boolean setWord(String oldPass, String newPass) {
		boolean success = false;
		if (testWord(oldPass) && acceptable(newPass)) {
			pass = newPass;
			success = true;
		}
		return success;
	}
	
	/**
	 * Tests if a given word is equal to the current password.
	 * @param test The password to test.
	 * @return true if the test matches the password.
	 */
	//@ pure
	public boolean testWord(String test) {
		return pass.equals(test);
	}
	
	//@ pure
	public String getFactoryPassword() {
		return factoryPassword;
	}
	
	//@ pure
	public Checker getChecker() {
		return checker;
	}
}
