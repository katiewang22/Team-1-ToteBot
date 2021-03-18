package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

public class RobotMap {
    public static final int LEFT_FRONT_MOTOR = 3;
    public static final int LEFT_BACK_MOTOR = 1;
    public static final int RIGHT_FRONT_MOTOR = 4;
    public static final int RIGHT_BACK_MOTOR = 2;

    public static WPI_TalonFX leftFrontMotor = new WPI_TalonFX(LEFT_FRONT_MOTOR);
    public static WPI_TalonFX leftBackMotor = new WPI_TalonFX(LEFT_BACK_MOTOR);
    public static WPI_TalonFX rightFrontMotor = new WPI_TalonFX(RIGHT_FRONT_MOTOR);
    public static WPI_TalonFX rightBackMotor = new WPI_TalonFX(RIGHT_BACK_MOTOR);

    public static PigeonIMU drive_imu = new PigeonIMU(1);
}