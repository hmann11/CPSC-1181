import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<App> activeAppList = new ArrayList<App>();
		SimulatedSystem system = new SimulatedSystem(Integer.parseInt(args[0]), activeAppList);

		UserInput input = new UserInput(system);
		input.run();
	}
}
