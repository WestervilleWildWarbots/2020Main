package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HopperCommand;

public class OI{

    public static Joystick driveStick;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);

        final JoystickButton hopperButton = new JoystickButton(driveStick, 3);

        hopperButton.toggleWhenPressed(new HopperCommand());
    }
}