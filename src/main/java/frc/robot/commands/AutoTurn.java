// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurn extends CommandBase {
  private final DriveSubsystem drivesubsystem;
  private double initial_heading;
  private double target_heading;
  /** Creates a new AutoTurn. */

  public AutoTurn(final DriveSubsystem subsystem, double heading, double speed) {
    drivesubsystem = subsystem;
    addRequirements(subsystem);
    drivesubsystem.ZeroYaw();
    initial_heading = drivesubsystem.getYaw();
    target_heading = heading;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public AutoTurn(final DriveSubsystem subsystem, double heading) {
    drivesubsystem = subsystem;
    addRequirements(subsystem);
    drivesubsystem.ZeroYaw();
    initial_heading = drivesubsystem.getYaw();
    target_heading = heading;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
