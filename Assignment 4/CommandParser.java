/**
 * 
 * @author hmann11
 * 
 *         This method handles making sense of the user's input.
 *
 * @param command   stores the command related to the user's input i.e. create,
 *                  list etc.
 * @param arguments stores anything that command doesn't like the type of task
 *                  to create and it's name.
 */
public class CommandParser {
	public class ParsedCommand {
		public String command;
		public String arguments;
	}

	/*
	 * @param firstspace saves the location of the first space character in a String
	 * which is used to manipulate the command.
	 * 
	 */
	public ParsedCommand parse(String line) {
		int firstSpace = findSpace(line);
		String actualCommand;
		String potentialCommand = line;
		if (findSpace(line) != 0) {
			potentialCommand = line.substring(0, firstSpace);
		}
		switch (potentialCommand) {
		case "create":
			actualCommand = potentialCommand;
			break;
		case "complete":
			actualCommand = potentialCommand;
			break;
		case "list":
			actualCommand = potentialCommand;
			break;
		case "time":
			actualCommand = potentialCommand;
			break;
		case "exit":
			actualCommand = potentialCommand;
			break;
		default:
			return null;
		}
		ParsedCommand parsed = new ParsedCommand();// Parsed Command is a command processed by the parser that is ready
													// to be executed.
		parsed.command = actualCommand;
		parsed.arguments = line.substring(firstSpace + 1, line.length());
		return parsed;
	}

	/*
	 * Helper method to find the first space in a given string and return it's
	 * location.
	 */
	public static int findSpace(String line) {
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ') {
				return i;
			}
		}
		return 0;
	}
}
