/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;

public class VoltageTestCommand extends Command {

  public int timer;
  public String fileName;

  public VoltageTestCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    int timer = 0;
    String fileName = "voltageOutput.txt";
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    while (timer < 60) {
      RobotController.getBatteryVoltage();

      PrintWriter outputStream;
      try {
        outputStream = new PrintWriter(fileName);
        outputStream.println(timer + " " + RobotController.getBatteryVoltage());
        System.out.println(timer + " " + RobotController.getBatteryVoltage());
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     
      timer++;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}