package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class ButtJoystick extends Joystick{
	
	double m_measuredBefore = 0;
	double m_highPassOutput = 0;
	double m_output         = 0;
	

	public ButtJoystick(int port) {
		super(port);
	}

	boolean[] buttonValues = new boolean[ButtonType.kNumButton.value];
	int[] axisValues       = new int[AxisType.kNumAxis.value];
	
	
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
	
	
}








