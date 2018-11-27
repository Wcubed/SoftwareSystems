package ss.week3.math;

public class Product implements Function {
	
	Function g, h;
	
	public Product(Function g, Function h) {
		this.g = g;
		this.h = h;
	}

	@Override
	public double apply(double argument) {
		return g.apply(argument) * h.apply(argument);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(g.derivative(), h), new Product(h.derivative(), g));
	}

	@Override
	public String toString() {
		return g.toString() + " * " + h.toString();
	}

	public static void main(String[] args) {
		Print.print(new Product(new Constant(2.0), new Identity()));
	}

}
