import java.util.ArrayList;
import java.util.Scanner;

public class CreateCommandExecution {
  private ArrayList<Task> taskList;
  private TaskIDManagement taskIDManagement;
  private Time time;

  public CreateCommandExecution(ArrayList<Task> taskList, TaskIDManagement taskIDManagement, Time time) {
    this.taskList = taskList;
    this.taskIDManagement = taskIDManagement;
    this.time = time;
  }

  public String run(Command command) throws InvalidCommandException {
    if (!command.getCommand().equals("create")) {
      throw new IllegalArgumentException("[Create] Cannot run command: " + command.getCommand() + " in CreateCommandExecution");
    }

    String rest = command.getRest();
    Task newTask = this.parseAndRun(rest);

    return String.format("Created Task %d", newTask.getId());
  }

  private Task parseAndRun(String rest) throws InvalidCommandException {
    Scanner lineScanner = new Scanner(rest);
    if (lineScanner.hasNext()) {
      String typeOfTask = lineScanner.next().trim();
      switch (typeOfTask) {
        case "binary":
          return this.createBinaryTask(lineScanner);
        case "percentage":
          return this.createPercentageTask(lineScanner);
        case "due":
          return this.createDueDateTask(lineScanner);
        case "project":
          return this.createProjectTask(lineScanner);
      }
      throw new InvalidCommandException("[Create] Cannot create task of type: " + typeOfTask);
    }
    throw new InvalidCommandException("[Create] No task type specified in create command");
  }

  private Task createProjectTask(Scanner lineScanner) throws InvalidCommandException {
    ArrayList<Integer> taskIds = new ArrayList<>();
    while (lineScanner.hasNextInt()) {
      taskIds.add(lineScanner.nextInt());
    }
    if (!lineScanner.hasNextLine()) {
      throw new InvalidCommandException("[Create] Invalid task name");
    }

    String taskName = lineScanner.nextLine();
    ArrayList<Task> tasks = this.findAllTasks(taskIds);

    Task newTask = new ProjectTask(this.taskIDManagement.vendTaskId(), taskName, tasks);
    this.addParentToTasks(newTask, tasks);
    this.taskList.add(newTask);
    return newTask;
  }

  private void addParentToTasks(Task parent, ArrayList<Task> tasks) {
    for (Task i : tasks) {
      i.addParent(parent);
    }
  }

  private ArrayList<Task> findAllTasks(ArrayList<Integer> taskIds) {
    ArrayList<Task> tasks = new ArrayList<>();
    for (int taskId : taskIds) {
      for (Task t : this.taskList) {
        if (t.getId() == taskId) {
          tasks.add(t);
          break;
        }
      }
    }
    return tasks;
  }

  private BinaryTask createBinaryTask(Scanner lineScanner) throws InvalidCommandException {
    String taskName = lineScanner.nextLine();
    if (this.isValidTaskName(taskName)) {
      BinaryTask newTask = new BinaryTask(this.taskIDManagement.vendTaskId(), taskName);
      taskList.add(newTask);
      return newTask;
    }
    throw new InvalidCommandException("[Create] Invalid task name");
  }

  private PercentageTask createPercentageTask(Scanner lineScanner) throws InvalidCommandException {
    String taskName = lineScanner.nextLine();

    if (this.isValidTaskName(taskName)) {
      PercentageTask newTask = new PercentageTask(this.taskIDManagement.vendTaskId(), taskName);
      taskList.add(newTask);
      return newTask;
    }

    throw new InvalidCommandException("[Create] Invalid task name");
  }

  private boolean isValidTaskName(String taskName) {
    return taskName.trim().length() != 0;
  }

  private DueDateTask createDueDateTask(Scanner lineScanner) throws InvalidCommandException {
    if (!lineScanner.hasNextInt()) {
      throw new InvalidCommandException("[Create->DueDate] Missing due date");
    }

    int due = lineScanner.nextInt();
    String taskName = lineScanner.nextLine();
    if (!this.isValidDueDate(due)) {
      throw new InvalidCommandException("[Create->DueDate] Invalid due date: " + due);
    } else if (!this.isValidTaskName(taskName)) {
      throw new InvalidCommandException("[Create] Invalid task name");
    }

    DueDateTask newTask = new DueDateTask(
        this.taskIDManagement.vendTaskId(),
        taskName,
        this.time.getCurrentTime(),
        due);
    taskList.add(newTask);
    return newTask;
  }

  private boolean isValidDueDate(int due) {
    return due > 0;
  }
}
