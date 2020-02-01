package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {

  public AutonomousCommand() {
    requires(Robot.driveSubsystem);

  }

  @Override
  protected void initialize() {
  }

  @Override
  public void execute() {

  Robot.driveSubsystem.drive(0.25, 0.25);    
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