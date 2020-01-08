import java.util.ArrayList;

public class TrackingSystem {
    private ArrayList<Airport> airports;
    private ArrayList<Flight> flights;

    public TrackingSystem(ArrayList<Airport> airports) {
        this.airports = airports;
        this.flights = new ArrayList<Flight>();
    }

    private Airport findAirport(String cityName) {
        Airport foundAirport = null;
        for (int i = 0; i < this.airports.size(); i++) {
            Airport current = this.airports.get(i);
            if (current.getCityName().equals(cityName)) {
                foundAirport = current;
            }
        }
        return foundAirport;
    }

    public void scheduleFlight(String flightName, String departureCity, String arrivalCity) {
        // Create the flight first
        Flight newFlight = new Flight(flightName, departureCity, arrivalCity);

        // Keep track of this flight until it lands
        this.flights.add(newFlight);

        // Add flight to airport
        Airport departureAirport = this.findAirport(departureCity);
        departureAirport.addDepartureFlight(newFlight);
    }

    private Flight findFlight(String flightName) {
        Flight flight = null;
        for (Flight f : this.flights) {
            if (f.getName() == flightName) {
                flight = f;
            }
        }
        return flight;
    }

    public void departed(String flightName) {
        Flight departedFlight = this.findFlight(flightName);

        Airport dc = this.findAirport(departedFlight.getDepartureCity());
        Airport ac = this.findAirport(departedFlight.getArrivalCity());

        dc.removeDepartureFlight(departedFlight.getName());
        ac.addArrivalFlight(departedFlight);

        System.out.printf(
                "Flight %s has left %s for %s\n\n",
                departedFlight.getName(),
                departedFlight.getDepartureCity(),
                departedFlight.getArrivalCity()
        );
    }

    public void arrived(String flightName) {
        Flight arrivedFlight = this.findFlight(flightName);

        Airport ac = this.findAirport(arrivedFlight.getArrivalCity());
        ac.removeArrivalFlight(arrivedFlight.getName());

        this.flights.remove(arrivedFlight);

        System.out.printf(
                "Flight %s from %s arrived in %s\n\n",
                arrivedFlight.getName(),
                arrivedFlight.getDepartureCity(),
                arrivedFlight.getArrivalCity()
        );
    }

    private void printFlights(FlightList flightList) {
        Flight[] flights = flightList.getFlights();
        for (Flight f : flights) {
            System.out.printf("%s, %s, %s\n", f.getName(), f.getDepartureCity(), f.getArrivalCity());
        }
    }

    public void printArrival(String cityName) {
        Airport ac = this.findAirport(cityName);
        System.out.println("Arriving: " + cityName);
        this.printFlights(ac.getArrivalFlights());
        System.out.println();
    }

    public void printDeparture(String cityName) {
        Airport dc = this.findAirport(cityName);
        System.out.println("Departing: " + cityName);
        this.printFlights(dc.getDepartureFlights());
        System.out.println();
    }
}
