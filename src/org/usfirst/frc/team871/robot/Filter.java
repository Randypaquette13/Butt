package org.usfirst.frc.team871.robot;

public interface Filter {
	
	
	
	
	public double deadband(int axis, double width);
		
	public double average(int axis1, int axis2);
	
	public double lowPassFilter(double measurement, double filterCoeficient);
	
	public double highPassFilter(double measurement, double filterCoeficient);
	

}
