package xbot.edubot.subsystems.arm;

import xbot.common.controls.actuators.XSpeedController;
import xbot.common.controls.sensors.XDigitalInput;
import xbot.common.injection.wpi_factories.WPIFactory;

import com.google.inject.Inject;

import edu.wpi.first.wpilibj.SpeedController;

public class ArmSubsystem {
	
	public XSpeedController armMotor;
	public XDigitalInput upperLimitSwitch, lowerLimitSwitch;
	
	@Inject
	public ArmSubsystem(WPIFactory factory) {
		armMotor = factory.getSpeedController(5);
		
		upperLimitSwitch = factory.getDigitalInput(0);
		lowerLimitSwitch = factory.getDigitalInput(1);
	}

}
