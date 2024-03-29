/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveStraightCommand;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.ShiftCommand;
import edu.wpi.first.wpilibj.templates.commands.lights.TurnLightsOnCommand;
import edu.wpi.first.wpilibj.templates.commands.pickup.PickUpDeploy;
import edu.wpi.first.wpilibj.templates.commands.shooter.ShootSeries;
import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.subsystems.PickUp;
import edu.wpi.first.wpilibj.templates.util.SelectableCommand;

/**
 *
 * @author robotics
 */
public class TwoBallAutonomousWithPickUp extends SelectableCommand {
    
    public TwoBallAutonomousWithPickUp() {
       //1000 ticks is approximately 28 inches
       addParallel(new TurnLightsOnCommand());
       addSequential(new ShiftCommand(Drivetrain.LOW_GEAR));
       addSequential(new DriveStraightCommand(0.90, 3500));
       addSequential(new ShootSeries());
       addParallel(new PickUpDeploy(PickUp.DEPLOY, RobotMap.intakeRollerSpeed));
       addSequential(new DriveStraightCommand(-0.90, -3850));
       addSequential(new WaitCommand(0.4));
       addParallel(new PickUpDeploy(PickUp.RETRACT, 0));
       addSequential(new DriveStraightCommand(0.90, 3850));
       addSequential(new ShootSeries());
       addParallel(new PickUpDeploy(PickUp.DEPLOY, RobotMap.intakeRollerSpeed));
       addSequential(new DriveStraightCommand(-0.90, -5600));
    }

    public String getCommandName() {
        return "Shoot two Ball, Pick Up One";
    }
}
