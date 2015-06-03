package org.usfirst.frc.team871.robot;

public class LowPassFilter implements Filter{

	double filterCoeficient = .02;
	double m_measuredBefore = 0;
	
	
	public LowPassFilter(double filterCoeficient) {
		this.filterCoeficient = filterCoeficient;
	}
	
	
	
	
	@Override
	public void reset() {
		m_measuredBefore = 0;
		
	}

	@Override
	public double update(double input) {
		
		m_measuredBefore += (input - m_measuredBefore) * filterCoeficient;
		return m_measuredBefore;
	}
	
	
	public void setCoeficient(double filterCoeficient){
		this.filterCoeficient = filterCoeficient;

	}
	

}
