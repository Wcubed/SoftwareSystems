package ss.week3.bill;

public interface Printer {

	public default String format(String text, double price) {
		return String.format("%-15s %15.2f\n", text, price);
	}

	public void printLine(String text, double price);
}
