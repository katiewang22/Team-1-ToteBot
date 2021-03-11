package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {

    // Create instances of subsystems
    public static DriveSubsystem driveSubsystem = new DriveSubsystem();
    public static XboxController driverController = new XboxController(0);

    // Initiate JoystickDrive
    public RobotContainer() {
        configureButtonBindings();

        driveSubsystem.setDefaultCommand(
            new JoystickDrive(driveSubsystem)
        );

    }

    private void configureButtonBindings() {

    }
}