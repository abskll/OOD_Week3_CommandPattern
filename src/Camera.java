
public class Camera {
	String location = "";
	public Camera(String location) {
		this.location = location;
	}
	public String on() {
		System.out.println(location + " Cam is on");
		return location + " Cam is on";
	}
	public String off() {
		System.out.println(location + " Cam is off");
		return location + " Cam is off";
	}
}
