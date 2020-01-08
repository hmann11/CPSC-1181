import java.util.Scanner;

public class CommandExecution implements ICommandExecution {
	private CompleteCommandExecution completeCommandExecution;
	private Time time;
	private CreateCommandExecution createCommandExecution;
	private ListCommandExecution listCommandExecution;
	private FileSaving fileHandler;
	private FileLoading fileLoader;

	public CommandExecution(Time time, CreateCommandExecution createCommandExecution,
			CompleteCommandExecution completeCommandExecution, ListCommandExecution listCommandExecution,
			FileSaving fileHandler, FileLoading fileLoader) {
		this.time = time;
		this.createCommandExecution = createCommandExecution;
		this.completeCommandExecution = completeCommandExecution;
		this.listCommandExecution = listCommandExecution;
		this.fileHandler = fileHandler;
		this.fileLoader=fileLoader;
	}

	public String runCommand(Command command) throws InvalidCommandException {
		switch (command.getCommand()) {
		case "list":
			return this.runListCommand(command);
		case "create":
			return this.runCreateCommand(command);
		case "complete":
			return this.runCompleteCommand(command);
		case "time":
			return this.runTimeCommand(command);

		// Case that Calls the save Command.
		case "save":
			return this.runSaveCommand(command);

		// Case that calls the load Command.
		case "load":
			return this.runLoadCommand(command);
		}
		return null;
	}

	private String runLoadCommand(Command command) {
		return this.fileLoader.run(command);
	}

	// Last step of the saving carried out here, for further details go to the
	// FileSaving Class.
	private String runSaveCommand(Command command) {
		return this.fileHandler.run(command);
	}

	private String runTimeCommand(Command command) throws InvalidCommandException {
		Scanner in = new Scanner(command.getRest());
		if (in.hasNextInt()) {
			int newTime = in.nextInt();
			// Negative case falls through to throw InvalidCommandException
			if (newTime >= 0) {
				this.time.setCurrentTime(newTime);
				return "";
			}
		} else if (!in.hasNext()) {
			return "" + this.time.getCurrentTime();
		}
		throw new InvalidCommandException("Time command expects nothing or integer argument");
	}

	private String runCompleteCommand(Command command) throws InvalidCommandException {
		return this.completeCommandExecution.run(command);
	}

	private String runCreateCommand(Command command) throws InvalidCommandException {
		return this.createCommandExecution.run(command);
	}

	private String runListCommand(Command command) throws InvalidCommandException {
		return this.listCommandExecution.run(command);
	}
}
