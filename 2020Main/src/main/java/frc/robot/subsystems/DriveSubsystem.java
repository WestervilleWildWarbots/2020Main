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
  public double Lp = 1;
  public double Li = 1;
  public double Ld = 1;
  public double Rp = 1;
  public double Ri = 1;
  public double Rd = 1;
  private edu.wpi.first.wpilibj.controller.PIDController leftController = new edu.wpi.first.wpilibj.controller.PIDController(Lp,Li,Ld);
  private edu.wpi.first.wpilibj.controller.PIDController rightController = new edu.wpi.first.wpilibj.controller.PIDController(Rp,Ri,Rd);

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
  public void tankDrive(double leftSpeed, double rightSpeed) {
    frontRight.setInverted(true);
    backLeft.follow(frontLeft);    
    backRight.follow(frontRight);

    backLeft.close();
    backRight.close();

    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  public void drive(double leftSpeed, double rightSpeed){
    backLeft.follow(backLeft);
    backRight.follow(backRight);
    backRight.setInverted(true);

    frontLeft.set(leftController.calculate(leftSpeed));
    frontRight.set(rightController.calculate(rightSpeed));
  }

  
}