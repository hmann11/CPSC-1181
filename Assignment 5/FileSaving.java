import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 * @author hmann11
 * 
 *         This class handles the retention part of the persistence layer for
 *         the program. It gets instantiated by the RunSystem class using the
 *         ArrayList used to store the Tasks and the time used. After the
 *         command is passed to it by the CommandExcecution class, this class
 *         takes the command and creates a directory under the name provided by
 *         the user.
 * 
 */
public class FileSaving {
	private ArrayList<Task> taskList;
	private Time time;

	/*
	 * This is a constructor for the FileSaving mechanism.
	 */
	public FileSaving(ArrayList<Task> taskList, Time time) {
		this.taskList = taskList;
		this.time = time;
	}

	/*
	 * This method does most of the heavy lifting in the program. Using a for loop
	 * and a switch the class stores all the tasks in the appropriate format within
	 * the directory.
	 */
	public String run(Command command) {
		String location = command.getRest();
		File folderName = new File(location);
		// Checks if the directory is not present.
		if (!folderName.isDirectory()) {
			folderName.mkdir();
		}
		for (int i = 0; i < this.taskList.size(); i++) {
			Task toSave = taskList.get(i);
			// This line gets the class for the task the needs to stored and turns the name
			// into a string.

			String classType = toSave.getClass().toString().substring(6);

			// Switch that separates the tasks based on their classes and sends them to the
			// right method.
			switch (classType) {
			case "BinaryTask":
				this.saveBinaryTask((BinaryTask) toSave, folderName);
				break;
			case "PercentageTask":
				this.savePercentageTask((PercentageTask)toSave, folderName);
				break;
			case "DueDateTask":
				this.saveDueDateTask((DueDateTask) toSave, folderName);
				break;
			case "ProjectTask":
				this.saveProjectTask((ProjectTask) toSave, folderName);
				break;
			}
		}
		return "";

	}

	/*
	 * Saving Binary Task with the appropriate format.
	 */
	private void saveBinaryTask(Task toSave, File folderName) {
		String fileName = Integer.toString(toSave.getId());
		PrintWriter out = output(folderName, fileName);
		out.println("name : " + toSave.getName());
		boolean taskDone = false;
		if (toSave.getCompletion(time.getCurrentTime()) == 1) {
			taskDone = true;
		}
		out.print("completed : " + taskDone);
		// out.println("completed : " + toSave.getCompletion(time.getCurrentTime()));
		out.close();
	}
	/*
	 * Saving Percentage Task with the appropriate format.
	 */
	private void savePercentageTask(PercentageTask toSave, File folderName) {
		String fileName = Integer.toString(toSave.getId());
		PrintWriter out = output(folderName, fileName);
		out.println("name : " + toSave.getName());
		out.println("completed : " + toSave.getCompletion(time.getCurrentTime()));
		out.close();
	}

	/*
	 * Saving Due Date Tasks in the appropriate format.
	 */
	private void saveDueDateTask(DueDateTask toSave, File folderName) {
		String fileName = Integer.toString(toSave.getId());
		PrintWriter out = output(folderName, fileName);
		out.println("name : " + toSave.getName());
		out.println("startDate : " + toSave.getStartDate());
		out.println("dueDate : " + toSave.getDueDate());
		out.close();
	}

	/*
	 * Saving Project Task in the right format
	 */
	private void saveProjectTask(ProjectTask toSave, File folderName) {
		String fileName = Integer.toString(toSave.getId());
		PrintWriter out = output(folderName, fileName);
		out.println("name : " + toSave.getName());
		String subtasks=toSave.getSubtasks().toString();
		String subtasksCorrected=subtasks.substring(1,subtasks.length());
		out.println("subtasks : " + subtasksCorrected);
		out.close();
	}

	/*
	 * Method the creates the PrinterWriter with the given parameters and adds .tsk
	 * at the end of the file. Finally it returns the PrintWritter to the format
	 * methods.
	 * 
	 * @param folderName stores the name of the parent directory.
	 * 
	 * @param fileName stores the name of the child file.
	 */
	private PrintWriter output(File folderName, String fileName) {
		try {
			File output = new File(folderName, fileName);
			PrintWriter out = new PrintWriter(output + ".tsk");
			return out;

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return null;
	}
}
