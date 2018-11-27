package ss.week3.math;

public class Sum<T extends Function & Integrable> implements Function, Integrable {
	
	T g, h;
	
	public Sum(T g, T h) {
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
	public T integral() {
		return (T) new LinearProduct(new Constant(0.5), new Exponent(2));
	}

	@Override
	public String toString() {
		return g.toString() + " + " + h.toString();
	}

	public static void main(String[] args) {
		Print.print(new Sum(new Constant(2.0), new Identity()));
	}
}