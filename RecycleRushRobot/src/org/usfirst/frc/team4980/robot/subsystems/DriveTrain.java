package org.usfirst.frc.team4980.robot.subsystems;

import org.usfirst.frc.team4980.robot.Robot;
import org.usfirst.frc.team4980.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	SpeedController rearRight = RobotMap.rearRight;
	SpeedController rearLeft = RobotMap.rearLeft;
	SpeedController frontRight = RobotMap.frontRight;
	SpeedController frontLeft = RobotMap.frontLeft;
	RobotDrive driveTrain = RobotMap.driveTrain;
	
	
	public void xbox()
	{
		double rightTrigger = Robot.oi.stick.getRawAxis(3);
		double leftTrigger = -1*(Robot.oi.stick.getRawAxis(2));
		double rightX = (Robot.oi.stick.getRawAxis(4));
		double rightY = (Robot.oi.stick.getRawAxis(5));
		double twist = rightTrigger+leftTrigger;
		RobotMap.driveTrain.mecanumDrive_Polar(-rightY, rightX, twist);
		//RobotMap.driveTrain.mecanumDrive_Polar(Robot.oi.stick.getMagnitude(), Robot.oi.stick.getDirectionDegrees(), twist);
	}
	public void logitech()
	{
		
		double magnitude = 0;
    	double twist = 0;
    	double Kg = .0000001;
    	double direction = Robot.oi.stick.getDirectionDegrees();
    	
    	//RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	//RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
    	
    	
    	double angle = RobotMap.gyro.getAngle(); // get current heading
      //  myRobot.drive(-1.0, -angle*Kg); // drive towards heading 0
    	
    	//driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	//driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
    	
    	if(Math.abs(Robot.oi.stick.getMagnitude())<.4)
    		magnitude = .5*(Robot.oi.stick.getMagnitude());
    	else if(Math.abs(Robot.oi.stick.getMagnitude())<.6 && Math.abs(Robot.oi.stick.getMagnitude())>=.4)
    		magnitude = (2*Robot.oi.stick.getMagnitude())-.6;
    	else
    		magnitude = Robot.oi.stick.getMagnitude();
    	
    	if(Math.abs(Robot.oi.stick.getTwist())>.25)
    	{
    		if(Robot.oi.stick.getTwist()>0)
    			twist=1.3333*Robot.oi.stick.getTwist()-.3333;
    		if(Robot.oi.stick.getTwist()<0)
    			twist=1.3333*Robot.oi.stick.getTwist()+.3333;
    	}
    	SmartDashboard.putNumber("Magnitude", magnitude);
    	
        SmartDashboard.putNumber("Twist", twist);
        
        
        int count = 0;
       /*
        while(direction<20 && direction>-20)
        {
        	//RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        	//RobotMap.driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        	if(count == 0)
        		RobotMap.gyro.reset();
        	direction = -angle*Kg;
        	RobotMap.driveTrain.mecanumDrive_Polar(magnitude, direction, twist);
        //	RobotMap.driveTrain.drive(magnitude, -direction);
        	count++;
        	if(Math.abs(Robot.oi.stick.getMagnitude())<.4)
        		magnitude = .5*(Robot.oi.stick.getMagnitude());
        	else if(Math.abs(Robot.oi.stick.getMagnitude())<.6 && Math.abs(Robot.oi.stick.getMagnitude())>=.4)
        		magnitude = (2*Robot.oi.stick.getMagnitude())-.6;
        	else
        		magnitude = Robot.oi.stick.getMagnitude();
        	direction = Robot.oi.stick.getDirectionDegrees();
        	Timer.delay(.004);
        	SmartDashboard.putNumber("Direction", direction);
        }
        */
        
        
        
    	RobotMap.driveTrain.mecanumDrive_Polar(magnitude, direction, twist);
		
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

