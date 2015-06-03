package org.usfirst.frc.team871.robot;

public class Average implements Filter{

	double lastNum = 0;
	
	int arraySize = 2; //default size
	
	
	double [] averageArray = new double[arraySize];

	public Average(int arraySize){
		this.arraySize = arraySize;
	}
	
	
	
	\
	
	@Override
	public void reset() {
		averageArray = new double[0];		
	}

	@Override
	public double update(double input) {
		double total = 0;
		int i = 0;
		
		averageArray[i] = input;
		i ++;
		
		for(int j = 0; j < averageArray.length; j++){
			
			total += averageArray[j];
		}
		
		
		double output = total / averageArray.length;
		
		
		return output;
		
	}
	
	
	
	public void setSize(int arraySize){
		this.arraySize = arraySize;
	}
	

}






