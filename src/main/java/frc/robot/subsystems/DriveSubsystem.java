package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveSubsystem extends SubsystemBase {
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
    //TODO value of TIMEOUT_MS
    private static final int TIMEOUT_MS = 0;

    public boolean state_flag_motion_profile = true;
    
    public DriveSubsystem() {
        leftFrontMotor.setInverted(false);
        rightFrontMotor.setInverted(true);
        leftBackMotor.setInverted(false);
        rightBackMotor.setInverted(true);

        leftFrontMotor.set(ControlMode.Follower, leftBackMotor.getDeviceID());
        rightFrontMotor.set(ControlMode.Follower, rightBackMotor.getDeviceID());

        leftFrontMotor.setNeutralMode(NeutralMode.Coast);
        rightFrontMotor.setNeutralMode(NeutralMode.Coast);
        leftBackMotor.setNeutralMode(NeutralMode.Coast);
        rightBackMotor.setNeutralMode(NeutralMode.Coast);

        resetEncoders();

        leftFrontMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
        leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        leftFrontMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
        leftFrontMotor.configVelocityMeasurementWindow(10);
        leftFrontMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

        leftBackMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
        leftBackMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        leftBackMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
        leftBackMotor.configVelocityMeasurementWindow(10);
        leftBackMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

        rightFrontMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
        rightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        rightFrontMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
        rightFrontMotor.configVelocityMeasurementWindow(10);
        rightFrontMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

        rightBackMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
        rightBackMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        rightBackMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
        rightBackMotor.configVelocityMeasurementWindow(10);
        rightBackMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

        leftFrontMotor.configNominalOutputForward(0, TIMEOUT_MS);
        leftFrontMotor.configNominalOutputReverse(0, TIMEOUT_MS);
        leftFrontMotor.configPeakOutputForward(1, TIMEOUT_MS);
        leftFrontMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

        leftBackMotor.configNominalOutputForward(0, TIMEOUT_MS);
        leftBackMotor.configNominalOutputReverse(0, TIMEOUT_MS);
        leftBackMotor.configPeakOutputForward(1, TIMEOUT_MS);
        leftBackMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

        rightFrontMotor.configNominalOutputForward(0, TIMEOUT_MS);
        rightFrontMotor.configNominalOutputReverse(0, TIMEOUT_MS);
        rightFrontMotor.configPeakOutputForward(1, TIMEOUT_MS);
        rightFrontMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

        rightBackMotor.configNominalOutputForward(0, TIMEOUT_MS);
        rightBackMotor.configNominalOutputReverse(0, TIMEOUT_MS);
        rightBackMotor.configPeakOutputForward(1, TIMEOUT_MS);
        rightBackMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

        leftFrontMotor.configNeutralDeadband(0.001, TIMEOUT_MS);
        leftBackMotor.configNeutralDeadband(0.001, TIMEOUT_MS);
        rightFrontMotor.configNeutralDeadband(0.001, TIMEOUT_MS);
        rightBackMotor.configNeutralDeadband(0.001, TIMEOUT_MS);

        leftFrontMotor.setSensorPhase(true);
        leftBackMotor.setSensorPhase(true);
        rightFrontMotor.setSensorPhase(false);
        rightBackMotor.setSensorPhase(false);

        leftFrontMotor.setInverted(false);
        leftBackMotor.setInverted(false);
        rightFrontMotor.setInverted(true);
        rightBackMotor.setInverted(true);
    }

    public void setModePercentVoltage() {
        leftFrontMotor.set(ControlMode.PercentOutput, 0);
        leftBackMotor.set(ControlMode.PercentOutput, 0);
        rightFrontMotor.set(ControlMode.PercentOutput, 0);
        rightBackMotor.set(ControlMode.PercentOutput, 0);
    }

    public static void drive(double throttle, double rotate) {
        leftFrontMotor.set(throttle + rotate);
        leftBackMotor.set(throttle + rotate);
        rightFrontMotor.set(throttle - rotate);
        rightBackMotor.set(throttle - rotate);
    }

    public void stop() {
        drive(0,0);
    }

    public double getLeftFrontEncoderPosition() {
        return leftFrontMotor.getSelectedSensorPosition();
    }

    public double getLeftBackEncoderPosition() {
        return leftBackMotor.getSelectedSensorPosition();
    }

    public double getRightFrontEncoderPosition() {
        return rightFrontMotor.getSelectedSensorPosition();
    }

    public double getRightBackEncoderPosition() {
        return rightBackMotor.getSelectedSensorPosition();
    }

    public double getLeftEncoderPosition() {
        return ((getLeftFrontEncoderPosition() + getLeftBackEncoderPosition()) / 2);
    }

    public double getRightEncoderPosition() {
        return ((getRightFrontEncoderPosition() + getRightBackEncoderPosition()) / 2);
    }

    public double distanceTravelledInTicks() {
        return ((getLeftEncoderPosition() + getRightEncoderPosition()) / 2);
    }

    public double getLeftEncoderVelocityMetersPerSecond() {
        double leftVelocityMPS = (leftFrontMotor.getSelectedSensorVelocity() * 10);
        leftVelocityMPS = leftVelocityMPS * METERS_PER_TICKS;
        return (leftVelocityMPS);
    }

    public double getRightEncoderVelocityMetersPerSecond() {
        double rightVelocityMPS = (rightFrontMotor.getSelectedSensorVelocity() * 10);
        rightVelocityMPS = rightVelocityMPS * METERS_PER_TICKS;
        return (rightVelocityMPS);
    }

    public double leftDistanceTravelledInMeters() {
        double left_dist = getLeftEncoderPosition() * METERS_PER_TICKS;
        return (left_dist);
    }

    public double rightDistanceTravelledInMeters() {
        double right_dist = getRightEncoderPosition() * METERS_PER_TICKS;
        return (right_dist);
    }

    public double distanceTravelledInMeters() {
        double distanceTravelled = ((leftDistanceTravelledInMeters() + rightDistanceTravelledInMeters()) / 2);
        return (distanceTravelled);
    }

    public void ZeroYaw() {
        RobotMap.drive_imu.setYaw(0);
    }

    public double getYaw() {
        double[] ypr = new double[3];
        RobotMap.drive_imu.getYawPitchRoll(ypr);
        return ypr[0];
    }

    public void resetEncoders() {
        leftFrontMotor.setSelectedSensorPosition(0);
        rightFrontMotor.setSelectedSensorPosition(0);
        leftBackMotor.setSelectedSensorPosition(0);
        rightBackMotor.setSelectedSensorPosition(0);
    }
}