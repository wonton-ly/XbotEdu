package xbot.edubot.subsystems.drive;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.wpi.first.wpilibj.MockDistanceSensor;
import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.injection.wpi_factories.CommonLibFactory;
import xbot.edubot.MockHeadingSensor;

@Singleton
public class DriveSubsystem extends BaseSubsystem {

    public MockDistanceSensor distanceSensor;
    public MockHeadingSensor gyro;
    
    public XCANTalon frontLeft;
    public XCANTalon frontRight;
    public XCANTalon rearLeft;
    public XCANTalon rearRight;

    public boolean precisionMode;
        
    @Inject
    public DriveSubsystem(CommonLibFactory factory) {
        // instantiate speed controllers and sensors here, save them as class members
        distanceSensor = new MockDistanceSensor();
        gyro = new MockHeadingSensor();
        
        frontLeft = factory.createCANTalon(1);
        rearLeft = factory.createCANTalon(3);
        frontRight = factory.createCANTalon(2);
        rearRight = factory.createCANTalon(4);
    }
    
    public void tankDrive(double leftPower, double rightPower) {
        // You'll need to take these power values and assign them to all of the motors. As
        // an example, here is some code that has the frontLeft motor to spin according to
        // the value of leftPower:



        if(precisionMode){
            leftPower /= 2;
            rightPower /= 2;
        }

        
        frontLeft.simpleSet(leftPower);
        rearLeft.simpleSet(leftPower);
        frontRight.simpleSet(rightPower);
        rearRight.simpleSet(rightPower);

    }

    public void arcadeDrive(double xValue, double yValue) {
        /*if(xValue == 0){
            frontLeft.simpleSet(yValue);
            rearLeft.simpleSet(yValue);
            frontRight.simpleSet(yValue);
            rearRight.simpleSet(yValue);
        }
        else if(yValue == 0 && xValue > 0){
            frontLeft.simpleSet(xValue);
            rearLeft.simpleSet(xValue);
            frontRight.simpleSet(xValue * -1);
            rearRight.simpleSet(xValue * -1);
        }
        else if(yValue == 0 && xValue < 0){
            frontLeft.simpleSet(xValue * -1);
            rearLeft.simpleSet(xValue * -1);
            frontRight.simpleSet(xValue);
            rearRight.simpleSet(xValue);
        }
        else if(yValue > 0 && xValue > 0){
            frontLeft.simpleSet(xValue + yValue);
            rearLeft.simpleSet(xValue + yValue);
            frontRight.simpleSet(yValue);
            rearRight.simpleSet(yValue);
        }
        else if(yValue > 0 && xValue < 0){
            frontLeft.simpleSet(yValue);
            rearLeft.simpleSet(yValue);
            frontRight.simpleSet(xValue + yValue);
            rearRight.simpleSet(xValue + yValue);
        }
        else if(yValue < 0 && xValue > 0){
            frontLeft.simpleSet((xValue + yValue) * -1);
            rearLeft.simpleSet((xValue + yValue) * -1);
            frontRight.simpleSet(yValue * -1);
            rearRight.simpleSet(yValue * -1);
        }
        else if(yValue < 0 && xValue < 0){
            frontLeft.simpleSet(yValue * -1);
            rearLeft.simpleSet(yValue * -1);
            frontRight.simpleSet((xValue + yValue) * -1);
            rearRight.simpleSet((xValue + yValue) * -1);
        }
        else{
            frontLeft.simpleSet(0);
            rearLeft.simpleSet(0);
            frontRight.simpleSet(0);
            rearRight.simpleSet(0);
        } */
        double left = xValue + yValue;
        double right = (-1 * xValue) + yValue;
        if(){
            
        }
        else{
            frontLeft.simpleSet(left);
            rearLeft.simpleSet(left);
            frontRight.simpleSet(right);
            rearRight.simpleSet(right);
        }
    }


    public void togglePrecisionMode(){
        if(precisionMode){
            precisionMode = false;
        }
        else{
            precisionMode = true;
        }
    }

}
