package org.usfirst.frc.team871.robot;

public class SmoothDeadband implements Filter{
	
	double width = .15; //width default
	
	
	public SmoothDeadband(double width) {
		this.width = width;
	}
	
	

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double update(double input) {
		double output;
		
		if(input >= width){
			output = (1/(1 - width)) * (input - width);
			
		}else if(input <= -width){
			output = (1/(1 - width)) * (input + width);
			
		}else{
			output = 0;
		}
		
		return output;
	}
	
	public void setWidth(double width){
		this.width = width;
	}

}
