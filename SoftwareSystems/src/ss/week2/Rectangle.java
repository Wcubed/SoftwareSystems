package ss.week2;

import static org.junit.Assert.assertTrue;

public class Rectangle {
	//@ public invariant length() >= 0;
	//@ public invariant width() >= 0;
	//@ public invariant area() >= 0;
	//@ public invariant perimeter() >= 0;
	
    private int length;
    private int width;

    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@ requires length >= 0;
    //@ requires width >= 0;
    //@ ensures length() == length;
    //@ ensures width() == width;
    public Rectangle(int length, int width) {
    	assertTrue(length >= 0);
    	assertTrue(width >= 0);
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ pure
    public int length() {
    	assertTrue(length >= 0);
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ pure;
    public int width() {
    	assertTrue(width >= 0);
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result == length() * width();
    //@ pure
    public int area() {
    	assertTrue(length() >= 0);
    	assertTrue(width() >= 0);
    	return length() * width();
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result == length() * 2 + width() * 2;
    //@ pure
    public int perimeter() {
    	assertTrue(length() >= 0);
    	assertTrue(width() >= 0);
    	return length() * 2 + width() * 2;
    }
}
