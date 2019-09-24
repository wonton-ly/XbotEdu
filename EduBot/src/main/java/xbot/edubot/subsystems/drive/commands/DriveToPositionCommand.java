package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class DriveToPositionCommand extends BaseCommand {

    DriveSubsystem drive;
    public double targetPosition;
    double power;
    double curPosition;
    double distAway;
    double oldDistance;
    double speed;
    double finalPower;
   
    
    @Inject
    public DriveToPositionCommand(DriveSubsystem driveSubsystem) {
        this.drive = driveSubsystem;
        power = 1;
        speed = 1;
        oldDistance = 0;
        
    }
    
    public void setTargetPosition(double position) {
        // This method will be called by the test, and will give you a goal distance.
        // You'll need to remember this target position and use it in your calculations.
        targetPosition = position;
    }
    
    @Override
    public void initialize() {
        // If you have some one-time setup, do it here.
    }

    @Override
    public void execute() {
        // Here you'll need to figure out a technique that:
        // - Gets the robot to move to the target position 
        // - Hint: use drive.distanceSensor.get() to find out where you are
        // - Gets the robot stop (or at least be moving really really slowly) at the target position
        
        // How you do this is up to you. If you get stuck, ask a mentor or student for some hints!
        
        /*speed = 1;
        if(drive.distanceSensor.getDistance() == 0.5*targetPosition || drive.distanceSensor.getDistance() > 0.5*targetPosition){
            drive.tankDrive(-.765,-.765);
        }
        if(drive.distanceSensor.getDistance() > targetPosition && drive.distanceSensor.getDistance() <  targetPosition + .3 || drive.distanceSensor.getDistance() < targetPosition && drive.distanceSensor.getDistance() > targetPosition - .3){
            speed = 0;
        }
        drive.tankDrive(speed, speed);
        */

        double distance = drive.distanceSensor.getDistance();
        curPosition = drive.distanceSensor.getDistance();
        distAway = targetPosition - curPosition;
        power = distAway/targetPosition;
        speed = distance - oldDistance;
        oldDistance = distance;
        finalPower = (power * 4.5) - (speed * 4.5); 
        drive.tankDrive(finalPower, finalPower);
        
    }
    
    @Override
    public boolean isFinished() {
        // Modify this to return true once you have met your goal, 
        // and you're moving fairly slowly (ideally stopped)
        if(Math.abs(drive.distanceSensor.getDistance() - targetPosition) <= 0.2){
            return true;
        }
        return false;
    }

}
