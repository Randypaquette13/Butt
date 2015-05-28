
package org.usfirst.frc.team871.robot;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
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
	
	
    public void robotInit() {


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
    	double tBefore = 0;
    	double tAfter  = 0;
    	double tSlept  = 0;
    	
        
    	if(buttJoy.justPressed(0)){
    		buttPid.setSetpoint(buttPid.getSetpoint() + .01);
    	}
    	else if(buttJoy.justPressed(1)){
    		buttPid.setSetpoint(buttPid.getSetpoint() - .01);
    	}
    	
    	
    	
    	
    	buttDrive.tankDrive(buttJoy.getRawAxis(1), buttJoy.getRawAxis(2));
    	
    	
    	//pid stuffs
    	
    	tBefore = System.currentTimeMillis();
    	
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	tAfter =System.currentTimeMillis();
    		
    	tSlept = tBefore - tAfter;
    	
    	pendulum.set(buttPid.updatePid(buttPot.get(), tSlept));
    		
    		
    		
    	
    	
    	
    	
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
