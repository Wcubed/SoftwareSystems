package ss.week2;

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
	
	//@ ensures getSetting() == Setting.OFF;
	public ThreeWayLight() {
		setting = Setting.OFF;
	}
	
	//@ ensures \old(getSetting()) == Setting.OFF ==> getSetting() == Setting.LOW;
	//@ ensures \old(getSetting()) == Setting.LOW ==> getSetting() == Setting.MEDIUM;
	//@ ensures \old(getSetting()) == Setting.MEDIUM ==> getSetting() == Setting.HIGH;
	//@ ensures \old(getSetting()) == Setting.HIGH ==> getSetting() == Setting.OFF;
	public void switchSetting() {
		setting = setting.up();
	}
	
	//@ pure
	public Setting getSetting() {
		return setting;
	}
}