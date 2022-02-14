//Pulls in entire intake mechanism into the chasis

package frc.robot.commands;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Rotate_Intake_In extends CommandBase {
  public Rotate_Intake_In() {
    addRequirements(RobotContainer.RotIntk);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.RotIntk.rotIntkIn();
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.RotIntk.rotIntkOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.RotIntk.bot_limit.get();
  }
}