package xbot.edubot.basic_understanding;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;

public class CommandA extends BaseCommand {

	@Inject
	public CommandA(ExampleSubsystem exampleSubsystem) {
		requires(exampleSubsystem);
	}
	
	@Override
	public void initialize() {
		log.info("Initializing!");
	}

	@Override
	public void execute() {
		log.info("CommandA is the best.");
	}

}
