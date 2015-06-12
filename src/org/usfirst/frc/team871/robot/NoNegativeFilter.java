package org.usfirst.frc.team871.robot;

public class NoNegativeFilter implements Filter{

	@Override
	public void reset() {

		
	}

	@Override
	public double update(double input) {
		double output;
		
		if(input < 0){
			output = 0;
		}else{
			output = input;
		}
		return output;
	}

}
