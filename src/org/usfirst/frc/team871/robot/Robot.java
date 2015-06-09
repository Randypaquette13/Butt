
package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, asI DESERVE A SNACK BREAK described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	ButtJoystick buttJoy        = new ButtJoystick(0);
	AnalogPotentiometer buttPot = new AnalogPotentiometer(0);
	ButtPid buttPid             = new ButtPid(0.3, 0.0, 0.0, 0.5);
	TalonSRX pendulum           = new TalonSRX(0);
	RobotDrive buttDrive        = new RobotDrive(1, 2);
	Compressor buttComp         = new Compressor();
	Solenoid buttPunchy         = new Solenoid(0);
	Deadband leftDriveDead      = new Deadband(0.15);
	Deadband rightDriveDead     = new Deadband(0.15);
	
	
	
	double tBefore = 0;
	
	
    public void robotInit() {
    	buttComp.start();


    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	
    	
    	
    	/**
    	 * Axis indexes:
			0 - LeftX
			1 - LeftY
			2 - Triggers (Each trigger = 0 to 1, axis value = right - left)
			3 - RightX
			4 - RightY
			5 - DPad Left/Right
				
			
		 * Buttons
		 	
			A Button - 1
			B Button - 2
			X Button - 3
			Y Button - 4
			L Button - 5
			R Button - 6
			Back     - 7
			Start    - 8
    	 */
    	
    	
    	    	

    	double tAfter  = 0;
    	double tSlept  = 0;
    	
       /* 
    	if(buttJoy.justPressed(2)){//should be x button
    		buttPid.setSetpoint(buttPid.getSetpoint() + .01);
    	}
    	else if(buttJoy.justPressed(1)){//should be b button
    		buttPid.setSetpoint(buttPid.getSetpoint() - .01);
    	}
    	*/
    	
    	buttPunchy.set(buttJoy.getRawButton(0));
    	
    	
    	//deadbanding
    	//ahh the finer things in life
    	
    	double leftStickY  = leftDriveDead.update(buttJoy.getRawAxis(1));
    	double rightStickY = rightDriveDead.update(buttJoy.getRawAxis(5));
    	
    	
    	buttDrive.tankDrive(leftStickY, rightStickY);
    	
    	
    	//pid stuffs

    	
    	tAfter = System.currentTimeMillis();
    		
    	tSlept = tBefore - tAfter;
    	
    	pendulum.set(buttPid.updatePid(buttPot.get(), tSlept));
    		
    	tBefore = System.currentTimeMillis();

    		
    	
    	
    	
    	
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
