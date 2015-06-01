package org.usfirst.frc.team871.robot;

public class HighPassFilter implements Filter{

	
	double m_highPassOutput = 0;
	double m_output         = 0;
	
	
	@Override
	public void reset() {
		
		m_highPassOutput = 0;
		m_output         = 0;
		
	}

	@Override
	public double update(double input) {
		
		m_highPassOutput += input - (m_output + ((input - m_output) * 0.98));
		
		m_output = m_highPassOutput;
		
		return m_highPassOutput;
	}

}
