
public class RobotRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotControl robotcontrol = new RobotControl();
		
		LEDS headLights = new LEDS("Headlights");
		LEDS underGlow = new LEDS("Underglow");
		
		Camera roofCamera= new Camera("Roof");
		Motors motors = new Motors();
		
		Command turnRight = () -> {
			motors.rightmotorsbackwards(); motors.leftmotorsforwards();
		};
		Command turnLeft = () -> {
			motors.rightmotorsforwards(); motors.leftmotorsbackwards();
		};
		Command goForwards = () -> {
			motors.rightmotorsforwards(); motors.leftmotorsforwards();
		};
		Command goBackwards = () -> {
			motors.rightmotorsbackwards(); motors.leftmotorsbackwards();
		};
		

		robotcontrol.setCommand(0, headLights::on, headLights::off);
		robotcontrol.setCommand(1, underGlow::on, underGlow::off);
		robotcontrol.setCommand(2, roofCamera::on, roofCamera::off);
		
		robotcontrol.setCommand(3, turnRight, turnLeft);
		robotcontrol.setCommand(4, goForwards, goBackwards);
  
		System.out.println(robotcontrol);
 
		robotcontrol.activateButtonWasPushed(0);
		robotcontrol.disableButtonWasPushed(0);
		robotcontrol.activateButtonWasPushed(1);
		robotcontrol.disableButtonWasPushed(1);
		robotcontrol.activateButtonWasPushed(2);
		robotcontrol.disableButtonWasPushed(2);
		robotcontrol.activateButtonWasPushed(3);
		robotcontrol.disableButtonWasPushed(3);
		robotcontrol.activateButtonWasPushed(4);  
		robotcontrol.disableButtonWasPushed(4);
		
		
	}

}
