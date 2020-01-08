/**
 * 
 * @author hmann11
 * 
 * This class handles due date task inputs.
 * 
 * @param startDate: Stores the starting date of a task.
 * @param dueDate: Stores the due date for a task.
 *
 */
public class DueDateTask extends Task {
	private int startDate;
	private int dueDate;

	public DueDateTask(String TaskName, int startDate, int dueDate) {
		super(TaskName);
		this.startDate = startDate;
		this.dueDate = dueDate;
	}

	public double getCompletion(int currentTime) {
		return 0;
	}
}
