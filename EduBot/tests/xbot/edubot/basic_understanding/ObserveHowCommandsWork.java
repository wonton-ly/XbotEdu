package xbot.edubot.basic_understanding;

import org.junit.Test;

import xbot.common.command.XScheduler;
import xbot.common.injection.BaseWPITest;

public class ObserveHowCommandsWork extends BaseWPITest{

	@Test
	public void watch() {
		ExampleCommand cmd = injector.getInstance(ExampleCommand.class);
		
		cmd.start();
		
		XScheduler scheduler = injector.getInstance(XScheduler.class);
		
		for (int i = 0; i < 10; i++) {
			scheduler.run();
		}
	}
}
