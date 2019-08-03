package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.operator_interface.OperatorInterface;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {
    DriveSubsystem drive;
    OperatorInterface operate;

    @Inject
    public ArcadeDriveWithJoysticksCommand(DriveSubsystem driveSubsystem, OperatorInterface oi) {
        drive = driveSubsystem;
        operate = oi;
        this.requires(drive);
    }
    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        double yValue = operate.gamepad.getLeftVector().y;
        double xValue = operate.gamepad.getLeftVector().x;
        drive.arcadeDrive(xValue, yValue);
    }

}
