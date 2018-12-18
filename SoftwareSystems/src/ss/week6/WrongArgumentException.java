package ss.week6;

public class WrongArgumentException extends Exception {

	@Override
	public String getMessage() {
		return String.format("Something is wrong with the arguments.");
	}

}
