package org.usfirst.frc.team871.robot;

public class Deadband implements Filter{

	double width = .15;//width default
	
	
	
	public Deadband(double width){
		this.width = width;
	}
	
	
	
	@Override
	public void reset() {//frees the input
		width = 1;
		
	}

	@Override
	public double update(double input) {

		double deadbandValue;
		
    	if (input < width || input > -width){
    		deadbandValue = 0;
    	}else{
    		deadbandValue = input;
    	}
		
		return deadbandValue;
	}
	
	
	public void setWidth(double width){
		this.width = width;
	}
	
	
	

}
