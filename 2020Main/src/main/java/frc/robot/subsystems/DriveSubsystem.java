package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {

        private static WPI_TalonSRX frontLeft;
        private static WPI_TalonSRX frontRight;
        private static WPI_TalonSRX backLeft;
        private static WPI_TalonSRX backRight;

  public DriveSubsystem() {

        WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.MOTOR_FL);
        WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.MOTOR_FR);
        WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.MOTOR_BL);
        WPI_TalonSRX backRight = new WPI_TalonSRX(RobotMap.MOTOR_BR);

  }

  @Override
  public void initDefaultCommand(){

  }

    //Basic Drive Method
  public void drive(double leftSpeed, double rightSpeed) {
      
  }

  
}
