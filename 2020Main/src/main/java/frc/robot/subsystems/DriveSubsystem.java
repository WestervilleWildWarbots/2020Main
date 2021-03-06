package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

  public CANSparkMax frontLeft;
  public CANSparkMax frontRight;
  public CANSparkMax backLeft;
  public CANSparkMax backRight;
  
  public CANEncoder flEnc;
  public CANEncoder frEnc;

  public double Lp = 0.75;
  public double Li = 0.001;
  public double Ld = 0.045;
  public double Rp = 0.75;
  public double Ri = 0.001;
  public double Rd = 0.045;
  private PIDController leftController = new PIDController(Lp,Li,Ld);
  private PIDController rightController = new PIDController(Rp,Ri,Rd);

  public DriveSubsystem() {

    frontLeft = new CANSparkMax(RobotMap.MOTOR_FL,MotorType.kBrushless );
    frontRight = new CANSparkMax(RobotMap.MOTOR_FR,MotorType.kBrushless);
    backLeft = new CANSparkMax(RobotMap.MOTOR_BL,MotorType.kBrushless);
    backRight = new CANSparkMax(RobotMap.MOTOR_BR,MotorType.kBrushless);
    flEnc = frontLeft.getEncoder();
    frEnc = frontRight.getEncoder();
    
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
  public void tankDrive(double leftSpeed, double rightSpeed) {
    frontLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
  }

  public void drive(double leftSpeed, double rightSpeed){
    frontLeft.set(leftController.calculate(leftSpeed));
    frontRight.set(rightController.calculate(rightSpeed));
  }
}