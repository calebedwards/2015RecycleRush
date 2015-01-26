package org.usfirst.frc.team4980.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    public static SpeedController elevatorSpeed, miniSim, rearLeft, rearRight, frontLeft, frontRight;
    public static RobotDrive driveTrain;
    public static Gyro gyro;
    public static Ultrasonic hedgehog;
    public static BuiltInAccelerometer accel;
    //public static Solenoid solenoid;
    public static Relay relay;
    public static Servo YAxis, XAxis;
    public static AxisCamera camera;
    
    public static void init()
    {
        camera= new AxisCamera("10.49.80.20");
    	elevatorSpeed = new Talon(4);
    	miniSim = new Talon(9);
    	rearRight = new Talon(0);
    	frontRight = new Talon(1);       
    	frontLeft = new Talon(2);
    	rearLeft = new Talon(3);
    	driveTrain = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    	//    driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
      	gyro = new Gyro(0); 
    	hedgehog = new Ultrasonic(9, 8);
    	YAxis = new Servo(5);
    	XAxis = new Servo(6);
    	//solenoid = new Solenoid(0);
    	
    	driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
    	driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
    	driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);//frontRight
    	driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);//rearRight
    	
    	driveTrain.setSafetyEnabled(true);
    	driveTrain.setExpiration(.1);  
    	driveTrain.setSensitivity(1);
    	driveTrain.setMaxOutput(1.0);
    	
    	
    }
}
