/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.AutoAlignCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Subsystem init
  public static DriveSubsystem driveSubsystem;
  public static ShooterSubsystem shooterSubsystem;
  public static IntakeSubsystem intakeSubsystem;

  //Command init
  public static DriveCommand driveCommand;
  public static ShooterCommand shooterCommand;
  public static HopperCommand hopperCommand;
  public static IntakeCommand intakeCommand;
  public static AutonomousCommand autonomousCommand;
  public static AutoAlignCommand autoAligncommand;

//OI init
  public static OI oi;

  //ultrasonic init
  public static AnalogPotentiometer flDist = new AnalogPotentiometer(RobotMap.FL_DIST_SENSOR);
  public static AnalogPotentiometer frDist = new AnalogPotentiometer(RobotMap.FR_DIST_SENSOR);
  public static AnalogPotentiometer brDist = new AnalogPotentiometer(RobotMap.BR_DIST_SENSOR);
  public static AnalogPotentiometer balDist = new AnalogPotentiometer(RobotMap.BAL_DIST_SENSOR);

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static String choice;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    

    driveSubsystem = new DriveSubsystem();
    shooterSubsystem = new ShooterSubsystem();
    intakeSubsystem = new IntakeSubsystem();

    driveCommand = new DriveCommand();
    shooterCommand = new ShooterCommand();
    hopperCommand = new HopperCommand();
    intakeCommand = new IntakeCommand();
    autonomousCommand = new AutonomousCommand();
    autoAligncommand = new AutoAlignCommand();


    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();

    autonomousCommand.timer =0;

    oi = new OI();

    //sets the ultrasonic to auto
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
   // System.out.println("robot");
<<<<<<< HEAD
<<<<<<< HEAD

   choice = m_chooser.getSelected();
=======
>>>>>>> master
=======
   choice = m_chooser.getSelected();
>>>>>>> master
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_chooser.setDefaultOption("auto mode 1", "one");
    m_chooser.addOption("auto mode 2", "two");
    SmartDashboard.putData("Autonomous mode options", m_chooser);
    System.out.println("Auto selected: " + m_autoSelected);

    driveSubsystem.flEnc.setPosition(0);
    autonomousCommand.timer = 0;
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    hopperCommand.execute();
    autonomousCommand.execute();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    driveCommand.execute();
<<<<<<< HEAD
<<<<<<< HEAD
    //shooterCommand.execute();
=======
>>>>>>> master
=======
>>>>>>> master
    shooterCommand.execute();
    intakeCommand.execute();
    hopperCommand.execute();
    oi.stickUpdate();
<<<<<<< HEAD
<<<<<<< HEAD
    autoAligncommand.execute();
=======
>>>>>>> master
=======
    autoAligncommand.execute();
>>>>>>> master
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}