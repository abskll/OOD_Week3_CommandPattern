
public class LEDS {
	String location = "";
	public LEDS(String location) {
		this.location = location;
	}
	public String on() {
		System.out.println(location + " LEDs are on");
		return location + " LEDs are on";
	}
	public String off() {
		System.out.println(location + " LEDs are off");
		return location + " LEDs are off";
	}
}
