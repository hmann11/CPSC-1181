import java.util.ArrayList;

public class Airport {
    private String cityName;
    private FlightList departureFlights;
    private FlightList arrivalFlights;

    public Airport(String cityName) {
        this.cityName = cityName;
        this.departureFlights = new FlightList();
        this.arrivalFlights = new FlightList();
    }

    public String getCityName() {
        return this.cityName;
    }

    public void addDepartureFlight(Flight flight) {
        this.departureFlights.addFlight(flight);
    }

    public Flight removeDepartureFlight(String flightName) {
        return this.departureFlights.removeFlight(flightName);
    }

    public void addArrivalFlight(Flight flight) {
        this.arrivalFlights.addFlight(flight);
    }

    public void removeArrivalFlight(String flightName) {
        this.arrivalFlights.removeFlight(flightName);

    }

    public FlightList getArrivalFlights() {
        return this.arrivalFlights;
    }

    public FlightList getDepartureFlights() {
        return this.departureFlights;
    }

}
