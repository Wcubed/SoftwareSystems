package ss.week3.bill;

public class Bill {
	public static interface Item {
		public double getAmount();
		public String toString();
	}
	
	Printer printer;
	double sum;
	
	public Bill(Printer printer) {
		this.printer = printer;
		sum = 0;
	}
	
	public void addItem(Bill.Item item) {
		printer.printLine(item.toString(), item.getAmount());
		sum += item.getAmount();
	}
	
	public void close() {
		printer.printLine("Total", sum);
	}
	
	public double getSum() {
		return sum;
	}
}
