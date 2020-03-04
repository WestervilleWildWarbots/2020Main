package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    final double deadzoneY = 0.15;
    final double deadzoneZ = 0.55;     

    double y = OI.driveStick.getY();
    double z = OI.driveStick.getZ();

    //Deadzone Code
    if (Math.abs(y) <= deadzoneY){
      y = 0;
    }

    if (Math.abs(z) <= deadzoneZ){
      z = 0;
    }
   
    z*=Math.abs(z);

    double leftPower = speedscale*-(z-y);
    double rightPower = speedscale*(z+y);

    Robot.driveSubsystem.drive(leftPower, rightPower);

    //if(Robot.driveSubsystem.getGyro() > 1){
     // Robot.driveSubsystem.RioGyro.reset();
    //}

    SmartDashboard.putNumber("Gyroscope",Robot.driveSubsystem.RioGyro.getAngle());
    System.out.println(Robot.driveSubsystem.getGyro());
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