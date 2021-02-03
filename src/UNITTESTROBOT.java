import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class UNITTESTROBOT {

	//private final PrintStream standardOut = System.out;
	//private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


	//public void setUp() {
	//    System.setOut(new PrintStream(outputStreamCaptor));
	//}
	//public void tearDown() {
	//	System.setOut(standardOut);
	//}
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	@Test
	public void test() throws IOException {
		RobotControl robotcontrol = new RobotControl();
		
		LEDS headLights = new LEDS("Headlights");
		LEDS underGlow = new LEDS("Underglow");
		
		Camera roofCamera= new Camera("Roof");
		Motors motors = new Motors();
		
		Command turnRight = () -> {
			motors.rightmotorsbackwards(); 
			motors.leftmotorsforwards();
		};
		Command turnLeft = () -> {
			motors.rightmotorsforwards(); 
			motors.leftmotorsbackwards();
		};
		Command goForwards = () -> {
			motors.rightmotorsforwards(); 
			motors.leftmotorsforwards();
		};
		Command goBackwards = () -> {
			motors.rightmotorsbackwards(); 
			motors.leftmotorsbackwards();
		};
		

		robotcontrol.setCommand(0, headLights::on, headLights::off);
		robotcontrol.setCommand(1, underGlow::on, underGlow::off);
		robotcontrol.setCommand(2, roofCamera::on, roofCamera::off);
		
		robotcontrol.setCommand(3, turnRight, turnLeft);
		robotcontrol.setCommand(4, goForwards, goBackwards);
  
		System.out.println(robotcontrol.toString());
		//Assert.assertEquals(robotcontrol,)
	    //Assert.assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString()
	    //	      .trim());
		
		outContent.reset();
		robotcontrol.activateButtonWasPushed(0);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Headlights LEDs are on");
		outContent.reset();
		robotcontrol.disableButtonWasPushed(0);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Headlights LEDs are off");	
		outContent.reset();
		robotcontrol.activateButtonWasPushed(1);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Underglow LEDs are on");
		outContent.reset();
		robotcontrol.disableButtonWasPushed(1);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Underglow LEDs are off");
		outContent.reset();
		robotcontrol.activateButtonWasPushed(2);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Roof Cam is on");
		outContent.reset();
		robotcontrol.disableButtonWasPushed(2);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Roof Cam is off");
		outContent.reset();
		robotcontrol.activateButtonWasPushed(3);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Right Motors are rotating backwards\r\n" + 
	    	      		"Left Motors are rotating forwards");
		outContent.reset();
		robotcontrol.disableButtonWasPushed(3);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Right Motors are rotating forwards\r\n" + 
	    	      		"Left Motors are rotating backwards");
		outContent.reset();
		robotcontrol.activateButtonWasPushed(4); 
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Right Motors are rotating forwards\r\n" + 
	    	      		"Left Motors are rotating forwards");
		outContent.reset();
		robotcontrol.disableButtonWasPushed(4);
		Assert.assertEquals(outContent.toString()
	    	      .trim(),"Right Motors are rotating backwards\r\n" + 
	    	      		"Left Motors are rotating backwards");

		
	}

}
