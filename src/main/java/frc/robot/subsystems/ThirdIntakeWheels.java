// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotConstants;

public class ThirdIntakeWheels extends SubsystemBase {
  /** Creates a new ThirdIntakeWheels. */
CANSparkMax thirdIntakeWheels = new CANSparkMax(RobotConstants.thirdIntakeWheelsCanid, MotorType.kBrushless);

  public ThirdIntakeWheels() {
    thirdIntakeWheels.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void on() {
    // turns thirdIntakeWheels on (set)
    setSpeed(RobotConstants.thridIntakeSpeed);
  }

  public void off() {
    // turns the motor off
    setSpeed(0);
  }

  public void reverse() {
    setSpeed(-RobotConstants.thridIntakeSpeed);
  }

  public void setSpeed(double speed) {
    thirdIntakeWheels.set(speed);
  }
}
