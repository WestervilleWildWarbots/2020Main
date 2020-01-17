package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

  private static CANSparkMax frontLeft;
  private static CANSparkMax frontRight;
  private static CANSparkMax backLeft;
  private static CANSparkMax backRight;

  public DriveSubsystem() {

    CANSparkMax frontLeft = new CANSparkMax(RobotMap.MOTOR_FL,MotorType.kBrushless );
    CANSparkMax frontRight = new CANSparkMax(RobotMap.MOTOR_FR,MotorType.kBrushless);
    CANSparkMax backLeft = new CANSparkMax(RobotMap.MOTOR_BL,MotorType.kBrushless);
    CANSparkMax backRight = new CANSparkMax(RobotMap.MOTOR_BR,MotorType.kBrushless);
        
    frontRight.setInverted(true);
    backLeft.follow(frontLeft);    
    backRight.follow(frontRight);

  }

  @Override
  public void initDefaultCommand(){

  }

    //Basic Drive Method
  public void drive(double leftSpeed, double rightSpeed) {
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  
}
