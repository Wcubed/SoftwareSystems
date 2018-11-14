package ss.week1.hotel;

public class Guest {
	
	/**
	 * Creates a <code>Guest</code> with the given name, without assigning a room.
	 * @param name Name of the new <code>Guest</code>.
	 */
	public Guest(String name) {
		
	}

	/**
	 * Returns the name of this <code>Guest</code>.
	 * @return The name of the <code>Guest</code>
	 */
	public String getName() {
		return "";
	}

	/**
	 * Returns the room that this <code>Guest</code> is renting.
	 * @return The room this <code>Guest</code> is renting.
	 * 		   <code>null</code> if this <code>Guest</code> is not
	 * 	       rented a room.
	 */
	public Room getRoom() {
		return null;
	}

	/**
	 * Checks this <code>Guest</code> in to a room.
	 * Makes sure the room is empty before checking in the <code>Guest</code>.
	 * @param room The room to check this <code>Guest</code> in to.
	 * @return <code>true</code> if the check-in is successful,
	 *         <code>false</code> if the room is already occupied.
	 */
	public boolean checkin(Room room) {
		return true;
	}

	/**
	 * Checks this <code>Guest</code> out from their current room.
	 * @return <code>true</code> if the check-out is successful,
	 *         <code>false</code> if the guest was not renting a room to begin with.
	 */
	public boolean checkout() {
		return true;
	}

}