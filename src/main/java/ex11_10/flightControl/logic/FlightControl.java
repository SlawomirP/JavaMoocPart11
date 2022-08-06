package ex11_10.flightControl.logic;

import ex11_10.flightControl.domain.Airplane;
import ex11_10.flightControl.domain.Airport;
import ex11_10.flightControl.domain.Flight;

import java.util.HashMap;

//KLASA KTORA BĘDZIE ZARZĄDZALA SAMOLOTAMI, LOTNISKAMI, LOTAMI TZN
//BEDZIE DODAWALA JE DO ODPOWIEDNIEJ HASHMAPY
public class FlightControl {

    private HashMap<String,Airplane> airplanes;
    private HashMap<String,Airport> airportsDeparture;
    private HashMap<String,Airport> airportsArrival;
    private HashMap<String,Flight> flights;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.airportsDeparture = new HashMap<>();
        this.airportsArrival = new HashMap<>();
        this.flights = new HashMap<>();
    }

    //METODA DODAJĄCA TWORZĄCA Z PODANYCH PARAMETROW OBIEKT
    //AIRPLANE I UMIESZCZAJACA GO W HASHMAPIE
    public void addAirplane(String id, int capacity){
        // DODAJE DO HASHMAPY STRINGA ID A POTEM NOWY OBIEKT AIRPLANE
        this.airplanes.put(id, new Airplane(id,capacity));
    }

    //mETODA DODAJĄCA LOT DO LISTY LOTÓW
    //W PARAMETRZE PODAM SAMOLOT O LOTNISKO ODLOTU I PRZYBYCIA
    public void addFlight(Airplane airplane, String departureId, String arrivalId){
        //DODANIE DO MAPY Z LOTNISKAMI MIEJSC ODLOTU I PRZYLOTU
        this.airportsDeparture.put(departureId, new Airport(departureId));
        this.airportsArrival.put(arrivalId, new Airport(arrivalId));
        //UTWORZENIE OBIEKTU LOT I DODANIE DO MAPY LOTÓW, ZA KLUCZ POSLUZY
        //NAZWA LOTU
        Flight flight = new Flight(airplane, this.airportsDeparture.get(departureId), this.airportsArrival.get(arrivalId));
        //DODANIE DO MAPY KLUCZA I WARTOŚCI
        this.flights.put(flight.toString(), flight);
    }
}
