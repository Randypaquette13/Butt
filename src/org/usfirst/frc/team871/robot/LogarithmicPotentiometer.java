package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class LogarithmicPotentiometer extends AnalogPotentiometer{
	
	double m_scale;
	double m_curvature;

	public LogarithmicPotentiometer(int input, double scale, double curvature) {
		super(input);
		
		m_scale = scale;
		m_curvature = curvature;
	}

	@Override
	public double get(){
		double output = (Math.log((super.get()/m_scale) + 1))/m_curvature;
		return output;
	}
	
	public double getRaw(){
		return super.get();
	}
	
}
