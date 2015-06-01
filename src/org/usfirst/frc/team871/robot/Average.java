package org.usfirst.frc.team871.robot;

public class Average implements Filter{

	double lastNum = 0;

	
	
	@Override
	public void reset() {
		lastNum = 0;		
	}

	@Override
	public double update(double input) {
		
		double output = (input + lastNum) / 2;
		input = lastNum;
		
		return output;
		
	}
	
	

}
