package xbot.edubot.rotation;

import org.junit.Test;

import xbot.edubot.engines.RotationEngine;
import xbot.edubot.subsystems.drive.commands.DriveToOrientationCommand;

public class GoToOrientationTest extends BaseOrientationEngineTest {
	
	@Test
	public void testGoToOrientation()
	{
        DriveToOrientationCommand command = 
            injector.getInstance(DriveToOrientationCommand.class);
        command.setTargetHeading(150);
        
	    setUpTestEnvironment(command, 0, 150);
	    runTestEnv();
	}
}
