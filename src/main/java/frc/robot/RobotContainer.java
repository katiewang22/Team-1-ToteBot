package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
    public static DriveSubsystem driveSubsystem = new DriveSubsystem();

    // The controller
    // TODO change the port from 0
    public static XboxController driverController = new XboxController(0);

    public RobotContainer() {
        

    }
}