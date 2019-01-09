package ss.week7.account;

public class MyThread extends Thread {
	double amount;
	int times;
	Account account;
	
	public MyThread(double amount, int times, Account account) {
		this.amount = amount;
		this.times = times;
		this.account = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.transaction(amount);
		}
	}
}
