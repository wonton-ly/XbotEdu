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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
