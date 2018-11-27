package ss.week3.math;

public class Sum implements Function, Integrable {
	
	Function g, h;
	
	public Sum(Function g, Function h) {
		this.g = g;
		this.h = h;
	}

	@Override
	public double apply(double argument) {
		return g.apply(argument) + h.apply(argument);
	}

	@Override
	public Function derivative() {
		return new Sum(g.derivative(), h.derivative());
	}
	
	@Override
	public Integrable integral() {
		return new LinearProduct(new Constant(0.5), new Exponent(2));
	}

	@Override
	public String toString() {
		return g.toString() + " + " + h.toString();
	}

	public static void main(String[] args) {
		Print.print(new Sum(new Constant(2.0), new Identity()));
	}
}