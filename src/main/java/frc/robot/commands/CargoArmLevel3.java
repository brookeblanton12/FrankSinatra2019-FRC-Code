/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class CargoArmLevel3 extends Command {
  public CargoArmLevel3() {
    requires(Robot.cargo);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargo.initializePID();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.cargo.setArmAngle(RobotMap.cargoLevel3);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.cargo.isArmAtPosition();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cargo.cargobrake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.cargo.cargobrake();
  }
}
