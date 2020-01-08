public class BinaryTask extends Task {
  private boolean isCompleted;

  public BinaryTask(int id, String name) {
    super(id, name);
    this.isCompleted = false;
  }

  public void complete(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public double getCompletion(int currentTime) {
    return this.isCompleted ? 1 : 0;
  }

}
