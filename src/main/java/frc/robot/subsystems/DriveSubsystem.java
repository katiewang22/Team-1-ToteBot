package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveSubsystem {
    private static final WPI_TalonFX leftFrontMotor = RobotMap.leftFrontMotor;
    private static final WPI_TalonFX leftBackMotor = RobotMap.leftBackMotor;
    private static final WPI_TalonFX rightFrontMotor = RobotMap.rightFrontMotor;
    private static final WPI_TalonFX rightBackMotor = RobotMap.rightBackMotor;

    private static XboxController driverController = RobotContainer.driverController;

    private static final double IN_TO_M = .0254;
    
}