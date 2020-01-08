import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy {
  private static Stream<Double> getMarks() {
    return Arrays.stream(
        new Double[]{85.5, 72.4, 78.0, 91.1}
    );
  }

  public static void main(String[] args) {
    Map<Long, List<Double>> grouped =
        getMarks().collect(
            Collectors.groupingBy(
                (Double d) -> (long) Math.floor(d / 10) * 10
            )
        );

    System.out.println(grouped);


    Map<Long, Long> count =
        getMarks().collect(
            Collectors.groupingBy(
                (Double d) -> (long) Math.floor(d / 10) * 10,
                Collectors.counting()
            )
        );

    System.out.println(count);


    Map<Long, Double> average =
        getMarks().collect(
            Collectors.groupingBy(
                (Double d) -> (long) Math.floor(d / 10) * 10,
                Collectors.averagingDouble((Double i) -> i)
            )
        );

    System.out.println(average);
  }
}
