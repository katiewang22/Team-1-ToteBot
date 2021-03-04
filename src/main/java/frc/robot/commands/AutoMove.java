// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoMove extends CommandBase {
  private final DriveSubsystem driveSubsystem; // Create an instance of the Drive Subsystem
  private double START_DIST_METERS; // Distance travelled at start of match
  private double TARGET_DISTANCE; // Target distance to travel during match

  // Constructor initializes DriveSubsystem and distance in meters
  public AutoMove(DriveSubsystem subsystem, double DISTANCE_IN_METERS) {
    driveSubsystem = subsystem;
    addRequirements(driveSubsystem);
    START_DIST_METERS = driveSubsystem.distanceTravelledInMeters();
    TARGET_DISTANCE = DISTANCE_IN_METERS;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.resetEncoders(); // Resets encoders
    driveSubsystem.ZeroYaw(); // Sets Yaw to 0
    START_DIST_METERS = driveSubsystem.distanceTravelledInMeters(); // Sets starting distance to distance travelled
    driveSubsystem.state_flag_motion_profile = true; // starts motion profiling
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.drive(TARGET_DISTANCE, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Checks how accurately we moved by getting the difference between distance driven and target distance
    double distanceDriven = driveSubsystem.distanceTravelledInMeters() - START_DIST_METERS;
    double positionError = Math.abs(TARGET_DISTANCE - distanceDriven);

    return(positionError < 0.01);
  }
}