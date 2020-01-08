import java.util.ArrayList;
import java.util.Scanner;

public class RunSystem {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in);) {
      Log log = new Log(Log.ERROR);

      Time time = new Time();
      ICommandParser commandParser = new CommandParser();

      ArrayList<Task> taskList = new ArrayList<>();
      TaskIDManagement taskIDManagement = new TaskIDManagement();
      CreateCommandExecution createCommandExecution = new CreateCommandExecution(taskList, taskIDManagement, time);
      CompleteCommandExecution completeCommandExecution = new CompleteCommandExecution(taskList, time);
      ListCommandExecution listCommandExecution = new ListCommandExecution(taskList);
      FileSaving fileHandler=new FileSaving(taskList,time);// Instantiated FileSaving Handler.
      FileLoading fileLoader=new FileLoading(taskList);
      ICommandExecution commandExecution = new CommandExecution(
          time,
          createCommandExecution,
          completeCommandExecution,
          listCommandExecution,
          fileHandler,
          fileLoader);
      UserInput userInput = new UserInput(scanner, commandParser, commandExecution, log);
      userInput.run();
    }
  }
}
