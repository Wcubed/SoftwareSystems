package ss.week2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;

public class SafeTest {
	@Test
	public void testInitialState() {
		Safe safe = new Safe();

		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}

	@Test
	public void testInitialPassword() {
		Safe safe = new Safe();

		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.open(Password.INITIAL));
	}

	@Test
	public void testChangePassword() {
		Safe safe = new Safe();
		String pass = "blabla";

		assertTrue(safe.getPassword().setWord(Password.INITIAL, pass));
		assertTrue(safe.activate(pass));
		assertTrue(safe.open(pass));
	}

	@Test
	public void testActivateWrongPass() {
		Safe safe = new Safe();

		assertFalse(safe.activate("incorrectPassword"));
		assertFalse(safe.isActive());
	}

	@Test
	public void testActivateCorrectPass() {
		Safe safe = new Safe();

		assertTrue(safe.activate(Password.INITIAL));
		assertTrue(safe.isActive());
	}

	@Test
	public void testOpenWhenInactive() {
		Safe safe = new Safe();

		assertFalse(safe.open(Password.INITIAL));
		assertFalse(safe.isOpen());

	}

	@Test
	public void testOpenWrongPass() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);

		assertFalse(safe.open("wrongPass"));
		assertFalse(safe.isOpen());
	}

	@Test
	public void testOpenCorrectPass() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);

		assertTrue(safe.open(Password.INITIAL));
		assertTrue(safe.isOpen());
	}

	@Test
	public void testDeactivate() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);

		assertTrue(safe.isOpen());

		safe.deactivate();

		assertFalse(safe.isActive());
		assertFalse(safe.isOpen());
	}

	@Test
	public void testClose() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);
		safe.open(Password.INITIAL);

		assertTrue(safe.isOpen());

		safe.close();

		assertFalse(safe.isOpen());
	}

	
	@Test(expected = AssertionError.class)
	public void nullActivationPassword() {
		Safe safe = new Safe();

		safe.activate(null);
	}

	@Test(expected = AssertionError.class)
	public void nullOpenPassword() {
		Safe safe = new Safe();

		safe.activate(Password.INITIAL);

		safe.open(null);
	}
}
