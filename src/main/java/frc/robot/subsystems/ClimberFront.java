/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ClimberReset;

/**
 * Add your docs here.
 */
public class ClimberFront extends Subsystem {

  Solenoid front = new Solenoid(RobotMap.climberfrontSolenoid);

  public void frontUp() {
    front.set(true);
    SmartDashboard.putBoolean("Climber Front", true);
  }

  public void frontDown() {
    front.set(false);
    SmartDashboard.putBoolean("Climber Front", false);
  }
  
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimberReset());
  }
}
