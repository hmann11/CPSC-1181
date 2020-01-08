import java.util.ArrayList;

public class FlightList {
    private ArrayList<Flight> flights;

    public FlightList() {
        this.flights = new ArrayList<Flight>();
    }

    /**
     * @param flightName name of flight we are looking for
     * @return position in `flights` if the flight name is found, -1 otherwise
     */
    private int findFlightFromList(String flightName) {
        int position = -1;
        for (int i = 0; i < this.flights.size(); i++) {
            if (this.flights.get(i).getName().equals(flightName)) {
                position = i;
            }
        }
        return position;
    }

    public Flight removeFlight(String flightName) {
        int position = this.findFlightFromList(flightName);
        if (position != -1) {
            return this.flights.remove(position);
        }
        return null;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public Flight[] getFlights() {
        return this.flights.toArray(new Flight[0]);
    }
}
