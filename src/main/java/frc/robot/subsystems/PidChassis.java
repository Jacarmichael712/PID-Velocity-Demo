/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PidChassis extends SubsystemBase {
  private TalonSRX center;
  /**
   * Creates a new PidChassis.
   */
  public PidChassis(TalonSRX center1) {
      center = center1;

      center.configAllowableClosedloopError(0, 0, 1);
      center.selectProfileSlot(0, 0);
      center.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
      center.setSensorPhase(true);
      center.setInverted(true);
      center.config_kF(0, 0.18);
      center.config_kP(0, 0.23);
      center.config_kI(0, 0.0007);
      center.config_kD(0, 0.0);
      
      
      
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void getDrive(double velocity){
    center.set(ControlMode.Velocity, velocity);
    System.out.println(center.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Encoder Pos", center.getSelectedSensorVelocity());
  }
  public void getPercent(double percent){
    center.set(ControlMode.PercentOutput, percent);
    System.out.println(center.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Encoder Pos", center.getSelectedSensorVelocity());
  }

  public void stopDrive(){
    center.set(ControlMode.PercentOutput, 0.0);
  }

}
