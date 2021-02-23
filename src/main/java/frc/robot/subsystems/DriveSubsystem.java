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

    public static final int MOTOR_ENCODER_CODES_PER_REV = 2048;
    public static final double DIAMETER_INCHES = 5.0;
    private static final double IN_TO_M = .0254;

    public static final double WHEEL_DIAMETER = DIAMETER_INCHES * IN_TO_M;
    public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;

    private static final double GEAR_RATIO = 12.75;

    private static final double TICKS_PER_METER = (MOTOR_ENCODER_CODES_PER_REV * GEAR_RATIO) / (WHEEL_CIRCUMFERENCE);
    private static final double METERS_PER_TICKS = 1/TICKS_PER_METER;

    public boolean state_flag_motion_profile = true;
    
}