package ss.week2;

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
    }
    
    /**
     * The length of this Rectangle.
     */
    //@ pure;
    public int length() {
    	return 0;
    }

    /**
     * The width of this Rectangle.
     */
    //@ pure;
    public int width() {
    	return 0;
    }

    /**
     * The area of this Rectangle.
     */
    //@ pure;
    public int area() {
    	return 0;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ pure;
    public int perimeter() {
    	return 0;
    }
}
