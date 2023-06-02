/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.HttpCamera;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSink;
import edu.wpi.cscore.VideoSource;
import edu.wpi.cscore.HttpCamera.HttpCameraKind;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Camera system to allow toggling between a front-facing camera and a back-facing camera
 */
public class Camera extends Subsystem {
  UsbCamera frontCamera;
  UsbCamera backCamera;
  VideoSink videoSink;

  public Camera() {
    //NOTE: There is a bug in CameraServer where cameras constructed before the first getInstance() call aren't published,
    //      so it's VERY IMPORTANT to call getInstance() prior to constructing the first camera
    //      https://www.chiefdelphi.com/t/stream-from-jetson-to-rio/343525/2
    CameraServer cs = CameraServer.getInstance();

    try {
      //frontCamera = new HttpCamera("frontCamera", "http://10.31.3.12/mjpg/video.mjpg", HttpCameraKind.kMJPGStreamer);
      frontCamera = cs.startAutomaticCapture("frontCamera", 0);
      frontCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    } catch (Exception ex) {
    }

    try {
      backCamera = cs.startAutomaticCapture("backCamera", 1);
      backCamera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);
    } catch (Exception ex) {
    }

    videoSink = cs.addSwitchedCamera("Switched camera");

    // If we want to override the video mode of a USB camera, it must be done after the addSwitchedCamera call, which defaults to 160x120 @ 30 fps
    frontCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 240, 30);
    backCamera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 176, 144, 30);

    videoSink.setSource(frontCamera); // ensure we show the front camera when we start

    videoSink.getProperty("compression").set(70);
  }

  public void toggle() {
    Robot.toggleDirection = !Robot.toggleDirection;
    if(Robot.toggleDirection) {
      videoSink.setSource(backCamera);
      SmartDashboard.putString("Camera", "BACK");
    }
    else {
      videoSink.setSource(frontCamera);
      SmartDashboard.putString("Camera", "FRONT");
    }
  }

  @Override
  public void initDefaultCommand() {
    // no default command
  }
}
