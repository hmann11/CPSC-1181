import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author hmann11
 * 
 *         This class works along with the simulated system to provide a more
 *         robust memory managment scheme.
 * 
 * @param totalMemory   stores the total amount of memory of the system.
 * @param ActiveAppList saves the ArrayList of apps.
 * @param seed          stores the seed used to genrate a random int.
 *
 */
public class RandomMemoryManagmentStratergy {

	private long totalMemory;
	private ArrayList<App> activeAppList;
	private int seed;

	// Takes in the properties that the user wants to give to the simulated system
	// regarding the memory management.
	public RandomMemoryManagmentStratergy(int seed, long totalMemory, ArrayList<App> activeAppList) {
		Random rand = new Random(seed);
		this.seed = rand.nextInt();
		this.totalMemory = totalMemory;
		this.activeAppList = activeAppList;
	}

	// Checks if a app requires more memory that the system currently has.
	public boolean isGreaterThanMaxMemory(long memoryRequired) {
		if (memoryRequired >= totalMemory) {
			return true;
		} else {
			return false;
		}

	}

	// Checks if the amount of memory used is enugh to start a new app with that
	// amount of memory.
	public boolean isEnoughMemoryToRunApp(long memoryRequired) {
		int memoryUsed = 0;
		for (int i = 0; i < activeAppList.size(); i++) {
			App current = activeAppList.get(i);
			memoryUsed += current.getMemoryReqired();
		}
		if (memoryUsed > memoryRequired) {
			return true;
		} else if (memoryUsed < memoryRequired) {
			return false;
		} else
			return false;
	}

	// Randomly chooses an app to kill in order to free up system memory.
	public App selectNextTerminateTarget(long memoryRequired) {
		App victimApp = activeAppList.get(0);// Can't figure out a way to get the seed to genrate random ints within the
												// limit.
		if (isEnoughMemoryToRunApp(memoryRequired) == true) {
			return victimApp;
		} else if (isGreaterThanMaxMemory(memoryRequired) == true) {
			this.seed++;
			return selectNextTerminateTarget(memoryRequired);
		}
		return victimApp;
	}
}
