import java.util.ArrayList;
import java.util.Arrays;

public class Scene1 {
    public static void main(String[] args) {
        Airport rome = new Airport("Rome");
        Airport paris = new Airport("Paris");
        Airport toronto = new Airport("Toronto");
        Airport vancouver = new Airport("Vancouver");
        Airport reykjavik = new Airport("Reykjavik");
        ArrayList<Airport> airports = new ArrayList<Airport>(Arrays.asList(rome, paris, toronto, vancouver, reykjavik));

        TrackingSystem ts = new TrackingSystem(airports);

        ts.scheduleFlight("AC 101", rome.getCityName(), toronto.getCityName());
        ts.scheduleFlight("AC 201", vancouver.getCityName(), reykjavik.getCityName());
        ts.scheduleFlight("AC 202", reykjavik.getCityName(), vancouver.getCityName());
        ts.scheduleFlight("AC 301", toronto.getCityName(), paris.getCityName());
        ts.scheduleFlight("AC 1101", toronto.getCityName(), vancouver.getCityName());

        ts.printDeparture(toronto.getCityName());
        ts.printDeparture(reykjavik.getCityName());

        ts.departed("AC 301");
        ts.departed("AC 202");

        ts.printArrival(vancouver.getCityName());
        ts.printDeparture(toronto.getCityName());
        ts.printArrival(paris.getCityName());

        ts.arrived("AC 301");

        ts.printArrival(paris.getCityName());
    }
}
