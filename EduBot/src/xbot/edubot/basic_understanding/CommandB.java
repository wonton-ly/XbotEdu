package xbot.edubot.basic_understanding;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;

public class CommandB extends BaseCommand {

	@Inject
	public CommandB(ExampleSubsystem exampleSubsystem) {
		requires(exampleSubsystem);
	}
	@Override
	public void initialize() {
		log.info("Initializing!");
	}

	@Override
	public void execute() {
		log.info("COMMAND B IS THE BEST!!!");
	}

}
