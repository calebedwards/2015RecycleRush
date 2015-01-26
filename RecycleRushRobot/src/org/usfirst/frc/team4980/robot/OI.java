package org.usfirst.frc.team4980.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4980.robot.commands.AnalProbe;
import org.usfirst.frc.team4980.robot.commands.Distance;
import org.usfirst.frc.team4980.robot.commands.ElevatorForward;
import org.usfirst.frc.team4980.robot.commands.ElevatorReverse;
import org.usfirst.frc.team4980.robot.commands.ExampleCommand;
import org.usfirst.frc.team4980.robot.commands.MiniSimForward;
import org.usfirst.frc.team4980.robot.commands.MiniSimReverse;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	
	
	public Joystick stick;
	public JoystickButton forwardElevatorButton;
	public JoystickButton reverseElevatorButton;
	public JoystickButton forwardMiniSimButton;
	public JoystickButton reverseMiniSimButton;
	public JoystickButton solenoidButton;
	public JoystickButton getRange;
	
	
	
	
    public OI()
    {
    	stick = new Joystick(0);
    	
    	forwardElevatorButton = new JoystickButton(stick, 1);
    	reverseElevatorButton = new JoystickButton(stick, 2);
    	forwardMiniSimButton = new JoystickButton(stick, 5);
    	reverseMiniSimButton = new JoystickButton(stick, 6);
    	getRange = new JoystickButton(stick, 3);
    	solenoidButton = new JoystickButton(stick, 8);
    	
    	forwardElevatorButton.whileHeld(new ElevatorForward());
    	reverseElevatorButton.whileHeld(new ElevatorReverse());
    	forwardMiniSimButton.whileHeld(new MiniSimForward());
    	reverseMiniSimButton.whileHeld(new MiniSimReverse());
    	getRange.whenReleased(new Distance());
    	solenoidButton.whileHeld(new AnalProbe());
    	
    	SmartDashboard.putNumber("stick", stick.getAxisCount());
    	SmartDashboard.putData("EForward", new ElevatorForward());
    	SmartDashboard.putData("EReverse", new ElevatorReverse());
    }
    
    
    public Joystick getJoystick1()
    {
    	return stick;
    }
}

