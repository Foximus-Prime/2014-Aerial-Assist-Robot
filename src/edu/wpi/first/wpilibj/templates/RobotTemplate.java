/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Gyro;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    
    private Jaguar frontRight;
    private Jaguar frontLeft;
    private Jaguar backRight;
    private Jaguar backLeft;
    
    private Gyro thingy;
    
    private Double speed;
    
    private SmartDashboard dash;
    
    private Joystick leftJoystick;
    private Joystick rightJoystick;
    
    private RobotDrive drive;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        frontRight = new Jaguar(3);
        frontLeft = new Jaguar(4);
        backRight = new Jaguar(1);
        backLeft = new Jaguar(2);
        
        speed = new Double(0.50);
        
        thingy = new Gyro(1);
        
        dash = new SmartDashboard();
        
        leftJoystick = new Joystick(1);
        rightJoystick = new Joystick(2);
        
        drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
     
        //Set to mecanum drive. Last digit is set to the gyro, which we dont have so default 0

        dash.putDouble("speed" , speed.doubleValue());
        dash.putDouble("Gyro", thingy.getAngle());
        
        if(leftJoystick.getRawButton(2))
            drive.mecanumDrive_Cartesian(0, leftJoystick.getY(), leftJoystick.getX(), 0);
        else
            drive.mecanumDrive_Cartesian(leftJoystick.getX(), leftJoystick.getY(), 0, 0);
        
        dash.putDouble("LeftFront", frontLeft.getSpeed());
        dash.putDouble("LeftBack", backLeft.getSpeed());
        dash.putDouble("RightFront", frontRight.getSpeed());
        dash.putDouble("RightBack", backRight.getSpeed());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    
    public void goRight(){
        
    }
}
