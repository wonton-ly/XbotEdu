package xbot.edubot.subsystems.drive.commands;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;
import xbot.edubot.subsystems.drive.DriveSubsystem;

public class DriveToOrientationCommand extends BaseCommand{
    
    DriveSubsystem drive;
    double targetYaw;
    double initialYaw;
    double curYaw;
    double oldYaw;
    double turnclockwise;
    double firstDistance;
    double secondDistance;
    double yawAway;
    boolean goClockWise;


    @Inject
    public DriveToOrientationCommand(DriveSubsystem driveSubsystem) {
        this.drive = driveSubsystem;
    }
    
    public void setTargetHeading(double heading) {
        // This method will be called by the test, and will give you a goal heading.
        // You'll need to remember this target position and use it in your calculations.
        targetYaw = heading;

    }
    
    public static double getDistance(double initialYaw, double targetYaw){
        double firstDistance = (targetYaw) - (initialYaw);
        double secondDistance = 0;
        if(firstDistance < 0){
             secondDistance = 360 - (Math.abs(firstDistance));
            if(Math.abs(firstDistance) < secondDistance){
                return firstDistance;
            }
            else{
                return secondDistance;
            }
        }
        else{
            secondDistance = 360 - (Math.abs(firstDistance));
            if(Math.abs(firstDistance) < secondDistance){
                return firstDistance;
            }
            else{
                return secondDistance;
            }
        }
        
    }

    @Override
    public void initialize() {
        // If you have some one-time setup, do it here.
        initialYaw = drive.gyro.getYaw();
        oldYaw = 0;
        
        // clockwiseDistance = targetYaw - initialYaw;
        // counterDistance = 360 - clockwiseDistance;
        // if(clockwiseDistance < counterDistance){
        //     goClockWise = true;
        // }
        // goClockWise = false;

        // firstDistance = targetYaw - initialYaw;
        // if(firstDistance < 0){
        //     secondDistance = 360 - (Math.abs(firstDistance));
        //     if(Math.abs(firstDistance) < secondDistance){
        //         goClockWise = true;
        //     }
        //     else{
        //         goClockWise = false;
        //     }
        // }
        // else{
        //     secondDistance = 360 - (Math.abs(firstDistance)) * -1;
        //     if(Math.abs(firstDistance) < secondDistance){
        //         goClockWise = false;
        //     }
        //     else{
        //         goClockWise = true;
        //     }
        // }
  


        if(targetYaw > 180){
            double x = 180 - initialYaw;
            double y = (targetYaw - initialYaw) - x;
            targetYaw = (180 - y) * -1;
        }
 

    }

    @Override
    public void execute() {
        // Here you'll need to figure out a technique that:
        // - Gets the robot to turn to the target orientation
        // - Gets the robot stop (or at least be moving really really slowly) at the target position
        
        // How you do this is up to you. If you get stuck, ask a mentor or student for some hints!
        

        curYaw = drive.gyro.getYaw();
        yawAway = getDistance(initialYaw, targetYaw);

        double error = yawAway;
        double speed = curYaw - oldYaw;
        oldYaw = curYaw;
        //0.08 . 551
        double finalPower = (error * 0.08) - (speed * .551);

        drive.tankDrive(-finalPower, finalPower);
        
    }

    @Override
    public boolean isFinished() {
        // Modify this to return true once you have met your goal, 
        // and you're moving fairly slowly (ideally stopped)
        if(Math.abs(drive.gyro.getYaw() - targetYaw) <= 0.025){
            return true;
        }
        return false;
    }
}
