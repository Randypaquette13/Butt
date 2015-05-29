package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ButtJoystick extends Joystick implements Deadbanding{

	public ButtJoystick(int port) {
		super(port);
	}

	boolean[] buttonValues = new boolean[ButtonType.kNumButton.value];
	
	
	
	public boolean justChanged(int button){
		boolean justChanged = false;
		
		if (buttonValues[button] != getRawButton(button)){
			justChanged = true;
		}
		
		
		buttonValues[button] = getRawButton(button);
		
		return justChanged;
	}
	
	
	public boolean justPressed(int button){
		boolean justPressed = false;
		
		if ((buttonValues[button] != getRawButton(button)) && getRawButton(button) == true){
			justPressed = true;
		}
		
		buttonValues[button] = getRawButton(button);//store values
		
		return justPressed;
	}
	
	public boolean justReleased(int button){
		boolean justReleased = false;
		
		if ((buttonValues[button] != getRawButton(button)) && getRawButton(button) == false){
			justReleased = true;
		}
		
		buttonValues[button] = getRawButton(button);//store values
		
		return justReleased;
	}
	
	public boolean toggleButton(int button){
		boolean toggle = false;
		
		if ((buttonValues[button] != getRawButton(button)) && getRawButton(button) == false){
			toggle = !toggle;
		}
		
		buttonValues[button] = getRawButton(button);//store values
		
		return toggle;
	}


	
	public double deadband(double axis, double width) {
		
		double deadbandValue;
		
    	if (axis < width || axis > -width){
    		deadbandValue = 0;
    	}else{
    		deadbandValue = axis;
    	}
		
		return deadbandValue;
	}
	
	
}








