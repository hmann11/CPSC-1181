import java.util.ArrayList;
import java.util.Collections;

public class Motivation {
  public static void main(String[] args) {
    ArrayList<Double> marks = new ArrayList();
    Collections.addAll(marks, new Double[]{ 80.0, 20.0, 68.0, 54.0, 32.0, 100.0, 90.0 });

    ArrayList<Double> lt60 = lowerThan60(marks);
    double averageLowerThan60 = average(lt60);
    System.out.println("Average < 60: " + averageLowerThan60);
  }

  private static ArrayList<Double> lowerThan60(ArrayList<Double> marks) {
    ArrayList<Double> r = new ArrayList<>();
    for (Double i: marks) {
      if (i < 60) {
        r.add(i);
      }
    }
    return r;
  }

  private static double average(ArrayList<Double> marks) {
    double average = 0;
    for (Double i: marks) {
      average += i;
    }

    if (marks.size() == 0) {
      return 0;
    }
    return average / marks.size();
  }
}
