package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class ButtJoystick extends Joystick implements Filter{
	
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


	
	public double deadband(int axis, double width) {
		double axisVal = axisValues[axis];
		
		double deadbandValue;
		
    	if (axisVal < width || axisVal > -width){
    		deadbandValue = 0;
    	}else{
    		deadbandValue = axisVal;
    	}
		
		return deadbandValue;
	}


	
	public double average(int axis1, int axis2) {
		double axisVal1 = axisValues[axis1];
		double axisVal2 = axisValues[axis2];
		
		
		return (axisVal1 + axisVal2 ) / 2;
	}


	
	public double lowPassFilter(double measurement, double filterCoeficient) {
		
		m_measuredBefore += (measurement - m_measuredBefore) * filterCoeficient;
		return m_measuredBefore;
		

		
	}
	
	public double highPassFilter(double measurement, double filterCoeficient){
		
		m_highPassOutput += measurement - (m_output + ((measurement - m_output) * filterCoeficient));
		
		m_output = m_highPassOutput;
		
		return m_highPassOutput;
		
		
	}
	
	
}








