package ss.week7.threads;

public class SyncIntCell implements IntCell {
	private boolean valueIsFresh = false;
	private int value = 0;

	public void setValue(int valueArg) {
		synchronized (this) {
			while (valueIsFresh) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			valueIsFresh = true;
			this.value = valueArg;
			this.notifyAll();
		}
	}

	public int getValue() {
		synchronized (this) {
			while (!valueIsFresh) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			this.valueIsFresh = false;
			this.notifyAll();
			return value;
		}
	}
}
