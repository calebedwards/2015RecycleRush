
package org.usfirst.frc.team4980.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4980.robot.commands.Auto;
import org.usfirst.frc.team4980.robot.commands.Drive;
import org.usfirst.frc.team4980.robot.commands.ExampleCommand;
import org.usfirst.frc.team4980.robot.commands.OtherAuto;
import org.usfirst.frc.team4980.robot.commands.ServoUp;
import org.usfirst.frc.team4980.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4980.robot.subsystems.Elevator;
import org.usfirst.frc.team4980.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand, drive;
	SendableChooser autoChooser;
	public static OI oi;
	
	public static  ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain = new DriveTrain();
	public static Elevator elevator;
	

    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	RobotMap.init();
    	elevator = new Elevator();
		oi = new OI();
        // instantiate the command used for the autonomous period
        drive = new Drive();
        autoChooser = new SendableChooser();
        autoChooser.addDefault("DefaultAuto", new Auto());
        autoChooser.addObject("OtherAuto", new OtherAuto());
        SmartDashboard.putData("Chooser", autoChooser);
        RobotMap.gyro.reset();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
     //   if (autonomousCommand != null) autonomousCommand.start();
    	autonomousCommand = (Command) autoChooser.getSelected();
    	autonomousCommand.start();   
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
       // RobotMap.elevatorSpeed.set(.1);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.start();
       // SmartDashboard.putData((NamedSendable) RobotMap.camera);
        if(Robot.oi.stick.getPOV()==180)//down
    	{
    		RobotMap.YAxis.setAngle(50);
    	}
        if(Robot.oi.stick.getPOV()==0)//up
    	{
    		RobotMap.XAxis.setAngle(90);
    	}
        if(Robot.oi.stick.getPOV()==270)//left
    	{
    		RobotMap.XAxis.setAngle(0);
    	}
        if(Robot.oi.stick.getPOV()==90)//right
    	{
    		RobotMap.XAxis.setAngle(180);
    	}
        
        
        
        
        SmartDashboard.putNumber("Axis", Robot.oi.stick.getPOV());
        SmartDashboard.putNumber("Gyro", RobotMap.gyro.getAngle());
        
    }	
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
