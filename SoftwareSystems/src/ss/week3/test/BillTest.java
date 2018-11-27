package ss.week3.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.bill.*;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;

public class BillTest {
	class Item implements Bill.Item {
		String description;
		double amount;

		public Item(String description, double amount) {
			this.description = description;
			this.amount = amount;
		}

		@Override
		public double getAmount() {
			return amount;
		}

		@Override
		public String toString() {
			return description;
		}
	}

	private static final double DELTA = 1e-15;
	Bill bill;
	StringPrinter printer;

	@Before
	public void setup() {
		printer = new StringPrinter();
		bill = new Bill(printer);
	}

	@Test
	public void initialSumTest() {
		assertEquals(0.0, bill.getSum(), DELTA);
	}

	@Test
	public void stringTest() {
		bill.addItem(new Item("Bla", 200));
		assertThat(printer.getResult(), CoreMatchers.containsString("Bla"));
		assertThat(printer.getResult(), 
				   CoreMatchers.not(CoreMatchers.containsString("Another item")));

		bill.addItem(new Item("Another item", 312.5));
		assertThat(printer.getResult(), CoreMatchers.containsString("Bla"));
		assertThat(printer.getResult(), CoreMatchers.containsString("Another item"));
		
		bill.close();
		assertThat(printer.getResult(), CoreMatchers.containsString("Bla"));
		assertThat(printer.getResult(), CoreMatchers.containsString("Another item"));
		assertThat(printer.getResult(), CoreMatchers.containsString("Total"));
	}
	
	@Test
	public void sumTest() {
		bill.addItem(new Item("Bla", 200));
		bill.addItem(new Item("Another item", 312.5));
		assertEquals(512.5, bill.getSum(), DELTA);
		bill.addItem(new Item("Bla", -122.99));
		assertEquals(389.51, bill.getSum(), DELTA);
	}

}
