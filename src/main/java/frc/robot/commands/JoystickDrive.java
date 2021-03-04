package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class JoystickDrive extends CommandBase{
    private final DriveSubsystem driveSubsystem;
    private final static XboxController driverController = RobotContainer.driverController;

    public JoystickDrive(DriveSubsystem drivetrain) {
        driveSubsystem = drivetrain;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double throttle = driverController.getX(Hand.kLeft);
        double rotate = driverController.getX(Hand.kRight);

        // Deadband for throttle and rotate
        if ((throttle > 0 && throttle < 0.25) || (throttle < 0 && throttle > -0.25)) {
            throttle = 0;
        }
        if ((rotate > 0 && rotate < 0.25) || (rotate < 0 && rotate > -0.25)) {
            rotate = 0;
        }

        rotate *= 2;

        // Slow speed
        if (driverController.getTriggerAxis(Hand.kRight) > 0.25) {
            throttle = Math.signum(throttle) * 0.75;
        }

        // Fast speed
        else if (driverController.getAButton()) {
            throttle *= 1.1;
        }

        // Normal speed
        else {
            throttle *= 0.8;
        }

        driveSubsystem.drive(throttle, rotate);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}