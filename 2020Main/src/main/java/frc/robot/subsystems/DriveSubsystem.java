package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

  public CANSparkMax frontLeft;
  public CANSparkMax frontRight;
  public CANSparkMax backLeft;
  public CANSparkMax backRight;
  
  public CANEncoder flEnc;

  private static AnalogGyro RioGyro = new AnalogGyro(RobotMap.GYRO);

  public DriveSubsystem() {

    frontLeft = new CANSparkMax(RobotMap.MOTOR_FL,MotorType.kBrushless );
    frontRight = new CANSparkMax(RobotMap.MOTOR_FR,MotorType.kBrushless);
    backLeft = new CANSparkMax(RobotMap.MOTOR_BL,MotorType.kBrushless);
    backRight = new CANSparkMax(RobotMap.MOTOR_BR,MotorType.kBrushless);
    flEnc = frontLeft.getEncoder();
    frontRight.setInverted(true);
    backLeft.follow(frontLeft);    
    backRight.follow(frontRight);

    backLeft.close();
    backRight.close();

  }

  @Override
  public void initDefaultCommand(){

  }
  public void getGyros() {
    
  }
    //Basic Drive Method
  public void drive(double leftSpeed, double rightSpeed) {
    System.out.println(leftSpeed);
    System.out.println(rightSpeed);

    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  public static double getGyro(){
    return RioGyro.getAngle();
}
}
