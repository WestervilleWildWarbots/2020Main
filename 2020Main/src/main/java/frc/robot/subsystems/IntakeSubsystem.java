package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeSubsystem extends Subsystem {
  TalonSRX hopperTalon;
  TalonSRX intakeTalon;

  public IntakeSubsystem() {
    hopperTalon = new TalonSRX(RobotMap.MOTOR_HOPPER);
    //intakeTalon = new TalonSRX(RobotMap.MOTOR_INTAKE);
  } 

  @Override
  public void initDefaultCommand(){

  }

  public void hopperSpin(double speed){
      hopperTalon.set(ControlMode.PercentOutput, speed);
  }

  public void hopperCease(){
    hopperTalon.set(ControlMode.PercentOutput, 0);
}

public void hopperUnstick(double speed){
      hopperTalon.set(ControlMode.PercentOutput, speed);
}


  public void intakeSpin(double speed){
    //intakeTalon.set(ControlMode.PercentOutput, speed);

  }
}
