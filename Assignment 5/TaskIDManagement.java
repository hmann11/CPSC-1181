public class TaskIDManagement {
  private int lastTaskId = 1;

  public int lastTaskId() {
    return this.lastTaskId;
  }

  public int vendTaskId() {
    return this.lastTaskId++;
  }
}
