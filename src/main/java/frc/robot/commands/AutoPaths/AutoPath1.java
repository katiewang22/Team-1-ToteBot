// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoPaths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutoMove;
import frc.robot.commands.AutoTurn;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoPath1 extends SequentialCommandGroup {
  /** Creates a new AutoPath1. */
  public AutoPath1(final DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    super(
      new AutoMove(driveSubsystem, 2.8), new AutoTurn(driveSubsystem, 0.1),
      new AutoMove(driveSubsystem, -0.5), new AutoTurn(driveSubsystem, 0.1),
      new AutoTurn(driveSubsystem, 160), new AutoTurn(driveSubsystem, 0.1),
      new AutoMove(driveSubsystem, 2));
  }
}
