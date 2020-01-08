import java.util.Scanner;
/**
 * 
 * @author hmann11
 *
 *This method handles all the logic involved in taking in the user's command and handling the seperate outcomes.
 *
 *@param input is a Scanner object that takes in the user's input.
 *@param parser is a CommandParser object that parses the commands passed by the user and makes sense of it.
 *@param executer is a CommandExecution object that does most of the heavy lifting and puts the tasks into a list.
 */
public class UserInput {
	private Scanner input = new Scanner(System.in);
	private CommandParser parser = new CommandParser();
	private CommandExecution executer = new CommandExecution();

	public UserInput() {
	}

	public void run() {
		String uInput = input.nextLine();
		while (!uInput.equals("exit")) {
			
			if (parser.parse(uInput) == null) {
				System.out.println("Invalid Command: " + uInput);
			} else {
				executer.execute(parser.parse(uInput));
			}
			System.out.print(">");
			uInput = input.nextLine();
		}
		input.close();
	}
}
