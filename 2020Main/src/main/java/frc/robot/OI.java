package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoShootCommand;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.ShooterSubsystem;

public class OI{

    public static Joystick driveStick;
    public static Joystick armStick;
    public static JoystickButton shootButton;
    final private JoystickButton autoButton;

    public OI(){
        System.out.println("in oi");
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
        armStick = new Joystick(RobotMap.ARM_STICK);

        autoButton = new JoystickButton(armStick, 2);
        
        //start of intake button code
        ///*change to private*/boolean intakeState = false;
        //
        autoButton.whenPressed(new AutoShootCommand());
        //end of intake button code
    }

    public void stickUpdate(){
        //System.out.println("updating");

        if(armStick.getRawButton(1)&&RobotMap.SHOOT_TIMER >= 50){
            System.out.println("get button");
            RobotMap.SHOOTING = !RobotMap.SHOOTING;
            RobotMap.SHOOT_TIMER = 0;
            ShooterSubsystem.shootTime =0;
        }

        if(armStick.getRawButton(3)&&RobotMap.HOPPER_TIMER >= 50){
            System.out.println("get button");
            RobotMap.HOPPING = !RobotMap.HOPPING;
            RobotMap.HOPPER_TIMER= 0;
        }

        if(armStick.getRawButton(4)&&RobotMap.HOPPER_TIMER >= 50){
            System.out.println("get button");
            RobotMap.HOPPING = false;
            RobotMap.CLOGGING = !RobotMap.CLOGGING;
            RobotMap.HOPPER_TIMER= 0;
        }

        RobotMap.SHOOT_TIMER++;
        RobotMap.HOPPER_TIMER++;
    }
    
}