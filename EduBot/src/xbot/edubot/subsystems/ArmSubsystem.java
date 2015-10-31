package xbot.edubot.subsystems;

import xbot.common.controls.actuators.XSpeedController;
import xbot.common.controls.sensors.XDigitalInput;
import xbot.edubot.RobotMap;

import com.google.inject.Inject;

import edu.wpi.first.wpilibj.SpeedController;

public class ArmSubsystem {
	
	public XSpeedController armMotor;
	public XDigitalInput upperLimitSwitch, lowerLimitSwitch;
	
	@Inject
	public ArmSubsystem(RobotMap robotMap) {
		upperLimitSwitch = robotMap.upperLimitSwitch;
		lowerLimitSwitch = robotMap.lowerLimitSwitch;
		
		armMotor = robotMap.arm;
	}

}
