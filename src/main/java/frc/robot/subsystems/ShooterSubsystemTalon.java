/* package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Log;
import io.github.oblarg.oblog.annotations.Config;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase implements Loggable{ 
  @Log
  private final WPI_TalonSRX m_shooterMotor = new WPI_TalonSRX(ShooterConstants.kShooterMotorPort);

  private final WPI_VictorSPX m_shooterMotor2 = new WPI_VictorSPX(ShooterConstants.kShooterMotorPort2);

  @Log
  private final WPI_VictorSPX m_feederMotor = new WPI_VictorSPX(ShooterConstants.kFeederMotorPort);
  
  //The shooter subsystem for the robot.
  public ShooterSubsystem() {
    m_shooterMotor.setSensorPhase(false);
    m_shooterMotor2.follow(m_shooterMotor);
    m_shooterMotor2.setInverted(InvertType.OpposeMaster);
  }

  @Config(name="shooterPID")
  public void setPID(double kP, double kI, double kD, double kF) {
    m_shooterMotor.config_kP(0, kP, 30);
    m_shooterMotor.config_kI(0, kI, 30);
		m_shooterMotor.config_kD(0, kD, 30);
		m_shooterMotor.config_kF(0, kF, 30);
  }

  @Log
  public boolean atSetpoint() {
    return TalontoRPM(m_shooterMotor.getClosedLoopError()) < ShooterConstants.kShooterToleranceRPM;
  }

  public void runFeeder() {
    m_feederMotor.set(ShooterConstants.kFeederSpeed);
  }

  public void stopFeeder() {
    m_feederMotor.set(0);
  }

  @Config
  public void setRPM(double RPM) {
    m_shooterMotor.config_kF(0, RPM * ShooterConstants.kF, 30);
    SmartDashboard.putNumber("kf", RPM * ShooterConstants.kF);
    m_shooterMotor.set(ControlMode.Velocity, RPMtoTalon(RPM));
  }
  
  @Log
  public double RPMtoTalon(double RPM) {
    return (RPM * ShooterConstants.kEncoderCPR) / (600);
  }

  @Log
  public double TalontoRPM(double TalonUnits) {
    return (TalonUnits * 600) / ShooterConstants.kEncoderCPR;
  }

  @Log
  public double getShooterRPM(){
    return TalontoRPM(m_shooterMotor.getSelectedSensorVelocity());
  }
} */