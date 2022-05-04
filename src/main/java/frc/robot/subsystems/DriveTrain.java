// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ManualDrive;



public class DriveTrain extends SubsystemBase {

  public WPI_VictorSPX leftmaster = new WPI_VictorSPX(Constants.LEFT_MASTER_PORT);
  public WPI_VictorSPX leftslave = new WPI_VictorSPX(Constants.LEFT_SLAVE_PORT);
  public WPI_VictorSPX rightmaster = new WPI_VictorSPX(Constants.RIGHT_MASTER_PORT);
  public WPI_VictorSPX rightslave = new WPI_VictorSPX(Constants.RIGHT_SLAVE_PORT);

  public DifferentialDrive drive = new DifferentialDrive(leftmaster, rightmaster);

  public DriveTrain(){
     leftslave.follow(leftmaster);
     rightslave.follow(rightmaster);
     rightmaster.setInverted(true);
     rightslave.setInverted(true);
  }

    public void manualdrive(double move, double turn){
      drive.arcadeDrive(move, turn);

    }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ManualDrive());
  }
}

