package frc.robot.commands;

import frc.robot.Robot;
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
    Robot.intakeSubsystem.hopperSpin(1);
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