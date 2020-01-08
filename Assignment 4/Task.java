import java.util.ArrayList;

/**
 * @author hmann11
 * 
 * 
 *         This is the core class that extends to other task classes and
 *         provides a framework for them.
 * 
 * @param TaskName: Stores the name of the Task
 * @param taskId: Iterates and stores every task with a unique id
 *        chronologically.
 */
public abstract class Task {
	private String taskName;
	private int taskId;

	/*
	 * Main constructor method.
	 */
	public Task(String TaskName) {
		this.taskName = TaskName;
		this.taskId++;
		System.out.println("Task " + taskId + " Created");
	}

	/*
	 * Method to print Tasks in the correct format
	 */
	public String toString() {
		return "Task "+taskId+taskName;
	}
	
	public int getTaskId() {
		return this.taskId;
	}

	public abstract double getCompletion(int currentTime);
}
