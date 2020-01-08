import java.util.ArrayList;
import java.util.Scanner;

public class CompleteCommandExecution {
  private ArrayList<Task> taskList;
  private Time time;

  public CompleteCommandExecution(ArrayList<Task> taskList, Time time) {
    this.taskList = taskList;
    this.time = time;
  }

  public String run(Command command) throws InvalidCommandException {
    if (!command.getCommand().equals("complete")) {
      throw new IllegalArgumentException("Cannot run command: " + command.getCommand() + " in CompleteCommandExecution");
    }

    String rest = command.getRest();
    String output = this.parseAndRun(rest);

    return output;
  }

  private String parseAndRun(String rest) throws InvalidCommandException {
    Scanner lineScanner = new Scanner(rest);
    if (lineScanner.hasNextInt()) {
      int taskId = lineScanner.nextInt();
      Task targetTask = this.findTask(taskId);
      if (targetTask == null) {
        // If the taskId is not defined, we stay silent
        return "";
      }

      // Check if we are at EOL or only spaces after
      if (!lineScanner.hasNextLine() || lineScanner.hasNext("\\s+")) {
        return "" + targetTask.getCompletion(this.time.getCurrentTime());
      }

      if (targetTask instanceof ProjectTask) {
        throw new InvalidCommandException("[Complete] Cannot complete task of id: " + taskId);
      }

      if (targetTask instanceof BinaryTask) {
        this.completeBinaryTask((BinaryTask) targetTask, lineScanner);
      } else if (targetTask instanceof PercentageTask) {
        this.completePercentageTask((PercentageTask) targetTask, lineScanner);
      } else if (targetTask instanceof DueDateTask) {
        this.completeDueDateTask((DueDateTask) targetTask, lineScanner);
      }

      // Stay silent after completing a task
      return "";
    }
    throw new InvalidCommandException("[Complete] No task type specified in complete command");
  }

  private Task findTask(int taskId) {
    Task target = null;
    for (Task t : this.taskList) {
      if (t.getId() == taskId) {
        target = t;
      }
    }
    return target;
  }

  private void completeBinaryTask(BinaryTask task, Scanner lineScanner) throws InvalidCommandException {
    // lineScanner has non-space characters
    String argument = lineScanner.next();

    if (argument.equals("completed")) {
      task.complete(true);
    } else if (argument.equals("notcompleted")) {
      task.complete(false);
    } else {
      throw new InvalidCommandException("[Complete->Binary] Invalid argument: " + argument);
    }
  }

  private void completePercentageTask(PercentageTask task, Scanner lineScanner) throws InvalidCommandException {
    if (!lineScanner.hasNextDouble()) {
      throw new InvalidCommandException("[Complete->Percentage] Invalid argument");
    }

    double n = lineScanner.nextDouble();
    double percent = n > 1
        ? 1
        : n < 0
        ? 0 : n;

    task.setPercentCompleted(percent);
  }

  private void completeDueDateTask(DueDateTask task, Scanner lineScanner) throws InvalidCommandException {
    if (!lineScanner.hasNextInt()) {
      throw new InvalidCommandException("[Complete->DueDate] Invalid argument");
    }

    int due = lineScanner.nextInt();
    if (due < 0) {
      throw new InvalidCommandException("[Complete->DueDate] Invalid due date: " + due);
    }

    task.setDueDate(due);
  }

  private boolean isValidDueDate(int due) {
    return due >= this.time.getCurrentTime();
  }
}
