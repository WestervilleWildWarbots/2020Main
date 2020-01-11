package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI{

    // this enum creates the variables for the Axis enum
    public static enum Axis{X, Y, Z,};

    public static Joystick driveStick;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
    }
}