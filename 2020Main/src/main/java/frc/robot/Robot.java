/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.AutoAlignCommand;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.HopperCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
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
  public static AutoAlignCommand autoAlignCommand;

//OI init
  public static OI oi;

  //ultrasonic init
  public static AnalogInput balDist = new AnalogInput(RobotMap.BAL_DIST_SENSOR);
  public static AnalogInput flDist = new AnalogInput(RobotMap.FL_DIST_SENSOR);
  public static AnalogInput frDist = new AnalogInput(RobotMap.FR_DIST_SENSOR);
  public static AnalogInput brDist = new AnalogInput(RobotMap.BR_DIST_SENSOR);

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

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
    autoAlignCommand = new AutoAlignCommand();


    CameraServer.getInstance().startAutomaticCapture();

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    oi = new OI();

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
    m_autoSelected = m_chooser.getSelected();
    m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
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
    if(OI.shootButton.get()){
      shooterCommand.execute();
    }
    intakeCommand.execute();
    hopperCommand.execute();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
