package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {

	@Override
	public String getMessage() {
		return String.format("Not enough arguments are given.");
	}
}
