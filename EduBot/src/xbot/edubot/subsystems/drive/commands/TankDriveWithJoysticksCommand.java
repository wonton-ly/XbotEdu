package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.operator_interface.OperatorInterface;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TankDriveWithJoysticksCommand extends BaseCommand {

	DriveSubsystem drive;
	OperatorInterface operate;
	
	@Inject
	public TankDriveWithJoysticksCommand(DriveSubsystem driveSubsystem, OperatorInterface oi) {
		drive = driveSubsystem;
		operate = oi;
	}
	
	@Override
	public void initialize() {
		// This code is run one time, right when the command is started.
		// You don't need to write any code here for this exercise.
	}

	@Override
	public void execute() {
		// You need to get values from the joysticks and pass them into the motors. Here's how to get 
		// how far the left joystick's Y-axis is pushed:
		
		double leftValue = operate.leftJoystick.getVector().y;
		
	}

}
