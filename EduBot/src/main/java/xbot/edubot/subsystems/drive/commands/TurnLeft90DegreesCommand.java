package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class TurnLeft90DegreesCommand extends BaseCommand {
    
    DriveSubsystem drive;
    double targetYaw;
    double initialYaw;
    double curYaw;
    double oldYaw;

    @Inject
    public TurnLeft90DegreesCommand(DriveSubsystem driveSubsystem) {
        this.drive = driveSubsystem;
    }
    
    @Override
    public void initialize() {
        initialYaw = drive.gyro.getYaw();
        targetYaw = initialYaw + 90;
        oldYaw = 0;

        if(targetYaw > 180){
            double x = 180 - initialYaw;
            double y = 90 - x;
            targetYaw = (180 - y) * -1;
        }
    }

    @Override
    public void execute() {

        curYaw = drive.gyro.getYaw();
        double yawAway = Math.abs(targetYaw - curYaw);
        double error = yawAway;
        double speed = curYaw - oldYaw;
        oldYaw = curYaw;
        //0.08 . 551
        double finalPower = (error * 0.08) - (speed * .551);
        drive.tankDrive(-finalPower, finalPower);
    }

    public boolean isFinished() {
        if(Math.abs(drive.gyro.getYaw() - targetYaw) <= 0.025){
            return true;
        }
        return false;
    }



}
