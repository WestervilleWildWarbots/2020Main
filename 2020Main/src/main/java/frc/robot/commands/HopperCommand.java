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
  if(RobotMap.HOPPING){
    System.out.println("actually shooting");
  Robot.intakeSubsystem.hopperSpin(0.30);

  }else if(RobotMap.INIT_SHOOT){
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