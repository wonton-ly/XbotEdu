package xbot.edubot.basic_understanding;

import xbot.common.command.BaseCommand;

public class ExampleCommand extends BaseCommand {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		log.info("Initializing!");
	}

	@Override
	public void execute() {
		log.info("Executing.");
	}
	
	@Override
	public boolean isFinished() {
		log.info("Checking isFinished.");
		return super.isFinished();
	}
	
	
}
