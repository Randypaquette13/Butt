package org.usfirst.frc.team871.robot;

public class ButtPid {
	
	double kP;
	double kI;
	double kD;
	
	double setpoint = 0;
	double processVariable;
	double dt;
	double error;
	double totalError;
	double pastError = 0;

	
	public ButtPid(double kP, double kI, double kD, double setpoint){
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		
		this.setpoint = setpoint;
	}
	
	
	public void setSetpoint(double setpoint){
		this.setpoint = setpoint;
	}
	
	public double getSetpoint(){
		return setpoint;
	}
	
	
	public double updatePid(double processVariable, double dt){
		double output;
		
		error = processVariable - setpoint;
		totalError += error;
		
		
		output = (kP * error) + (kI * totalError) + (kD * (pastError - error) / dt);// error/sec
		
		pastError = error;
		return output;
		
	}

	
}
