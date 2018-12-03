package ss.week3.math;

public interface Integrable {
	public <T extends Function & Integrable> T integral();
}
