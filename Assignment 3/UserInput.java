import java.util.Scanner;

/**
 * 
 * @author hmann
 *
 *         This class offers a shell like command line where the user can run
 *         and stop apps.
 * 
 * @param input is a scanner object that takes an input from the user.
 * @param sys   is a simulated system that the input method interacts with.
 */
public class UserInput {
	private Scanner input = new Scanner(System.in);
	private SimulatedSystem sys;

	public UserInput(SimulatedSystem system) {
		this.sys = system;
	}

	// Main method that collects all the data and interacts with the user.
	public void run() {

		String uInput = commandWriteUp();
		while (!uInput.equals("exit")) {
			while (uInput.length() < 3 && uInput.length() > 4) {
				System.out.println("Please enter the right command.");
				uInput = commandWriteUp();
			}
			String command = uInput.substring(0, 4);
			String applicationName = uInput.substring(4);

			switch (command) {
			case "run ":
				sys.runApp(applicationName, 100);
				break;
			case "stop":
				System.out.println("Stop Working");
				int index = sys.findPosition(applicationName);
				sys.stopApp(index);
				break;
			case "list":
				System.out.println("List Working");
				sys.listApps();
				break;
			default:
				System.out.println("Invalid Command: " + "<" + command + ">");
				break;
			}
			uInput = commandWriteUp();
		}
		input.close();
	}

	// Method that prints out a prompt asking for user input.
	private String commandWriteUp() {
		System.out.print(">Sim ");
		return input.nextLine();
	}

}
