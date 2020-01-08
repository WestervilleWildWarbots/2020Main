package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI{

    // this enum creates the variables for the Axis enum
    public static enum Axis{X, Y, Z, LeftY, RightY, THROTTLE, RightTab};

    public static Joystick driveStick;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
        assoc();
    }
    }
}