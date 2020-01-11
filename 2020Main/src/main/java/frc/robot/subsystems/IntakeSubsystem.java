package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class IntakeSubsystem extends Subsystem {
  TalonSRX hopperTalon;

  public IntakeSubsystem() {
    hopperTalon = new TalonSRX(RobotMap.MOTOR_HOPPER);

  } 

  @Override
  public void initDefaultCommand(){

  }

  public void hopperSpin(double speed){
      hopperTalon.set(ControlMode.PercentOutput, speed);
  }
}
