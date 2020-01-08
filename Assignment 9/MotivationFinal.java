import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MotivationFinal {
  public static void main(String[] args) {
    ArrayList<Double> marks = new ArrayList();
    Collections.addAll(marks, new Double[]{80.0, 20.0, 68.0, 54.0, 32.0, 100.0, 90.0});

    double newAverage =
        marks.stream()
            .filter(i -> i < 60)
            .mapToDouble(i -> i + (60 - i) * 0.5)
            .average()
            .getAsDouble()
        ;

    System.out.println("Average < 60: " + newAverage);
  }
}
