/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class LimelightFollow extends Command {
  double lastError = 0;
  double error_sum = 0;

  double maxOutput = 0;

  public LimelightFollow() {
    requires(Robot.kopchassis);
    requires(Robot.limelight);  

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limelight.lightOn();
    Robot.limelight.initializePID();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   Robot.limelight.limelightDrive();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.limelight.lightOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
