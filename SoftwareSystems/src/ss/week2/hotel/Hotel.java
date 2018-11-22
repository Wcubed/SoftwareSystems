package ss.week2.hotel;

public class Hotel {
	String name;
	
	Password password;
	
	Room room1;
	Room room2;
	
	public Hotel(String name) {
		this.name = name;
		
		password = new Password();
		room1 = new Room(101);
		room2 = new Room(203);
	}
	
	//@ requires guest != null;
	//@ requires pass != null;
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
	
	//@ requires guest != null;
	public void checkOut(String guest) {
		assert guest != null;
		
		Room room = getRoom(guest);
		
		if (room != null) {
			room.setGuest(null);
			room.getSafe().deactivate();
		}
	}
	
	public Room getFreeRoom() {
		Room result = null;
		if (room1.getGuest() == null) {
			result = room1;
		} else if (room2.getGuest() == null) {
			result = room2;
		}
		return result;
	}
	
	//@ requires guest != null;
	//@ pure
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
