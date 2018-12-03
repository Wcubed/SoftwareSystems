package ss.week3.bill;

public class StringPrinter implements Printer {
	
	String result;
	
	public StringPrinter() {
		result = "";
	}

	@Override
	public void printLine(String text, double price) {
		result += format(text, price);
	}
	
	public String getResult() {
		return result;
	}
	
	public static void main(String[] args) {
		StringPrinter printer = new StringPrinter();
		
		printer.printLine("Things", 2.75568);
		printer.printLine("Some other stuff", -192.7005);
		printer.printLine("Banana", 0);
		printer.printLine("Wd-40", 12);
		printer.printLine("Pumpkins", -1098.9292);
		
		System.out.println(printer.getResult());
	}

}
