package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

  public DriveCommand() {
    requires(Robot.driveSubsystem);
  }

  @Override
  protected void initialize() {
  }

  @Override
public void execute() {
    final double speedscale = 1;
    final double deadzone = 0.075;   

    double y = OI.driveStick.getY();
    double z = OI.driveStick.getZ();

    if (Math.abs(y) <= deadzone){
      y = 0;
    }

    if (Math.abs(z) <= deadzone){
      z = 0;
    }

    z*=Math.abs(z);

    double leftPower = speedscale*(z-y);
    double rightPower = speedscale*(z+y);

    Robot.driveSubsystem.tankDrive(leftPower,rightPower);
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