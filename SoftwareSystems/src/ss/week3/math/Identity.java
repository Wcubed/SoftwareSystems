package ss.week3.math;

public class Identity implements Function, Integrable {
	public Identity() {
		
	}

	@Override
	public double apply(double argument) {
		return argument;
	}

	@Override
	public Function derivative() {
		return new Constant(1);
	}
	
	@Override
	public <T extends Function & Integrable> T integral() {
		return new LinearProduct(Constant(0.5), new Exponent(2));
	}

	@Override
	public String toString() {
		return String.format("x");
	}

	public static void main(String[] args) {
		Print.print(new Identity());
	}
}
