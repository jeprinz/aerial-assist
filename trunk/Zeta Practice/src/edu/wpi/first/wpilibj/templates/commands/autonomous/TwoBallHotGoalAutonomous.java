/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveStraightCommand;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.ShiftCommand;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.TurnCommand;
import edu.wpi.first.wpilibj.templates.commands.pickup.PickUpDeploy;
import edu.wpi.first.wpilibj.templates.commands.shooter.ShootSeries;
import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.subsystems.PickUp;
import edu.wpi.first.wpilibj.templates.util.SelectableCommand;

/**
 *
 * @author robotics
 */
public class TwoBallHotGoalAutonomous extends SelectableCommand {
    
    public TwoBallHotGoalAutonomous() {
       HotGoalProcessing hotGoal = new HotGoalProcessing();
       addSequential(new ShiftCommand(Drivetrain.LOW_GEAR));
       addParallel(new PickUpDeploy(PickUp.DEPLOY, 0.3, PickUp.CLOSE));
       addSequential(new WaitCommand(0.5));
       addSequential(new DriveStraightCommand(0.55, 1500));
       addParallel(new PickUpDeploy(PickUp.DEPLOY, 0, PickUp.CLOSE));
       addSequential(hotGoal, 1);
       addSequential(new TurnCommand(hotGoal, 0.55, 250));
       addSequential(new ShootSeries());
       addParallel(new PickUpDeploy(PickUp.DEPLOY, RobotMap.intakeRollerSpeed, PickUp.CLOSE));
       addSequential(new TurnCommand(hotGoal, -0.55, -500));
       addSequential(new ShootSeries());
    }

    public String getCommandName() {
        return "Two Ball Hot Goal";
    }
}