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
    final double speedscale = 0.75;
    final double deadzoneY = 0.15;
    final double deadzoneZ = 0.5;   

    double y = OI.driveStick.getY();
    double z = OI.driveStick.getZ();

    //Deadzone Code
    if (Math.abs(y) <= deadzoneY){
      y = 0;
    }

    if (Math.abs(z) <= deadzoneZ){
      z = 0;
    }

    if (y > 0){
      y = y*0.7;
    }
   
    z*=Math.abs(z*0.7);


    double leftPower = speedscale*-(z-y);
    double rightPower = speedscale*(z+y);

    Robot.driveSubsystem.drive(leftPower, rightPower);
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