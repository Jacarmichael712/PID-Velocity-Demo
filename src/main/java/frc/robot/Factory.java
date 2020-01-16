/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.subsystems.PidChassis;

/**
 * Add your docs here.
 */
public class Factory {
    private static PidChassis chassis = null;

    public static PidChassis getPID(){
        if(chassis == null)
            chassis = new PidChassis(new TalonSRX(9));
        return chassis;
    }
}
