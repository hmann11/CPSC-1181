import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListCommandExecution {
  private ArrayList<Task> taskList;

  public ListCommandExecution(ArrayList<Task> taskList) {
    this.taskList = taskList;
  }

  public String run(Command command) throws InvalidCommandException {
    if (!command.getCommand().equals("list")) {
      throw new IllegalArgumentException("Cannot run command: " + command.getCommand() + " in ListCommandExecution");
    }

    Scanner lineScanner = new Scanner(command.getRest());
    if (!ScannerUtil.spaceOrNothing(lineScanner)) {
      String listType = lineScanner.next();
      if (!listType.equals("tree")) {
        throw new InvalidCommandException("[List] Invalid argument to list command: " + listType);
      }
      return this.printTreeList();
    }
    return this.printList();
  }

  private static String printListWithPrefix(String prefix, ArrayList<Task> taskList) {
    String list = "";
    for (Task t : taskList) {
      list += ListCommandExecution.formatTask(t);
    }
    return list.trim();
  }

  private static String formatTask(Task t) {
    return String.format("%d %s\n", t.getId(), t.getName());
  }

  private String printTreeListR(Task task, String prefix) {
    String me = prefix + ListCommandExecution.formatTask(task);
    String subtasks = "";
    if (task instanceof ProjectTask) {
      for (Task c : ((ProjectTask) task).getSubtasks()) {
        subtasks += this.printTreeListR(c, prefix + "  ");
      }
    }

    return me + subtasks;
  }

  private String printList() {
    return ListCommandExecution.printListWithPrefix("", this.taskList);
  }

  private static ArrayList<Task> filterWithoutParent(ArrayList<Task> taskList) {
    ArrayList<Task> withNoParent = new ArrayList<>();
    for (Task t : taskList) {
      if (t.getParents().size() == 0) {
        withNoParent.add(t);
      }
    }
    return withNoParent;
  }

  private String printTreeList() {
    ArrayList<Task> withNoParent = filterWithoutParent(this.taskList);
    String output = "";
    for (Task t : withNoParent) {
      output += this.printTreeListR(t, "");
    }
    return output.trim();
  }
}
