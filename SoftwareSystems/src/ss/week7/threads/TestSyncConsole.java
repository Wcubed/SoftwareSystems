package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	private ReentrantLock lock;
	
	public TestSyncConsole(ReentrantLock lock, String string) {
		super(string);
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			sum();
		} finally {
			lock.unlock();
		}
	}
	
	private synchronized void sum() {
		int num1 = SyncConsole.readInt(getName() + ": Enter number 1: ");
		int num2 = SyncConsole.readInt(getName() + ": Enter number 2: ");
		
		SyncConsole.println(
				String.format("%s: %d + %d = %d", 
						getName(), num1, num2, num1 + num2));
	}
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		TestSyncConsole sum1 = new TestSyncConsole(lock, "Thread A");
	    TestSyncConsole sum2 = new TestSyncConsole(lock, "Thread B");
	    
	    sum1.start();
	    sum2.start();
	}
}
