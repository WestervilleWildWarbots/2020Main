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

  public double Lp = 0.1;
  public double Li = 0.1;
  public double Ld = 0.1;
  public double Rp = 1;
  public double Ri = 1;
  public double Rd = 1;
  private edu.wpi.first.wpilibj.controller.PIDController leftController = new edu.wpi.first.wpilibj.controller.PIDController(Lp,Li,Ld);
  private edu.wpi.first.wpilibj.controller.PIDController rightController = new edu.wpi.first.wpilibj.controller.PIDController(Rp,Ri,Rd);

  public DriveSubsystem() {

    frontLeft = new CANSparkMax(RobotMap.MOTOR_FL,MotorType.kBrushless );
    frontRight = new CANSparkMax(RobotMap.MOTOR_FR,MotorType.kBrushless);
    backLeft = new CANSparkMax(RobotMap.MOTOR_BL,MotorType.kBrushless);
    backRight = new CANSparkMax(RobotMap.MOTOR_BR,MotorType.kBrushless);
        
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
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  public void drive(double leftSpeed, double rightSpeed){
    frontLeft.set(leftController.calculate(0.1));
    frontRight.set(rightController.calculate(0.1));
  }
}