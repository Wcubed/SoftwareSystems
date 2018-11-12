package ss.week1;

public class ThreeWayLight1 {
	public enum Setting {
		OFF, LOW, MEDIUM, HIGH;
		
		public Setting up() {
			switch (this) {
				case OFF:
					return LOW;
				case LOW:
					return MEDIUM;
				case MEDIUM:
					return HIGH;
				case HIGH:
					return OFF;
				default:
					return OFF;
			}
		}
	}
	
	private Setting setting = Setting.OFF;
	
	public void switchSetting() {
		setting = setting.up();
	}
	
	public Setting getSetting() {
		return setting;
	}
}