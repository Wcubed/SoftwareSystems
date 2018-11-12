package ss.week1;

public class ThreeWayLight {
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
		
		public String toString() {
			switch (this) {
				case OFF:
					return "OFF";
				case LOW:
					return "LOW";
				case MEDIUM:
					return "MEDIUM";
				case HIGH:
					return "HIGH";
				default:
					return "UNKNOWN STATE";
			}
		}
	}
	
	private Setting setting;
	
	public ThreeWayLight() {
		setting = Setting.OFF;
	}
	
	public void switchSetting() {
		setting = setting.up();
	}
	
	public Setting getSetting() {
		return setting;
	}
}