package frc.robot.commands;

import frc.robot.Logger;
import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class RetractCommand extends Command {

  public DriveCommand() {
    requires(Robot.driveSubsystem);
  }

  @Override
  protected void initialize() {
    final double speedscale = 1;
    final double deadzone = 0.075;
  }

  @Override
  protected void execute() {
    double y = OI.driveStick.getY();
    double z = OI.driveStick.getZ();
    z*=Math.abs(z);

    double leftPower = speedscale*(y-z);
    double rightPower = speedscale*(y+z);

    driveSubsystem.drive(leftPower,rightPower);
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