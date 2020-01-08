import java.util.ArrayList;
import java.util.Collections;

public class Motivation2 {
  public static void main(String[] args) {
    ArrayList<Double> marks = new ArrayList();
    Collections.addAll(marks, new Double[]{80.0, 20.0, 68.0, 54.0, 32.0, 100.0, 90.0});

    ArrayList<Double> lt60 = lowerThan60(marks);
    ArrayList<Double> belled = bellCurve(lt60);
    double averageLowerThan60 = average(belled);
    System.out.println("Average < 60: " + averageLowerThan60);
  }

  private static ArrayList<Double> bellCurve(ArrayList<Double> marks) {
    ArrayList<Double> r = new ArrayList<>();
    for (Double i : marks) {
      double diff = 60 - i;
      double bell = diff * 0.5;
      r.add(i + bell);
    }
    return r;
  }

  private static ArrayList<Double> lowerThan60(ArrayList<Double> marks) {
    ArrayList<Double> r = new ArrayList<>();
    for (Double i : marks) {
      if (i < 60) {
        r.add(i);
      }
    }
    return r;
  }

  private static double average(ArrayList<Double> marks) {
    double average = 0;
    for (Double i : marks) {
      average += i;
    }

    if (marks.size() == 0) {
      return 0;
    }
    return average / marks.size();
  }
}
