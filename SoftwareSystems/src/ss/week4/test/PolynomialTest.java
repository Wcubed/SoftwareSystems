package ss.week4.test;

import org.junit.Before;
import org.junit.Test;

import ss.week4.Polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private static final double DELTA = 1e-15;
    private Polynomial polynomial;

    @Before
    public void setUp() {
    	double[] arguments = {2.0, 3.5, 6.7, 10, -10};
    	polynomial = new Polynomial(arguments);
    }

    @Test
    public void testApply() {
        assertEquals(12.2, polynomial.apply(1), DELTA);
        assertEquals(-14.8, polynomial.apply(-1), DELTA);
        assertEquals(2, polynomial.apply(0), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(polynomial.derivative() instanceof Polynomial);
        assertEquals(3.5, polynomial.derivative().apply(0), DELTA);
        assertEquals(60.1, polynomial.derivative().apply(-1), DELTA);
    }
    
    @Test
    public void testIntegral() {
    	Polynomial integral = (Polynomial) polynomial.integral();
        assertTrue(integral instanceof Polynomial);
        assertEquals(0.0, integral.apply(0), DELTA);
        assertEquals(2.016666666666666, integral.apply(-1), DELTA);
    }
}
