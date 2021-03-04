// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurn extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private double initial_heading;
  private double target_heading;

  public AutoTurn(final DriveSubsystem subsystem, double heading, double speed) {
    driveSubsystem = subsystem;
    addRequirements(subsystem);
    driveSubsystem.ZeroYaw();
    initial_heading =driveSubsystem.getYaw();
    target_heading = heading;
  }

  public AutoTurn(final DriveSubsystem subsystem, double heading) {
   driveSubsystem = subsystem;
    addRequirements(subsystem);
    driveSubsystem.ZeroYaw();
    initial_heading =driveSubsystem.getYaw();
    target_heading = heading;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubsystem.ZeroYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSubsystem.drive(0.0, target_heading);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double current_heading = driveSubsystem.getYaw() - initial_heading;
    double headingError = Math.abs(target_heading - current_heading);

    return (headingError < 0.2);
  }
}
