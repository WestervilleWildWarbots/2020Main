package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

  public IntakeCommand() {
    requires(Robot.intakeSubsystem);
  }

  @Override
  protected void initialize() {

  }

  @Override
  public void execute() {
    //Robot.intakeSubsystem.intakeSpin(1);
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