import java.util.ArrayList;

/**
 * 
 * @author hman11
 * 
 * @param taskList is a ArrayList the stores the seperate tasks.
 * 
 *                 This class is the structure and logic needed to make a
 *                 Arraylist the stores the type of tasks made by the user and
 *                 helps the user manipulate said tasks.
 */
public class TaskList {
	private ArrayList<Task> taskList;

	/*
	 * Main constructor of the ArrayList.
	 */
	public TaskList() {
		this.taskList = new ArrayList<Task>();
	}

	/*
	 * Adds task to the ArrayList.
	 */
	public void addTask(Task toDo) {
		this.taskList.add(toDo);
	}

	/*
	 * Removes a task from the ArrayList.
	 */
	public void removeTask(Task done) {
		this.taskList.remove(done);
	}

	public Task[] getTasks() {
		return taskList.toArray(new Task[0]);
	}

	/*
	 * Returns the size of the ArrayList.
	 */
	public int size() {
		return taskList.size();
	}
}