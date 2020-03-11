package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
    public int timer;
  public AutonomousCommand() {
    requires(Robot.driveSubsystem);
     
  }

  @Override
  protected void initialize() {
  }

  @Override
  public void execute() {
    //System.out.println(Robot.choice);//prints out the auto mode choice
    //System.out.println(Robot.driveSubsystem.flEnc.getPosition());
    //System.out.println(timer);

    if(Robot.choice == "one"){
      if(Robot.driveSubsystem.flEnc.getPosition() <= 10){
        Robot.driveSubsystem.drive(0.25, 0.25);
      }
      else{
        Robot.driveSubsystem.drive(0, 0);
      }
    }

    if(Robot.choice == "two"){
      if(Robot.driveSubsystem.flEnc.getPosition() <= 50){
        Robot.driveSubsystem.drive(0.25, 0.25);
      }
      else if(timer <=400){
        timer++;
        Robot.driveSubsystem.drive(0, 0);
        if(timer >50){
        RobotMap.HOPPING=true;
        }
        Robot.shooterSubsystem.shootRamp(0.30);
      }else if(timer == 401){
        ShooterSubsystem.shootTime=0;
        RobotMap.HOPPING=false;
        timer++;
      }else{
        Robot.shooterSubsystem.ceaseRamp(0.30);
      }

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