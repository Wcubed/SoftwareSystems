package ss.week4.hotel;

import ss.week2.hotel.Room;
import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {
	
	double rent;

	//@ ensures getAmount() == rent;
	//@ ensures getSafe() instanceof PricedSafe;
	//@ ensures ((PricedSafe) getSafe()).getAmount() == safeRent;
	public PricedRoom(int no, double rent, double safeRent) {
		super(no, new PricedSafe(safeRent));
		
		this.rent = rent;
	}
	
	//@ pure
	@Override
	public double getAmount() {
		return rent;
	}

	//@ pure
	@Override
	public String toString() {
		return String.format("%s: €%.2f per night", super.toString(), rent);
	}
}
