package ss.week3.pw;

public interface Checker {
	
	public static final String INITPASS = "SFDJKLS";
	
	//@ requires suggestion != null;
	//@ pure
	public default boolean acceptable(String suggestion) {
		assert suggestion != null;
		return suggestion.length() >= 6 && !suggestion.contains(" ");
	}
	
	//@ ensures acceptable(\result) == true;
	//@ pure
	public String generatePassword();
}
