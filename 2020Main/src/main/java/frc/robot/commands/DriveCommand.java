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
    final double speedscale = 0.5;
    final double deadzone = 0.15;   

    double y = OI.driveStick.getY();
    double z = OI.driveStick.getZ();

    //Deadzone Code
    if (Math.abs(y) <= deadzone){
      y = 0;
    }

    if (Math.abs(z) <= deadzone){
      z = 0;
    }
   
    z*=Math.abs(z);

    double leftPower = speedscale*(z-y);
    double rightPower = speedscale*(z+y);

    Robot.driveSubsystem.drive(leftPower,rightPower);
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