public class PercentageTask extends Task {
  private double percentCompleted;

  public PercentageTask(int id, String name) {
    super(id, name);
    this.percentCompleted = 0;
  }

  public double getCompletion(int currentTime) {
    return this.percentCompleted;
  }

  public void setPercentCompleted(double percentCompleted) {
    this.percentCompleted = percentCompleted;
  }
}
