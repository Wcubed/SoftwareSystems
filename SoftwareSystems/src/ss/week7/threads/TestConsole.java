package ss.week7.threads;

public class TestConsole extends Thread {
	
	public TestConsole(String string) {
		super(string);
	}

	@Override
	public void run() {
		sum();
	}
	
	private void sum() {
		int num1 = Console.readInt(getName() + ": Enter number 1: ");
		int num2 = Console.readInt(getName() + ": Enter number 2: ");
		
		Console.println(
				String.format("%s: %d + %d = %d", 
						getName(), num1, num2, num1 + num2));
	}
	
	public static void main(String[] args) {
		TestConsole sum1 = new TestConsole("Thread A");
	    TestConsole sum2 = new TestConsole("Thread B");
	    
	    sum1.start();
	    sum2.start();
	}
}
