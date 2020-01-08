/**
 * @author hmann11
 * 
 *         This is the class for the object App and constructs the app with the
 *         details provided.
 * @param name           saves the name of a Application
 * @param memoryRequired saves the memory required by the app to run
 * @param processId      saves the order in which the process is initiated.
 */
public class App {

	private String name;
	private long memoryRequired;
	private int processId;

	// Method to get the right format output when asking for a list of the apps
	// running.
	public String toString() {
		return memoryRequired + " " + name;
	}

	// Main method that creates an app using the 3 given parameters.
	public App(String name, long memoryRequired, int ProcessId) {
		this.name = name;
		this.memoryRequired = memoryRequired;
		this.processId = ProcessId;
	}

	// Getter for the name of an App
	public String getName() {
		return name;
	}

	// Getter for the memory required by an App.
	public long getMemoryReqired() {
		return memoryRequired;
	}

	// Getter for the process ID # of an App.
	public int getProcessId() {
		return processId;
	}
}
