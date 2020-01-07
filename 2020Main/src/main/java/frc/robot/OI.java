package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI{

    public static enum Axis{X, Y, Z, LeftY, RightY, THROTTLE, RightTab}; //Axis enum

    public static Joystick driveStick;

    public OI(){
        driveStick = new Joystick(RobotMap.DRIVE_STICK);
        assoc();
    }

    public static void getJoystickAxis(int joystickID,Axis axis){
        Joystick joystick;
        double axisValue = 0;

        if(joystickID == RobotMap.DRIVE_STICK){
            joystick = driveStick;
        }else{
            return 0;
        }

        if(axis == Axis.X){
            axisValue = joystick.getX();
        }else if (axis == Axis.Y){
            axisValue = joystick.getY();
        }else if (axis == Axis.Z){
            axisValue = joystick.getZ();
        }

        if (Math.abs(axisValue)<.1){
            axisValue = 0;
        }
        return axisValue;
    }
}