// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
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

  // Runs at execution of the robot
  public static void init_Limelight() {
    // Limelight vision and data
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = limelightTable.getEntry("tx");
    NetworkTableEntry ty = limelightTable.getEntry("ty");

    limelight_x = (double) tx.getDouble(0.0);
    limelight_y = (double) ty.getDouble(0.0);

    // 1: force off 2: force blink 3: force on
    limelightTable.getEntry("ledMode").setNumber(FORCE_ON);
    // 0: Vision processor 1: Driver camera
    limelightTable.getEntry("camMode").setNumber(VISION_PROCESSOR);
  }

  // Called in periodic thread to constantly refresh data
  public static void getLimelightData() {
    limelight_x = (Double) limelightTable.getEntry("tx").getDouble(0.0);
    limelight_y = (Double) limelightTable.getEntry("ty").getDouble(0.0);
  }

  // Call to turn limelight ON
  public static void turn_LED_ON() {
    limelightTable.getEntry("ledMode").setNumber(FORCE_ON);
  }

  // Call to turn limelight OFF 
  public static void turn_LED_OFF() {
    limelightTable.getEntry("ledMode").setNumber(FORCE_OFF);
  }

  // Call to get limelight to BLINK
  public static void turn_LED_FLASH_BLINK() {
    limelightTable.getEntry("ledMode").setNumber(FORCE_BLINK);
  }

  // Sets the limelight to regular driver camera mode
  public static void setDriverCamera() {
    limelightTable.getEntry("camMode").setNumber(DRIVER_CAMERA);
    turn_LED_OFF();
    Robot.flashlight.flashlightOn();
  }

  // Sets the limelight to vision processor mode
  public static void setVisionProcessor() {
    limelightTable.getEntry("camMode").setNumber(VISION_PROCESSOR);
    turn_LED_ON();
    Robot.flashlight.flashlightOff();
  }

  static NetworkTable getTable() {
    return NetworkTableInstance.getDefault().getTable("limelight");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
