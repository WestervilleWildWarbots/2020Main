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
public static double shootTime = 0;

  private static WPI_TalonSRX shooterTopTalon;
  private static WPI_TalonSRX shooterBotTalon;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    shootTime =0;
    shooterTopTalon = new WPI_TalonSRX(RobotMap.MOTOR_ST);
    shooterBotTalon = new WPI_TalonSRX(RobotMap.MOTOR_SB);
  }

  public void shootRamp(double spd){

  if(shootTime <= spd*500){
    shooterTopTalon.set(.002*shootTime);
    shooterBotTalon.set(-(.55/.3)*.002*(shootTime));

    RobotMap.SAVE_SPEED = .002*shootTime;

  }else{
    shooterTopTalon.set(spd);
    shooterBotTalon.set(-(spd+0.25));
  }

  shootTime++;

  }

  public void ceaseRamp(double spd){
    if(shootTime <= spd*500){
      shooterTopTalon.set(spd - .002*shootTime);
      shooterBotTalon.set(spd + -(.55/.3)*.002*(shootTime));
    }else{
      shooterTopTalon.set(0);
      shooterBotTalon.set(0);
    }
  
    shootTime++;
  }

  public void shoot(double spd){
    shooterTopTalon.set(spd);
    shooterBotTalon.set(-(spd+0.25));
  }

  public void cease(double spd){
    shooterTopTalon.set(0);
    shooterBotTalon.set(0);
  }

}
