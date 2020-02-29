package frc.robot;

public class RobotMap{
    
    //drive stick
    public static final int DRIVE_STICK = 0;

    //command booleans
    public static Boolean SHOOTING= false;
    public static Boolean INIT_SHOOT = false;
    public static Boolean HOPPING = false;
    public static Boolean CLOGGING = false;

    public static double SHOOT_TIMER = 0;
    public static double HOPPER_TIMER = 0;
    public static double SAVE_SPEED = 0;

    //motor setup 
    public static final int MOTOR_FL = 11;
    public static final int MOTOR_FR = 12;
    public static final int MOTOR_BL = 21;
    public static final int MOTOR_BR = 22; 

    //shooting motors
    public static final int MOTOR_ST = 31;
    public static final int MOTOR_SB = 32;
    
    
    public static final int MOTOR_HOPPER = 41;
    //public static final int MOTOR_INTAKE = 42;

    public static final int FL_DIST_SENSOR = 2;
    public static final int FR_DIST_SENSOR = 1;
    //public static final int BR_DIST_SENSOR = 0;
    public static final int BAL_DIST_SENSOR = 3;

    public static final int GYRO = 0;
}