package org.usfirst.frc.team4980.robot.subsystems;

import org.usfirst.frc.team4980.robot.Robot;
import org.usfirst.frc.team4980.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem 
{
    
	SpeedController elevatorSpeed = RobotMap.elevatorSpeed;
	double speed = 0;
    public void ElevatorFoward()
    {
    	speed = (Robot.oi.stick.getRawAxis(3)-1)*-.5;
    	elevatorSpeed.set(speed);
    }
    public void ElevatorReverse()
    {
    	speed = (Robot.oi.stick.getRawAxis(3)-1)*-.5;
    	elevatorSpeed.set(-speed);
    }
    public void initDefaultCommand() 
    {
        elevatorSpeed.set(0);
    }
}

