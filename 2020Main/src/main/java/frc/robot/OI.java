package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;

public class OI{

    public static Joystick driveStick;
    public static JoystickButton shootButton;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);

        final JoystickButton hopperButton = new JoystickButton(driveStick, 3);

        hopperButton.toggleWhenPressed(new HopperCommand());

        shootButton = new JoystickButton(driveStick, 1);
        shootButton.toggleWhenPressed(new ShooterCommand());

        //start of intake button code
        ///*change to private*/boolean intakeState = false;
        //
        final JoystickButton intakeButton = new JoystickButton(driveStick, 4);

        intakeButton.toggleWhenPressed(new IntakeCommand());
        //end of intake button code
    }
}