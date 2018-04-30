package org.usfirst.frc.team5895.robot.auto;

import org.usfirst.frc.team5895.robot.Drivetrain;
import org.usfirst.frc.team5895.robot.Intake;
import org.usfirst.frc.team5895.robot.framework.Waiter;
/**
 * center of field, right switch, & right scale.
 * @author lalewis-19
 */
public class CRR {
	
	public static final void run(Drivetrain drive, Intake intake) {
		
		drive.resetNavX();
		intake.intake();
		Waiter.waitFor(200);
		drive.autoCenterRightScale();
		Waiter.waitFor(1000);
		Waiter.waitFor(drive::isPFinished, 2500);
		intake.ejectSlow();
		Waiter.waitFor(500);
		drive.turnTo(210);
		Waiter.waitFor(drive::atAngle, 3000);
		drive.stopTurning(); 
		drive.arcadeDrive(0, 0);
		Waiter.waitFor(500);
		drive.arcadeDrive(0.1, 0);
		Waiter.waitFor(500);
		drive.arcadeDrive(0, 0);
		Waiter.waitFor(2000);
		intake.ejectFast();
		
	}

}
