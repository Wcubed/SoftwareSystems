package ss.week2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ss.week2.hotel.*;

class SafeTest {

	@Test
	void testInitialState() {
		Safe safe = new Safe();

		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}

	@Test
	void testInitialPassword() {
		Safe safe = new Safe();

		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.open(Password.INITIAL));
	}

	@Test
	void testChangePassword() {
		Safe safe = new Safe();
		String pass = "blabla";

		assertTrue(safe.getPassword().setWord(Password.INITIAL, pass));
		assertTrue(safe.activate(pass));
		assertTrue(safe.open(pass));
	}

	@Test
	void testActivateWrongPass() {
		Safe safe = new Safe();

		assertFalse(safe.activate("incorrectPassword"));
		assertFalse(safe.isActive());
	}
	
	@Test
	void testActivateCorrectPass() {
		Safe safe = new Safe();

		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.isActive());
	}
	
	@Test
	void testOpenWhenInactive() {
		Safe safe = new Safe();
		
		assertFalse(safe.open(Password.INITIAL));
		assertFalse(safe.isOpen());
		
	}

	@Test
	void testOpenWrongPass() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		
		assertFalse(safe.open("wrongPass"));
		assertFalse(safe.isOpen());
	}
	
	@Test
	void testOpenCorrectPass() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		
		assertTrue(safe.open(Password.INITIAL));
		assertTrue(safe.isOpen());
	}
	
	@Test
	void testDeactivate() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		
		assertTrue(safe.isOpen());
		
		safe.deactivate();
		
		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}
	
	@Test
	void testClose() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);
		
		assertTrue(safe.isOpen());
		
		safe.close();
		
		assertFalse(safe.isOpen());
	}

}
