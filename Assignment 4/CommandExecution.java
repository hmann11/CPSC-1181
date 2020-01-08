import java.util.Scanner;

/**
 * 
 * @author hmann11
 * 
 *         This class does the bulk of the program's processing, it takes the
 *         user's input and separates the command from the body or argument of
 *         the input. Then it uses this command to further separate the inputs
 *         on their function. For example starting with the create command it
 *         separates the kind of task (binary,percentage,due date) and calls the
 *         appropriate method and stores the resulting class in a ArrayList.
 * 
 * @param intScan       is a scanner that looks for integers in an input using a
 *                      delimiter.
 * @param tl1           is a ArrayList the saves the tasks.
 * @param t1            Stores a integer value representing time, 0 by default.
 * @param typeOfCommand saves the type of task a command has.
 *
 */
public class CommandExecution {
	TaskList tl1 = new TaskList();
	Time t1 = new Time();

	public void execute(CommandParser.ParsedCommand Command) {
		Task[] list = tl1.getTasks();
		Scanner intScan = new Scanner(Command.arguments).useDelimiter("[^0-9]+");
		String typeOfCommand = Command.arguments;
		// This switch iterates through the primary commands and creates reposes.
		switch (Command.command) {
		case "create":
			// This switch goes through the type of task types and creates new ones
			// accordingly.

			switch (typeOfTask(typeOfCommand)) {
			case "binary":
				tl1.addTask(new BinaryTask(taskDetails(typeOfCommand), 0));
				break;
			case "percentage":
				tl1.addTask(new PercentageTask(taskDetails(typeOfCommand), 0));
				break;
			case "due":
				tl1.addTask(new DueDateTask(taskDetails(typeOfCommand), 1, intScan.nextInt()));
				break;
			case "project":
				tl1.addTask(new ProjectTask(taskDetails(typeOfCommand)));
				break;
			default:
				System.out.println(typeOfCommand + " Invalid Input");
				break;
			}
			break;

		// This section handles the logic for completion.
		case "complete":
			int taskId = Integer.parseInt(typeOfTask(Command.arguments));
			int taskLocation;
			for (int i = 0; i < tl1.size(); i++) {
				if (taskId == list[i].getTaskId()) {
					taskLocation = i;
				}
			}
			break;
		case "time":
			switch (Command.arguments) {
			case "":
				System.out.println(t1.getCurrentTime());
				break;
			default:
				t1.setCurrentTime(Integer.parseInt(Command.arguments));
				break;
			}
			break;
		// This prints out all the currently running tasks.
		case "list":
			for (Task s : list) {
				System.out.println(s.toString());
			}
			break;
		}
		intScan.close();
	}
	/*
	 * This method shortens the Command String and returns the type of task it present, i.e. create,complete etc
	 */
	private String typeOfTask(String Command) {
		System.out.println(CommandParser.findSpace(Command));
		String typeOfTask = Command.substring(0, CommandParser.findSpace(Command));
		System.out.println(typeOfTask + " this the name of the task");
		return typeOfTask;
	}
	/*
	 * This method returns the type of task that needs to be created i.e. binary,percentage etc.
	 */
	private String taskDetails(String typeOfCommand) {
		return typeOfCommand.substring(CommandParser.findSpace(typeOfCommand), typeOfCommand.length());
	}
}
