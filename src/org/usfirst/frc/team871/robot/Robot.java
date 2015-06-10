
package org.usfirst.frc.team871.robot;

import org.usfirst.frc.team871.robot.ButtJoystick.Axes;
import org.usfirst.frc.team871.robot.ButtJoystick.Buttons;

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
	AnalogPotentiometer buttPot = new AnalogPotentiometer(3);
	ButtPid buttPid             = new ButtPid(0.3, 0.0, 0.0, 0.5);
	TalonSRX pendulum           = new TalonSRX(4);
	RobotDrive buttDrive        = new RobotDrive(0, 1);
	Compressor buttComp         = new Compressor(1);
	Solenoid buttPunchy         = new Solenoid(0);

	
	
	
	double tBefore = 0;
	
	
    public void robotInit() {
    	
    	buttComp.start();
    	buttJoy.addFilter(new Deadband(.15), Axes.LEFTy);

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
			2 - Left Trigger
			3 - Right Trigger
			4 - RightX
			5 - RightY
				
			
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
    	if(buttJoy.justPressed(3)){//should be x button
    		buttPid.setSetpoint(buttPid.getSetpoint() + .01);
    	}
    	else if(buttJoy.justPressed(2)){//should be b button
    		buttPid.setSetpoint(buttPid.getSetpoint() - .01);
    	}
    	*/
    	
    	
    	
    	if (buttJoy.justPressed(Buttons.A)){
    		buttPunchy.set(!buttPunchy.get());
    	}
    	
    	
    	//deadbanding
    	//ahh the finer things in life
    	
    	double leftStickY  = buttJoy.getFilteredAxisValue(Axes.LEFTy);
    	double rightStickY = buttJoy.getFilteredAxisValue(Axes.RIGHTy);
    	
    	
    	buttDrive.tankDrive(-leftStickY, -rightStickY);
    	
    	
    	//pid stuffs

    	
    	tAfter = System.currentTimeMillis();
    		
    	tSlept = tBefore - tAfter;
    	
    	//pendulum.set(buttPid.updatePid(buttPot.get(), tSlept));
    		
    	tBefore = System.currentTimeMillis();

    		
    	
    	
    	
    	
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
