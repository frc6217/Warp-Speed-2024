// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdleConfiguration;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class CAN_dle extends SubsystemBase {
  /** Creates a new CANdle. */
  CANdle led = new CANdle(51);
  public CAN_dle() {
     CANdleConfiguration config = new CANdleConfiguration();
 config.stripType = LEDStripType.RGB; // set the strip type to RGB
 config.brightnessScalar = 0.5; // dim the LEDs to half brightness
led.configAllSettings(config);

led.setLEDs(255, 255, 255); // set the CANdle LEDs to white
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
