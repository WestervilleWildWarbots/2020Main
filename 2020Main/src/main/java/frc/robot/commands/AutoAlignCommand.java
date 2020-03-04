/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogPotentiometer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class AutoAlignCommand extends Command {
  public Boolean aligned = false;
  public  Boolean quasi = false;
  public  Boolean sweetSpot = false;
  public AutoAlignCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
  }

  public double getDist(AnalogPotentiometer ainp){
    return (512/2.54)*ainp.get();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {
 
    SmartDashboard.putNumber("Front Left Distance", getDist(Robot.flDist));
    SmartDashboard.putNumber("Front Right Distance", getDist(Robot.frDist));
    //SmartDashboard.putNumber("Back Right Distance", (512/2.54)*getDist(Robot.brDist));
    SmartDashboard.putNumber("Ball Distance", getDist(Robot.balDist));

    if(getDist(Robot.flDist)+10 >= getDist(Robot.frDist)&& getDist(Robot.flDist)-10 <= getDist(Robot.frDist)  && ((getDist(Robot.flDist) <= 36 && getDist(Robot.flDist) > 26)|| (getDist(Robot.frDist) <= 36 && getDist(Robot.frDist) > 26))){
      aligned =true;
      
    }else{
      aligned = false;
    }
/*
    if(getDist(Robot.flDist)+5 >= getDist(Robot.frDist)&& getDist(Robot.flDist)-5 <= getDist(Robot.frDist)  && ((getDist(Robot.flDist) <= 42 && getDist(Robot.flDist) > 38)|| (getDist(Robot.frDist) <= 42 && getDist(Robot.frDist) > 38))){
      sweetSpot =true;
      
    }else{
      sweetSpot = false;
    }
*/

/*
    if(getDist(Robot.flDist)+10 >= getDist(Robot.frDist)&& getDist(Robot.flDist)-10 <= getDist(Robot.frDist)  && getDist(Robot.flDist) <= 55){
      quasi =true;
      
    }else{
      quasi = false;
    }
    */
    SmartDashboard.putBoolean("Aligned",aligned );
    SmartDashboard.putBoolean("Sweet Spot",sweetSpot);
  
    //SmartDashboard.putBoolean("Quasi",quasi);

    System.out.println(aligned);
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
