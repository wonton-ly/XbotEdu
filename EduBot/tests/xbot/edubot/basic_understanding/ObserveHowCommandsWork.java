package xbot.edubot.basic_understanding;

import org.junit.Test;

import xbot.common.command.XScheduler;
import xbot.common.injection.BaseWPITest;

public class ObserveHowCommandsWork extends BaseWPITest{

	@Test
	public void watchExample() {
		// This is a simple command that just prints out what methods are called on it.
		ExampleCommand cmd = injector.getInstance(ExampleCommand.class);
		
		// There's many ways to start commands. Typically, they are started by pressing a joystick
		// button, but for testing we can just force it to start.
		cmd.start();
		
		// The Scheduler is an entity that looks at all "Started commands" and runs them until:
		// - the command says it is done
		// - some other command starts that wants to use the same subsystem
		XScheduler scheduler = injector.getInstance(XScheduler.class);
		
		// For a quick example, we'll just run the scheduler 10 times.
		for (int i = 0; i < 10; i++) {
			scheduler.run();
		}
	}
	
	@Test
	public void watchChatter() {
		ChatCommandThatEnds cmd = injector.getInstance(ChatCommandThatEnds.class);
		cmd.start();
		XScheduler scheduler = injector.getInstance(XScheduler.class);
		
		for (int i = 0; i < 100; i++) {
			
			if (i % 10 == 0) 
			{
				System.out.println("Scheduler on loop" + i);
			}
			
			scheduler.run();
		}
	}
	
	@Test
	public void watchCommandsFight() {
		CommandA cmda = injector.getInstance(CommandA.class);
		CommandB cmdb = injector.getInstance(CommandB.class);
		
		// CommandA starts. 
		cmda.start();
		
		XScheduler scheduler = injector.getInstance(XScheduler.class);
		
		for (int i = 0; i < 5; i++) {
			scheduler.run();
		}
		
		// Now we start CommandB. When you run this test, observe
		// that CommandA is no longer running!
		
		cmdb.start();
		
		for (int i = 0; i < 5; i++) {
			scheduler.run();
		}
	}
}
