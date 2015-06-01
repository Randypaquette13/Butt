package org.usfirst.frc.team871.robot;

public class Deadband implements Filter{

	double m_width = .15;//width default
	
	
	
	@Override
	public void reset() {//frees the input
		m_width = 1;
		
	}

	@Override
	public double update(double input) {

		double deadbandValue;
		
    	if (input < m_width || input > -m_width){
    		deadbandValue = 0;
    	}else{
    		deadbandValue = input;
    	}
		
		return deadbandValue;
	}
	
	
	public void setWidth(double width){
		m_width = width;
	}
	
	
	

}
