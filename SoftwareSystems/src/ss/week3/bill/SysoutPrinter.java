package ss.week3.bill;

public class SysoutPrinter implements Printer {

	@Override
	public void printLine(String text, double price) {
		System.out.print(format(text, price));
	}
	
	public static void main(String[] args) {
		SysoutPrinter printer = new SysoutPrinter();
		
		printer.printLine("Things", 2.75568);
		printer.printLine("Some other stuff", -192.7005);
		printer.printLine("Banana", 0);
		printer.printLine("Wd-40", 12);
		printer.printLine("Pumpkins", -1098.9292);
	}

}
