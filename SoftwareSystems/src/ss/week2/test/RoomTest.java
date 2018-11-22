package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.*;

public class RoomTest {
    private Guest guest;
    private Room room;
    
    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testNullGuest() {
    	room.setGuest(null);
    	assertEquals(null, room.getGuest());
    }
    
    @Test
    public void testToString() {
    	assertEquals("Room 101", room.toString());
    }
    
    @Test
    public void testInitialSafe() {
    	assertTrue(room.getSafe() != null);
    	
    	assertFalse(room.getSafe().isActive());
    	assertFalse(room.getSafe().isOpen());
    }
    
}
