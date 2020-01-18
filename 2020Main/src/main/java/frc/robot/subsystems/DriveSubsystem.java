package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

  public CANSparkMax frontLeft;
  public CANSparkMax frontRight;
  public CANSparkMax backLeft;
  public CANSparkMax backRight;

  public DriveSubsystem() {

    CANSparkMax frontLeft = new CANSparkMax(RobotMap.MOTOR_FL,MotorType.kBrushless );
    CANSparkMax frontRight = new CANSparkMax(RobotMap.MOTOR_FR,MotorType.kBrushless);
    CANSparkMax backLeft = new CANSparkMax(RobotMap.MOTOR_BL,MotorType.kBrushless);
    CANSparkMax backRight = new CANSparkMax(RobotMap.MOTOR_BR,MotorType.kBrushless);
        
    frontRight.setInverted(true);
    backLeft.follow(frontLeft);    
    backRight.follow(frontRight);

    backLeft.close();
    backRight.close();

  }

  @Override
  public void initDefaultCommand(){

  }

    //Basic Drive Method
  public void drive(double leftSpeed, double rightSpeed) {
    System.out.print(leftSpeed);
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  
}
