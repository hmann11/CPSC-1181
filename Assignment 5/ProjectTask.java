import java.util.ArrayList;

public class ProjectTask extends Task {
  private ArrayList<Task> subtasks;

  public ProjectTask(int id, String name, ArrayList<Task> subtasks) {
    super(id, name);
    this.subtasks = subtasks;
  }

  public double getCompletion(int currentTime) {
    if (subtasks.size() > 0) {
      return this.averageCompletion(subtasks, currentTime);
    }
    return 0;
  }

  public ArrayList<Task> getSubtasks() {
    return subtasks;
  }

  private double averageCompletion(ArrayList<Task> subtasks, int currentTime) {
    double total = 0;
    for (Task t: subtasks) {
      total += t.getCompletion(currentTime);
    }
    return total / subtasks.size();
  }
}
