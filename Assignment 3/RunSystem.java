import java.util.ArrayList;

/**
 * 
 * @author hmann11
 * 
 *         This is a main method that calls the appropriate constructors and
 *         starts the simulation.
 */
public class RunSystem {
	public static void main(String[] args) {
		ArrayList<App> activeAppList = new ArrayList<App>();// Constructing an emptry ArrayList.
		RandomMemoryManagmentStratergy stratergy = new RandomMemoryManagmentStratergy(Integer.parseInt(args[1]),
				Integer.parseInt(args[0]), activeAppList);// Creates a memory management strategy depending on the
															// instructions provided by the user.
		SimulatedSystem system = new SimulatedSystem(stratergy, activeAppList);// Constructing a simulated system
		UserInput input = new UserInput(system);// Constructing a input method to receive further instructions from the
												// user.
		input.run();
	}
}
