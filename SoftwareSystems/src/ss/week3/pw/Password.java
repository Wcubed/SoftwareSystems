package ss.week3.pw;

public class Password {
	/**
	 * The standard initial password.
	 */
	public static final String INITIAL = "thisisaninitialpassword";	

	private String pass;
	
	/**
	 * Constructs a Password with the initial word provided in <code>INITIAL</code>.
	 */
	public Password() {
		pass = INITIAL;
	}
	
	/**
	 * Test if a given string is an acceptable password.
	 * Not acceptable: A word with less than 6 characters 
     * or a word that contains a space.
	 * @param suggestion The string to test.
	 * @return true if the suggestion is acceptable.
	 */
	public boolean acceptable(String suggestion) {
	    return suggestion.length() >= 6 && !suggestion.contains(" ");
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
		if (testWord(oldPass) && acceptable(oldPass) && acceptable(newPass)) {
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
}
