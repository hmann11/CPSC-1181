import java.util.ArrayList;

/**
 * 
 * @author hmann11
 * 
 *         This class provides a system that the Apps can be saved into.
 * @param maxSystemMemory stores the maximum amount of memory of the system.
 * @param activeAppList   stores the apps in the form of an arraylist
 * @param memoryRequired  is the amount of memory required by an app to run.
 * @param processId       saves the process ID of the apps in a chronological
 *                        order.
 */
public class SimulatedSystem {

	private int maxSystemMemory;
	private ArrayList<App> activeAppList;
	private long memoryRequired;
	private int processId;
	private RandomMemoryManagmentStratergy stratergy;

	// Constructing a system that acts like a command line OS.
	public SimulatedSystem(RandomMemoryManagmentStratergy stratergy, ArrayList<App> activeAppList) {
		this.stratergy = stratergy;
		this.activeAppList = activeAppList;
	}

	// Constructing an app and checking if there's enough memory to run it, killing
	// an app depending on the logic.
	public void runApp(String appName, long memoryRequired) {
		this.processId++;
		if (stratergy.isGreaterThanMaxMemory(memoryRequired) == true
				| stratergy.isEnoughMemoryToRunApp(memoryRequired)) {
			System.out.println("Not enough memory to run " + appName);
			System.out.println("Looking for a suitable app to kill");
			App victimApp = stratergy.selectNextTerminateTarget(memoryRequired);
			System.out.println("Terminated " + victimApp.getName());
			activeAppList.remove(victimApp);
		}
		activeAppList.add(new App(appName, memoryRequired, this.processId));
		System.out.println("Process Added");
	}

	// Stopping an app depending on its ProcessId
	public void stopApp(int appId) {
		activeAppList.remove(appId);
	}

	// List the number of apps with certain details
	public void listApps() {
		for (App s : activeAppList) {
			System.out.println(s.toString());
		}
	}

	// Find the location of a certain app in the array and returning its processId.
	public int findPosition(String target) {
		int positionOfApp = 0;
		for (int i = 0; i < this.activeAppList.size(); i++) {
			App current = this.activeAppList.get(i);
			System.out.println("This is the target" + target);
			System.out.println(current.getName() + " Is THe APP");
			if (target.equals(current.getName())) {
				System.out.println("I work 2");
				System.out.println(i);
				positionOfApp = activeAppList.indexOf(current);
			}
		}
		return positionOfApp;
	}
}
