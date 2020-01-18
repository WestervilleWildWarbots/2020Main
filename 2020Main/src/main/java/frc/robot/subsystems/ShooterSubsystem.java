/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static WPI_TalonSRX shooterTopTalon;
  private static WPI_TalonSRX shooterBotTalon;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    shooterTopTalon = new WPI_TalonSRX(RobotMap.MOTOR_ST);
    shooterBotTalon = new WPI_TalonSRX(RobotMap.MOTOR_SB);

    shooterBotTalon.follow(shooterTopTalon);

  }

  public void shoot(double spd){

    shooterTopTalon.set(spd);
    
  }

}
