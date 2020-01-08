/**
 * 
 * @author hmann11
 * 
 * This class stores the binary task input.
 * 
 * @param State: stores the binary(0 or 1) completion of the task.
 *
 */
public class BinaryTask extends Task{
	private int state;

	public BinaryTask(String TaskName, int state) {
		super(TaskName);
		this.state = state;
	}
	
	public double getCompletion(int currentTime) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
