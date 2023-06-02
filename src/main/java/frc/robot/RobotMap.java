/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static int frDrive = 5;
  public static int flDrive = 7;
  public static int brDrive = 6;
  public static int blDrive = 8;
 
  public static int cargoarmTalon1 = 1;
  //public static int cargoarmTalon2 = 2; only one talon is being used for cargo arm 

  public static int cargomechTalon1 = 3;  
  public static int cargomechTalon2 = 4;

  public static double cargoGrabberCurrentLimit = 7.0;

  public static double cargoPark = 102.0;
  public static double cargoLevel1 = 75; //TODO: still needs to be calculated
  public static double cargoLevel2 = 49.1446;
  public static double cargoLevel3  = 60.107;
  public static double cargoArmIntake = 0.0;  //TODO: do we need a special angle for intake?
  public static double cargoArmAngleTolerance = 1.5; //TODO: adjust after some real world testing; acceptable tolerance of arm position +/- degrees

  public static int hatchPusherSolenoid = 1;
  public static int hatchFingerSolenoid = 3;

  public static int cargoBrakeSolenoid = 7;

  public static int climberfrontSolenoid = 2;
  public static int climberbackSolenoid = 4; //still needs to be decided
}
