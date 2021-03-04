// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoMove extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private double start_dist_meters;
  private double target_distance;
  /** Creates a new AutoMove. */

  public AutoMove(final DriveSubsystem subsystem, Mode mode, double distance_in_meters, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSubsystem = subsystem;
    addRequirements(driveSubsystem);
    start_dist_meters = driveSubsystem.distanceTravelledInMeters();
    target_distance = distance_in_meters;
  }

  public AutoMove(final DriveSubsystem subsystem, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveSubsystem = subsystem;
    addRequirements(driveSubsystem);
    start_dist_meters = driveSubsystem.distanceTravelledInMeters();
    target_distance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.resetEncoders();
    driveSubsystem.ZeroYaw();
    start_dist_meters = driveSubsystem.distanceTravelledInMeters();
    driveSubsystem.state_flag_motion_profile = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.drive(target_distance, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double distance_driven = driveSubsystem.distanceTravelledInMeters() - start_dist_meters;
    double positionError = Math.abs(target_distance = distance_driven);
    return(positionError < 0.01);
  }

  public enum Mode {
    DISTANCE, TIME
  }
}