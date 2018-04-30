package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.Drivetrain;
import org.usfirst.frc.team5895.robot.Intake;
import org.usfirst.frc.team5895.robot.framework.Waiter;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * center of field, right switch
 */
public class CR0 {
	
	public static final void run(Drivetrain drive, Intake intake) {
		
		drive.resetNavX();
		intake.intake();
		
		intake.down();
		drive.autoCenterRightSwitchFront();
		Waiter.waitFor(drive::isPFinished,4000);
		drive.arcadeDrive(0, 0);
		intake.ejectSlow();
		drive.autoBackwards();
		
		Waiter.waitFor(drive::isPFinished, 2000);
		drive.arcadeDrive(0, 0);
		drive.turnTo(-60);
		Waiter.waitFor(drive::atAngle, 2000);
		drive.arcadeDrive(0, 0);
		intake.intake();
		drive.autoCenterRightSwitchCube();
		Waiter.waitFor(drive::isPFinished, 2000);
		drive.arcadeDrive(0, 0);
		Waiter.waitFor(200);
		drive.autoCenterRightSwitchRev();
		Waiter.waitFor(drive::isPFinished, 2000);
		
		drive.arcadeDrive(0, 0);
		drive.turnTo(0);
		DriverStation.reportError("" + drive.getAngle(), false);
		Waiter.waitFor(drive::atAngle, 2000);
		drive.arcadeDrive(0, 0);
		drive.arcadeDrive(-0.5, 0);
		Waiter.waitFor(550);
		drive.arcadeDrive(0, 0);
		intake.ejectSlow();
		drive.autoBackwards();
		
		Waiter.waitFor(drive::isPFinished, 2000);
		drive.arcadeDrive(0, 0);
		drive.turnTo(-60);
		Waiter.waitFor(drive::atAngle, 2000);
		drive.arcadeDrive(0, 0);
		intake.intake();
		drive.autoCenterRightSwitchCube();
		Waiter.waitFor(drive::isPFinished, 2000);
		drive.arcadeDrive(0, 0);
	}

}
