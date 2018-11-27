package ss.week3.math;

public class LinearProduct extends Product implements Integrable {

	public LinearProduct(Constant g, Function h) {
		super(g, h);
	}
	
	@Override
	public Function derivative() {
		return new LinearProduct((Constant) g, h.derivative());
	}
	
	@Override
	public Integrable integral() {
		Integrable result = null;
		if (h instanceof Integrable) {
			result = new LinearProduct((Constant) g, (Function) ((Integrable) h).integral());
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		Print.print(new LinearProduct(new Constant(6.3), new Exponent(4)));
	}

}
