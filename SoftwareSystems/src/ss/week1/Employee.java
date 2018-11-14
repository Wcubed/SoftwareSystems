package ss.week1;

public class Employee {
	private int hours;
	private double rate;

	public Employee(int hours, double rate) {
		this.hours = hours;
		this.rate = rate;
	}

	public double calculatePay() {
		if (hours < 40) {
			return hours * rate;
		} else {
			double basePay = 40 * rate;
			double overtime = (hours - 40) * rate * 1.5;
			return basePay + overtime;
		}
	}
}
