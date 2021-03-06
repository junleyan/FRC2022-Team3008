// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {

  private MotorController m_leftMotor, m_rightMotor;
  public DifferentialDrive diffDrive;
  
  public DriveTrain() {
    m_leftMotor = new PWMSparkMax(Constants.PWM.leftDrive);
    m_rightMotor = new PWMSparkMax(Constants.PWM.rightDrive);
    diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  }

  public void stopMotor() {
    diffDrive.stopMotor();
  }

  // Differential drive
  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(-leftSpeed * Constants.Multiplier.leftDrive, rightSpeed * Constants.Multiplier.rightDrive);
  }

  // Differential drive without multiplier
  public void tankDriveWithoutConstraint(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  // Set individual motors
  public void set(double leftSpeed, double rightSpeed) {
    m_leftMotor.set(leftSpeed);
    m_rightMotor.set(rightSpeed);
  }

  // Set individual voltage of motors
  public void setVoltage(double leftSpeed, double rightSpeed, double voltage) {
    m_leftMotor.set(leftSpeed);
    m_rightMotor.set(rightSpeed);
    m_leftMotor.setVoltage(voltage);
    m_rightMotor.setVoltage(voltage);
  }

}