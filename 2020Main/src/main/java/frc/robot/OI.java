package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI{

    public static Joystick driveStick;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
    }
}