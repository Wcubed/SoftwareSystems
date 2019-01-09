package ss.week7.account;

public class Account {
	protected double balance = 0.0;

	public synchronized void transaction(double amount) {
		while (balance + amount < -1000) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		balance = balance + amount;
		System.out.println(balance);
		this.notifyAll();
	}
	public double getBalance() {
		return balance;

	}
}
