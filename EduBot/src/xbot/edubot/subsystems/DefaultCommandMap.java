package xbot.edubot.subsystems;

import xbot.edubot.subsystems.drive.DriveSubsystem;
import xbot.edubot.subsystems.drive.commands.TankDriveWithJoysticksCommand;

import com.google.inject.Inject;

public class DefaultCommandMap {
	
	@Inject
	public DefaultCommandMap(DriveSubsystem drive, TankDriveWithJoysticksCommand driveWithJoysticksCommand) {

	}
}
