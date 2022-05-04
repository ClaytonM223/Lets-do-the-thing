// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class ManualDrive extends CommandBase {
  /** Creates a new ManualDrive. */
  public ManualDrive() {
    Requires(Robot.drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  private void Requires(DriveTrain drivetrain) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double move = -RobotContainer.controller.getLeftY();
    double turn = RobotContainer.controller.getRightX(); 
    Robot.drivetrain.manualdrive(move, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
