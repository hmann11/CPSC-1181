import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoading {
	private ArrayList<Task> taskList;

	public FileLoading(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}

	public String run(Command command) {
		String location = command.getRest();
		File folderName = new File(location);
		if (!folderName.isDirectory()) {
			System.out.println("Invalid Load: Folder " + folderName + " does not exist.");
		} else if (folderName.isDirectory()) {
			taskList.clear();
		}
		int numberOfFiles = folderName.list().length;
		System.out.println(numberOfFiles + "Number of Files");
		for (int i = 1; i <= numberOfFiles; i++) {
			String FileName = i + ".tsk";
			try {
				Scanner in = new Scanner(new File(folderName, FileName));
				String firstLine = in.nextLine();
				String name = firstLine.substring(8, firstLine.length());
				String differentiator = in.nextLine();
				switch(differentiator) {
				case "completed : false":
					this.loadBinaryTask(name,differentiator);
					break;
				case "completed : true":
					break;
				case "completed":
					break;
				case "startDate":
					break;
				case "subtasks":
					break;
				}
			} catch (FileNotFoundException e) {
				System.out.println("File does not exist.");
			}

		}
		return "";
	}

	private void loadBinaryTask(String name, String differentiator) {
		String stateOfTask=differentiator.substring(13,differentiator.length());
		Command command= new Command("create",name);
		
	}

}
