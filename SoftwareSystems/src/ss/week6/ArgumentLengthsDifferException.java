package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 456L;
	int l1, l2;
	
	public ArgumentLengthsDifferException() {
		this(-1, -1);
	}

	public ArgumentLengthsDifferException(int l1, int l2) {
		super();
		this.l1 = l1;
		this.l2 = l2;
	}
	
	@Override
	public String getMessage() {
		return String.format("Arguments differ in length: %d and %d.", l1, l2);
	}
}
