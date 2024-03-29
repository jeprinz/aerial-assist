/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.pickup.PickUpDeploy;
import edu.wpi.first.wpilibj.templates.util.RollingAverager;

/**
 *
 * @author robotics
 */
public class PickUp extends Subsystem {
    
    public static final boolean DEPLOY = true;
    public static final boolean RETRACT = false;
    public static final boolean OPEN = true;
    public static final boolean CLOSE = false;
    
    private Solenoid shooterSolenoid1 = new Solenoid(1, RobotMap.pickUpSolenoid1);
    private Solenoid shooterSolenoid2 = new Solenoid(1, RobotMap.pickUpSolenoid2);
    
    private Solenoid wingSolenoid = new Solenoid(1, RobotMap.wingSolenoidChannel);
    
    private SpeedController upperPickUp = new Talon(RobotMap.upperPickUpRoller);
    
    private double powerLevel;
    
    private RollingAverager pickUpAverager = new RollingAverager(20, 0);
    
    public void initDefaultCommand() {
        setDefaultCommand(new PickUpDeploy(RETRACT, 0));
    }
    
    public void setRollerSpeed(double power) {
        powerLevel = power;
        pickUpAverager.addValue(powerLevel);
        upperPickUp.set(pickUpAverager.getAverage());
    }
    
    public void deployArm(boolean deploy) {
       shooterSolenoid1.set(!deploy);
       shooterSolenoid2.set(deploy);
    }
    public void deployCatch(boolean deploy) {
        wingSolenoid.set(deploy);
    }
}
