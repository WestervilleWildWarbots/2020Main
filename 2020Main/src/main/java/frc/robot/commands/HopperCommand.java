package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class HopperCommand extends Command {

  public HopperCommand() {
    requires(Robot.intakeSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
public void execute() {

  System.out.println(RobotMap.SHOOT_TIMER);
  if(RobotMap.CLOGGING){
    Robot.intakeSubsystem.hopperUnstick(.25);
  }else if(!RobotMap.HOPPING){
    Robot.intakeSubsystem.hopperCease();
  }

  if(RobotMap.HOPPING){
    System.out.println("actually hopping");
    Robot.intakeSubsystem.hopperSpin(-0.50);

  }else if(!RobotMap.CLOGGING){
    Robot.intakeSubsystem.hopperCease();  
  }

}

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}