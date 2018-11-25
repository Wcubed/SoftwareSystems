package ss.week3.math;

public class Exponent implements Function, Integrable {
	
	int exp;
	
	public Exponent(int exponent) {
		this.exp = exponent;
	}

	@Override
	public double apply(double argument) {
		return Math.pow(argument, exp);
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(exp), new Exponent(exp - 1));
	}
	
	@Override
	public <T extends Function & Integrable> T integral() {
		return new LinearProduct(Constant(1 / (exp + 1)), new Exponent(exp + 1));
	}
	
	@Override
	public String toString() {
		return String.format("x^%d", exp);
	}

	public static void main(String[] args) {
		Print.print(new Exponent(7));
	}

}
