// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoPaths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutoMove;
import frc.robot.commands.AutoTurn;

public class AutoPath1 extends SequentialCommandGroup {
// First auto path

  public AutoPath1(DriveSubsystem driveSubsystem) {
    super(
      // directions for robot to move forward # meters, then turn # degrees clockwise
      new AutoMove(driveSubsystem, 2.8), new AutoTurn(driveSubsystem, 45),
      new AutoMove(driveSubsystem, -0.5), new AutoTurn(driveSubsystem, 90),
      new AutoTurn(driveSubsystem, 7), new AutoTurn(driveSubsystem, 62)
    );
  }
}
