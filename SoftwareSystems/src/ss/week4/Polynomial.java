package ss.week4;

import ss.week3.math.Function;
import ss.week3.math.Integrable;
import ss.week3.math.LinearProduct;
import ss.week3.math.Exponent;
import ss.week3.math.Constant;

public class Polynomial implements Function, Integrable {

	LinearProduct[] components;

	public Polynomial(double[] arguments) {
		components = new LinearProduct[arguments.length];

		for (int i = 0; i < arguments.length; i++) {
			components[i] = new LinearProduct(new Constant(arguments[i]), new Exponent(i));
		}
	}

	private Polynomial(LinearProduct[] components) {
		this.components = components;
	}

	@Override
	public double apply(double argument) {
		double result = 0;
		for (LinearProduct component : components) {
			result += component.apply(argument);
		}
		return result;
	}

	@Override
	public Function derivative() {
		LinearProduct[] derComponents = new LinearProduct[components.length - 1];
		// a0 falls away, so start at i = 1;
		for (int i = 1; i < components.length; i++) {
			derComponents[i - 1] = (LinearProduct) components[i].derivative();
		}
		return new Polynomial(derComponents);
	}

	@Override
	public Integrable integral() {
		LinearProduct[] derComponents = new LinearProduct[components.length];
		for (int i = 0; i < components.length; i++) {
			derComponents[i] = (LinearProduct) components[i].integral();
		}
		return new Polynomial(derComponents);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
