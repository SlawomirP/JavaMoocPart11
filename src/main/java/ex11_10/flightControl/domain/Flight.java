package ex11_10.flightControl.domain;

import java.util.HashMap;

//TA KLASA BEDZIE TWORZYLA OBIEKTY KLAS AIRPLANE I AIRPORT
//I BEDZIE Z NICH TWORZYLA OBIEKT LOT
public class Flight {

    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;

    public Flight(Airplane airplane, Airport departureAirport, Airport arrivalAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }


}
