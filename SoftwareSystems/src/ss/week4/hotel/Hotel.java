package ss.week4.hotel;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Password;
import ss.week2.hotel.Room;
import ss.week3.bill.Bill;
import ss.week3.bill.Printer;

public class Hotel {
	String name;
	
	Password password;
	
	PricedRoom room1;
	Room room2;
	
	public Hotel(String name) {
		this.name = name;
		
		password = new Password();
		room1 = new PricedRoom(101, 12.05, 3.89);
		room2 = new Room(203);
	}
	
	/*@ requires guest != null;
	  @ requires pass != null;
	  @ ensures getPassword().testWord(pass) && getFreeRoom() != null
	  @			==> getRoom(guest) != null && \result.getGuest().getName().equals(guest);
	  @*/
	public Room checkIn(String pass, String guest) {
		assert pass != null;
		assert guest != null;
		
		Room newRoom = null;
		
		if (getPassword().testWord(pass)) {
			newRoom = getFreeRoom();
			
			if (newRoom != null && getRoom(guest) == null) {
				newRoom.setGuest(new Guest(guest));
			}
		}
		
		return newRoom;
	}
	
	/*@ requires guest != null;
	  @ ensures getRoom(guest) == null;
	  @ ensures \old(getRoom(guest)).getSafe().isActive() == false;
	  @*/
	public void checkOut(String guest) {
		assert guest != null;
		
		Room room = getRoom(guest);
		
		if (room != null) {
			room.setGuest(null);
			room.getSafe().deactivate();
		}
	}
	
	/*@ ensures \result.getGuest() == null || \result == null;
	  @ pure
	  @*/
	public Room getFreeRoom() {
		Room result = null;
		if (room1.getGuest() == null) {
			result = room1;
		} else if (room2.getGuest() == null) {
			result = room2;
		}
		return result;
	}
	
	/*@ requires guest != null;
	  @ ensures \result.getGuest().getName().equals(guest) || \result == null;
	  @ pure
	  @*/
	public Room getRoom(String guest) {
		assert guest != null;
		
		Room result = null;
		if (room1.getGuest() != null && room1.getGuest().getName().equals(guest)) {
			result = room1;
		} else if (room2.getGuest() != null && room2.getGuest().getName().equals(guest)) {
			result = room2;
		}
		
		return result;
	}
	
	/* requires guest != null;
	 * @pure
	 */
	public Bill getBill(String guest, int nights, Printer billPrinter) {
		Bill bill = null;
		
		if (room1.getGuest().getName().equals(guest)) {
			// Guest stays at a priced room.
			bill = new Bill(billPrinter);
			for (int i = 0; i < nights; i++) {
				bill.addItem(room1);
			}
			if (room1.getSafe() instanceof PricedSafe) {
				bill.addItem((PricedSafe) room1.getSafe());	
			}		
		}
		
		bill.close();
		
		return bill;
	}
	
	//@ pure
	public Password getPassword() {
		return password;
	}
	
	//@ pure
	public String toString() {
		return String.format("Hotel: '%s' - %s: %s, safe: %s - %s: %s, safe: %s", 
				name, 
				room1, room1.getGuest(), room1.getSafe(),
				room2, room2.getGuest(), room2.getSafe());
	}
}
