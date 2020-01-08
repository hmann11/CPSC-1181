public class Flight {
    private String name;
    private String departureCity;
    private String arrivalCity;

    public Flight(String name, String departureCity, String arrivalCity) {
        this.name = name;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartureCity() {
        return this.departureCity;
    }

    public String getArrivalCity() {
        return this.arrivalCity;
    }
}
