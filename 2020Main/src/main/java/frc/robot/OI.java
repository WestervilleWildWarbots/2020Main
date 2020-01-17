package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI{

    public static Joystick driveStick;
    public static JoystickButton shootButton;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
        shootButton = new JoystickButton(driveStick, 1);
    }
}