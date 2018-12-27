package ss.week7.bounce;

public class AnimateThread extends Thread {
	
	private BallPanel panel;

	public AnimateThread(BallPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		panel.animate();
	}
}
