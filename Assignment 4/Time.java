/**
 * 
 * @author hmann11
 * 
 * This class creates a object time and stores 0 as the default value.
 *
 */
public class Time {
	private int currentTime;

	public Time() {
		this.currentTime = 0;
	}

	public int getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(int newTime) {
		this.currentTime = newTime;
	}

}
