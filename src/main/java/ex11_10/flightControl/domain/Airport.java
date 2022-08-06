package ex11_10.flightControl.domain;

public class Airport {

    private String airportID;

    public Airport(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportID() {
        return airportID;
    }

    public String toString() {
        return this.airportID;
    }
}
