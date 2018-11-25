package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	
	public static final String INITPASS = "SFDJKLS5";
	
	@Override
	public boolean acceptable(String suggestion) {
		assert suggestion != null;
		return super.acceptable(suggestion)
			   && Character.isLetter(suggestion.charAt(0))
			   && Character.isDigit(suggestion.charAt(suggestion.length()));
	}

	@Override
	public String generatePassword() {
		return "n" + super.generatePassword() + "8";
	}
}
