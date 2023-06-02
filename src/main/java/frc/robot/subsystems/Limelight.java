/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  double lastError = 0;
  double error_sum = 0;
  double kP = 0.021;
  double kI = 0.0;
  double kD = 0.15;

public void initializePID(){
  error_sum = 0;
    kP = Robot.preferences.getDouble("Limelight.kP", 0.0);
    kI = Robot.preferences.getDouble("Limelight.kI", 0.0);
    kD = Robot.preferences.getDouble("Limelight.kD", 0.0);
}

public void lightOn(){
  table.getEntry("ledMode").setNumber(3);
}

public void lightOff(){
  table.getEntry("ledMode").setNumber(0);

}

public void limelightDrive(){
    
  NetworkTableEntry tx = table.getEntry("tx");
  double x = tx.getDouble(0);

  error_sum += x;

  double P = kP * x;
  double I = kI * error_sum;
  double D = kD * (lastError - x);

  lastError = x;

  double output = P + I - D;

  SmartDashboard.putNumber("output", output);
  SmartDashboard.putNumber("error", lastError);

  Robot.kopchassis.limelightDrive(Robot.m_oi.driver, output);
}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
