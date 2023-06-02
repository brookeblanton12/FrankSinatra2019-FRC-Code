/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick driver = new Joystick(ControllerMap.DRIVER_PORT);
  public Joystick operator = new Joystick(ControllerMap.OPERATOR_PORT);

  public OI() {
    initDriverControls(driver);
    initOperatorControls(operator);
  }

  private void initDriverControls(Joystick joystick) {
      Button CameraSwitch = new JoystickButton(joystick, ControllerMap.BUMPER_LEFT);
      CameraSwitch.whenPressed(new SwitchCamera());

      Button LimelightFollow = new JoystickButton(joystick, ControllerMap.A);
      LimelightFollow.whileHeld(new LimelightFollow());
  }

  private void initOperatorControls(Joystick joystick) {
      Button HatchRetrieve = new JoystickButton(joystick, ControllerMap.B);
      Button HatchScore = new JoystickButton(joystick, ControllerMap.X);
      HatchRetrieve.whileHeld(new HatchRetrieve());
      HatchRetrieve.whenReleased(new RumbleDriver(0.5));
      HatchScore.whileHeld(new HatchScore());

      //Gerard and Iago are taking a long nap :(          
      // Button CargoUp = new JoystickButton(joystick, ControllerMap.BUMPER_LEFT);
      // Button CargoDown = new JoystickButton(joystick, ControllerMap.BUMPER_RIGHT);
      // Button CargoLevel1 = new JoystickButton(joystick, ControllerMap.Y);
      // CargoUp.whileHeld(new CargoUp());
      // CargoDown.whileHeld(new CargoDown());
      // CargoLevel1.whenPressed(new CargoArmLevel1AndRumble());

      Button CargoIntake = new JoystickButton(joystick, ControllerMap.LOGO_LEFT);
      Button CargoDeliver = new JoystickButton(joystick, ControllerMap.LOGO_RIGHT);
      CargoIntake.whenPressed(new CargoIntakeAndRumble());
      CargoDeliver.whileHeld(new CargoDeliver());

      Button FrontUp = new JoystickButton(joystick, ControllerMap.BUMPER_LEFT);
      Button BackUp = new JoystickButton(joystick, ControllerMap.BUMPER_RIGHT);
      FrontUp.whileHeld(new ClimberFrontUp());
      FrontUp.whenReleased(new ClimberFrontDown());
      BackUp.whileHeld(new ClimberBackUp());
      BackUp.whenReleased(new ClimberBackDown());
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
