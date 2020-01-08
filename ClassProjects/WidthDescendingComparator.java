import java.util.*;

public class WidthDescendingComparator implements Comparator<Box> {
	public int compare(Box o1, Box o2) {
		return o2.getWidth() - o1.getWidth();
	}
}
