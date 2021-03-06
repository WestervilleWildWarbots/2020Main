/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterCommand extends Command {
  public ShooterCommand() {
    System.out.println("reached Shooter");
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    //System.out.println("shooting");

    if(RobotMap.SHOOTING){
     // System.out.println("actually shooting");
    Robot.shooterSubsystem.shootRamp(0.245);

      if(!RobotMap.INIT_SHOOT){
        RobotMap.INIT_SHOOT = true;
      }

    }else if(RobotMap.INIT_SHOOT){
    Robot.shooterSubsystem.ceaseRamp(RobotMap.SAVE_SPEED);  
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}