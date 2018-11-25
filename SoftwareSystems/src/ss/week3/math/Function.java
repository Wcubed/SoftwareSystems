package ss.week3.math;

public interface Function {
	
    public double apply(double argument);
	
	public Function derivative();
	
	public String toString();
}
