public class DueDateTask extends Task {
  private int start;
  private int due;

  public DueDateTask(int id, String name, int start, int due) {
    super(id, name);
    this.start = start;
    this.due = due;
  }

  public void setDueDate(int due) {
    this.due = due;
  }
  
  public int getDueDate() {
	  return due;
  }
  public int getStartDate() {
	  return start;
  }

  public double getCompletion(int current) {
    double p = ((double) current - this.start) / (this.due - this.start);
    return p > 1
        ? 1
        : p < 0
        ? 0
        : p;
  }
}
