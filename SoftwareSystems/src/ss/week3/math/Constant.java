package ss.week3.math;

public class Constant implements Function {
	
	private double value;

	public Constant(double value) {
		this.value = value;
	}
	
	public double apply(double argument) {
		return value;
	}
	
	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return String.format("%f", value);
	}
	
	public static void main(String[] args) {
		Print.print(new Constant(2.3));
	}
}
