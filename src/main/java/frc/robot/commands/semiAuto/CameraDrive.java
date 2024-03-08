// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.semiAuto;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.LimeLightSub;
import frc.robot.subsystems.SwerveDrivetrain;

public class CameraDrive extends Command {
  SwerveDrivetrain drivetrain;
  LimeLightSub ll;
  SemiAutoParameters parameters;
  PIDController translationPidController;
  PIDController rotationPidController;
  PIDController strafePidController;

  /** Creates a new CameraDrive. */
  public CameraDrive(SwerveDrivetrain drivetrain, LimeLightSub ll, SemiAutoParameters parameters) {
    this.drivetrain = drivetrain;
    this.ll = ll;
    this.parameters = parameters;
    addRequirements(drivetrain);
    translationPidController =  new PIDController(parameters.translationPID.P, parameters.translationPID.I, parameters.translationPID.D);
    rotationPidController =  new PIDController(parameters.rotationPID.P, parameters.rotationPID.I, parameters.rotationPID.D);
    strafePidController =  new PIDController(parameters.strafePID.P, parameters.strafePID.I, parameters.strafePID.D);

    translationPidController.setTolerance(parameters.translationPID.tolerance);
    translationPidController.setSetpoint(parameters.translationPID.setPoint);

    rotationPidController.setTolerance(parameters.rotationPID.tolerance);
    rotationPidController.setSetpoint(parameters.rotationPID.setPoint);

    strafePidController.setTolerance(parameters.strafePID.tolerance);
    strafePidController.setSetpoint(parameters.strafePID.setPoint);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double translationAmount = translationPidController.calculate(ll.getArea());
    translationAmount = MathUtil.clamp(translationAmount, -.3, .3); //todo move constants

    double rotationAmount = rotationPidController.calculate(ll.getX());
    rotationAmount = MathUtil.clamp(rotationAmount, -.3, .3); //todo move constants

    double strafeAmount = strafePidController.calculate(ll.getX());//todo test strafe vs rotation for X
    strafeAmount = MathUtil.clamp(strafeAmount, -.3, .3); //todo move constants

    drivetrain.drive(new Translation2d(translationAmount, strafeAmount).times(Constants.RobotConstants.driveMaxVelo), rotationAmount*Constants.RobotConstants.rotationMaxAngleVelo);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return translationPidController.atSetpoint() && rotationPidController.atSetpoint() && strafePidController.atSetpoint();
  }
}