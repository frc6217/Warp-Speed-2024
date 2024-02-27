// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.brakeCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveDrivetrain;

public class UnenableBrakes extends Command {
  /** Creates a new UnenableBrakes. */

  SwerveDrivetrain swerveDrivetrain;
  public UnenableBrakes(SwerveDrivetrain swerveDrivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.swerveDrivetrain = swerveDrivetrain;
    addRequirements(swerveDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (null != swerveDrivetrain)
    swerveDrivetrain.unenableBrakes();
  }

  @Override
  public boolean runsWhenDisabled() {
    return true;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
