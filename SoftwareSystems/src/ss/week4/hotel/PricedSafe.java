package ss.week4.hotel;

import ss.week2.hotel.Safe;
import ss.week3.bill.Bill;

public class PricedSafe extends Safe implements Bill.Item {
	
	private double price;

	//@ ensures getAmount() == price;
	public PricedSafe(double price) {
		super();
		this.price = price;
	}
	
	//@ pure
	@Override
	public double getAmount() {
		return price;
	}

	//@ pure
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Safe: €%.2f", price);
	}
	
}
