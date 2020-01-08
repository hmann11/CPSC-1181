import java.io.IOException;
import java.util.stream.Collectors;

public class BusinessLicenceExplore {

  public static boolean matches(String s, String toMatch) {
    return s.toLowerCase().contains(toMatch.toLowerCase());
  }

  public static long roundBy(double d, long base) {
    return (long) Math.round(d / base) * base;
  }

  public static void main(String[] args) throws IOException {
    BusinessLicenceStream s = new BusinessLicenceStream("./data/2018business_licences.csv");

    selfcheck1(s);

    selfcheck2(s);

    selfcheck3(s);

    selfcheck4(s);

    selfcheck5(s);

    selfcheck6(s);
  }

  private static void selfcheck1(BusinessLicenceStream s) throws IOException {
    long count = s.getBusinesses().count();
    System.out.println("Number of businesses: " + count);
    System.out.println();
  }

  private static void selfcheck2(BusinessLicenceStream s) throws IOException {
    long numBusinessesOver1000 = s.getBusinesses()
        .filter(v -> v.getNumberOfEmployees() > 1000)
        .count();

    System.out.println("Number of businesses over 1000 employees: " + numBusinessesOver1000);
    System.out.println();
  }

  private static void selfcheck3(BusinessLicenceStream s) throws IOException {
    String top10Employees = s.getBusinesses()
        .sorted((e, f) -> -1 * Double.compare(e.getNumberOfEmployees(), f.getNumberOfEmployees()))
        .limit(10)
        .map(v -> v.toString())
        .collect(Collectors.joining("\n"));
    System.out.println("Top 10 businesses with most employees: ");
    System.out.println(top10Employees);
    System.out.println();
  }

  private static void selfcheck4(BusinessLicenceStream s) throws IOException {
    long sushiCount = s.getBusinesses()
        .filter(v -> matches(v.getName(), "sushi"))
        .count();

    System.out.println("Number of businesses with name \"Sushi\": " + sushiCount);
    System.out.println();
  }

  private static void selfcheck5(BusinessLicenceStream s) throws IOException {
    String typesOfBusiness = s.getBusinesses()
        .collect(
            Collectors.groupingBy(
                b -> b.getBusinessType(),
                Collectors.counting()
            ))
        .entrySet()
        .stream()
        .sorted((e, f) -> -1 * Long.compare(e.getValue(), f.getValue()))
        .map(e -> e.toString())
        .collect(Collectors.joining("\n"));

    System.out.println("Types of Businesses: ");
    System.out.println(typesOfBusiness);
    System.out.println();
  }

  private static void selfcheck6(BusinessLicenceStream s) throws IOException {
    String top5 = s.getBusinesses()
        .collect(
            Collectors.groupingBy(
                b -> b.getBusinessType(),
                Collectors.averagingDouble(b -> b.getFeePaid())
            )
        )
        .entrySet()
        .stream()
        .sorted((e, f) -> -1 * Double.compare(e.getValue(), f.getValue()))
        .limit(5)
        .map(e -> e.getKey() + ": " + e.getValue())
        .collect(Collectors.joining("\n"));

    String bottom5 = s.getBusinesses()
        .collect(
            Collectors.groupingBy(
                b -> b.getBusinessType(),
                Collectors.averagingDouble(b -> b.getFeePaid())
            )
        )
        .entrySet()
        .stream()
        .sorted((e, f) -> Double.compare(e.getValue(), f.getValue()))
        .limit(5)
        .map(e -> e.getKey() + ": " + e.getValue())
        .collect(Collectors.joining("\n"));
    ;

    System.out.println("5 Business Types with most fees: ");
    System.out.println(top5);
    System.out.println();

    System.out.println("5 Business Types with fewest fees: ");
    System.out.println(bottom5);
    System.out.println();
  }
}
