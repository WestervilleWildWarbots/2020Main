package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

    private static TalonSRX frontLeft;
        private static TalonSRX frontRight;
        private static TalonSRX backLeft;
        private static TalonSRX backRight;

  public DriveSubsystem() {

        TalonSRX frontLeft = new TalonSRX(RobotMap.MOTOR_FL);
        TalonSRX frontRight = new TalonSRX(RobotMap.MOTOR_FR);
        TalonSRX backLeft = new TalonSRX(RobotMap.MOTOR_BL);
        TalonSRX backRight = new TalonSRX(RobotMap.MOTOR_BR);
        
        frontRight.setInverted(true);
        backLeft.follow(frontLeft);    
        backRight.follow(frontRight);

  }

  @Override
  public void initDefaultCommand(){

  }

    //Basic Drive Method
  public void drive(double leftSpeed, double rightSpeed) {
    frontLeft.set(ControlMode.PercentOutput,leftSpeed);
    frontRight.set(ControlMode.PercentOutput,rightSpeed);
  }

  
}
