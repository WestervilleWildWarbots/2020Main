package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class OI{

    public static Joystick driveStick;
    public static JoystickButton shootButton;

    public OI(){
        System.out.println("in oi");
        driveStick = new Joystick(RobotMap.DRIVE_STICK);

        final JoystickButton hopperButton = new JoystickButton(driveStick, 3);

        hopperButton.toggleWhenPressed(new HopperCommand());

        shootButton = new JoystickButton(driveStick, 1);
        
        //start of intake button code
        ///*change to private*/boolean intakeState = false;
        //
        final JoystickButton intakeButton = new JoystickButton(driveStick, 4);
        intakeButton.toggleWhenPressed(new IntakeCommand());
        //end of intake button code
    }

    public void stickUpdate(){
        //System.out.println("updating");

        if(driveStick.getRawButton(1)&&RobotMap.SHOOT_TIMER >= 50){
            System.out.println("get button");
            RobotMap.SHOOTING = !RobotMap.SHOOTING;
            RobotMap.SHOOT_TIMER = 0;
            ShooterSubsystem.shootTime =0;
        }

        if(driveStick.getRawButton(3)&&RobotMap.HOPPER_TIMER >= 50){
            System.out.println("get button");
            RobotMap.HOPPING = !RobotMap.HOPPING;
            RobotMap.HOPPER_TIMER= 0;
        }

        if(driveStick.getRawButton(4)&&RobotMap.HOPPER_TIMER >= 50){
            System.out.println("get button");
            RobotMap.HOPPING = false;
            RobotMap.CLOGGING = !RobotMap.CLOGGING;
            RobotMap.HOPPER_TIMER= 0;
        }

        RobotMap.SHOOT_TIMER++;
        RobotMap.HOPPER_TIMER++;
    }
    
}