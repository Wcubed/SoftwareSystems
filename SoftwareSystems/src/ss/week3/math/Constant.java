package ss.week3.math;

public class Constant implements Function {
	
	private double value;

	public Constant(double value) {
		this.value = value;
	}
	
	@Override
	public double apply(double argument) {
		return value;
	}
	
	@Override
	public Function derivative() {
		return new Constant(0);
	}

	@Override
	public String toString() {
		return String.format("%.2f", value);
	}
	
	public static void main(String[] args) {
		Print.print(new Constant(2.3));
	}
}
