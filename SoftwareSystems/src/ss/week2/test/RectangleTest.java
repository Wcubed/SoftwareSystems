package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import ss.week2.Rectangle;

public class RectangleTest {
	
	private Rectangle rectSmall;
	private Rectangle rectLarge;
	
	
	@Before
	public void setup() {
		rectSmall = new Rectangle(10, 4);
		rectLarge = new Rectangle(200, 545);
	}
	
	// Is "fail on negative numbers" necessary?
	@Test(expected = AssertionError.class)
	public void testInvalidInput() {
		new Rectangle(-10, -2);
	}

	@Test
	public void testGetters() {
		assertEquals(rectSmall.length(), 10);
		assertEquals(rectSmall.width(), 4);
		
		assertEquals(rectLarge.length(), 200);
		assertEquals(rectLarge.width(), 545);
	}
	
	@Test
	public void testArea() {
		assertEquals(rectSmall.area(), 40);
		assertEquals(rectLarge.area(), 109000);
	}
	
	@Test
	public void testPerimeter() {
		assertEquals(rectSmall.perimeter(), 28);
		assertEquals(rectLarge.perimeter(), 1490);
	}
}
