/**
 * 
 * @author hmann11
 *
 *         This class handles the PercentageTask input.
 */
public class PercentageTask extends Task {
	private long completion;

	public PercentageTask(String TaskName, long completion) {
		super(TaskName);
		this.completion = completion;
	}

	public double getCompletion(int currentTime) {
		return 0;
	}
}
