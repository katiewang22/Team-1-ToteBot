// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

  public static NetworkTable limelightTable;

  public static double limelight_x;
  public static double limelight_y;

  public static int FORCE_OFF = 1;
  public static int FORCE_BLINK = 2;
  public static int FORCE_ON = 3;

  public static int VISION_PROCESSOR = 0;
  public static int DRIVER_CAMERA = 1;
  
  public Limelight() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
