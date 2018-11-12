package ss.week1;

public class ThreeWayLightTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeWayLight light = new ThreeWayLight();
		
		System.out.print("Initial state: ");
		System.out.println(light.getSetting().toString());
		
		System.out.print("One switch: ");
		light.switchSetting();
		System.out.println(light.getSetting().toString());
		
		System.out.print("Two switches: ");
		light.switchSetting();
		System.out.println(light.getSetting().toString());
		
		System.out.print("Three switches: ");
		light.switchSetting();
		System.out.println(light.getSetting().toString());
		
		System.out.print("Four switches: ");
		light.switchSetting();
		System.out.println(light.getSetting().toString());
		
		System.out.print("Five switches: ");
		light.switchSetting();
		System.out.println(light.getSetting().toString());
	}

}
