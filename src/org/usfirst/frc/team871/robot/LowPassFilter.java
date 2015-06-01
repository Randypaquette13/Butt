package org.usfirst.frc.team871.robot;

public class LowPassFilter implements Filter{

	
	double m_measuredBefore = 0;
	
	
	@Override
	public void reset() {
		m_measuredBefore = 0;
		
	}

	@Override
	public double update(double input) {
		
		m_measuredBefore += (input - m_measuredBefore) * .02;
		return m_measuredBefore;
	}

}
