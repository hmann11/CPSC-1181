import java.util.Scanner;

public class UserInput {
  private ICommandExecution commandExecution;
  private Scanner inputScanner;
  private ICommandParser parser;
  private Log logger;

  public UserInput(Scanner inputScanner, ICommandParser parser, ICommandExecution commandExecution, Log logger) {
    this.inputScanner = inputScanner;
    this.parser = parser;
    this.commandExecution = commandExecution;
    this.logger = logger;
  }

  public void run() {
    System.out.print("> ");
    while (this.inputScanner.hasNextLine()) {
      String line = this.inputScanner.nextLine();
      try {
        Command command = this.parser.parse(line);
        if (command.getCommand().equals("exit")) {
          return;
        }

        String output = this.commandExecution.runCommand(command);
        if (output.length() > 0) {
          System.out.println(output);
        }

      } catch (InvalidCommandException e) {
        this.logger.debug(e.getMessage() + "\n" + "    " + e.getStackTrace()[0].toString());
        System.out.printf("Invalid command: \"%s\"\n", line);
      }
      System.out.print("> ");
    }
  }
}
