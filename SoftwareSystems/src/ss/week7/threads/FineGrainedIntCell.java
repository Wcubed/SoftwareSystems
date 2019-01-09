package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FineGrainedIntCell implements IntCell {
	private Lock lock = new ReentrantLock();
	private Condition readable = lock.newCondition();
	private Condition writable = lock.newCondition();
	
	private boolean valueIsFresh = false;
	private int value = 0;

	public void setValue(int valueArg) {
		lock.lock();
		try {
			while (valueIsFresh) {
				writable.await();
			}
			
			valueIsFresh = true;
			this.value = valueArg;
			
			readable.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int getValue() {
		int result = 0;
		
		lock.lock();
		try {
			while (!valueIsFresh) {
				readable.await();
			}
			
			result = this.value;
			valueIsFresh = false;
			
			writable.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
		return result;
	}
}
