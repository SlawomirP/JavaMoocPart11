package ex11_10.flightControl.ui;

import ex11_10.flightControl.domain.Airplane;
import ex11_10.flightControl.domain.Flight;
import ex11_10.flightControl.logic.FlightControl;

import java.util.Scanner;

//KLASA KTORA BEDZIE INTERFEJEM UZYTKOWNIKA
//BEDZIE POBIERALA OD NIEGO DANE I DZIAŁAŁA NA OBIEKTACH KLASY
//FLIGHTCONTROL
public class TextUI {

    FlightControl flightControl;
    Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    //METODA DO WYWOLANIA W MAIN UZYTKOWNIKA, BEDZIE POSIADALA
    //METODY NASTEPUJACE PO SOBIE, JEDNA BEDZIE SLUZAYLA DO
    //UZUPELNIANIA DANYMI OD UZYTKOWNIKA, DRUGA BEDZIE
    //SLUZYLA DO SPRAWDZANIA TYCH DANYCH

    public void start () {
    //  TE METODY SA STWORZONE POD METODA START
        startAssetControl();
        System.out.println();
        startFlightControl();

    }

    //METODA ODPOWIEDZIALNA ZA POBRANIE I UZUPELNIENIE LIST

    public void startAssetControl(){

        while (true){

            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");

            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("1")){
                //TUTAJ BEDZIE WYWOLANA METODA NAPISANA NIZEJ
                addAirplane();
            }

            if (command.equals("2")){
                //METODA NAPISANA PONIZEJ
                addFlight(scanner);
            }

            if (command.equals("x")){
                break;
            }


        }
    }

    public void startFlightControl(){

            System.out.println("Flight Control");
            System.out.println("------------");
            System.out.println();

            while (true) {
                System.out.println("Choose an action:");
                System.out.println("[1] Print airplanes");
                System.out.println("[2] Print flights");
                System.out.println("[3] Print airplane details");
                System.out.println("[x] Quit");

                System.out.print("> ");
                String answer = scanner.nextLine();
                if (answer.equals("1")) {
                    printAirplanes();
                } else if (answer.equals("2")) {
                    printFlights();
                } else if (answer.equals("3")) {
                    printAirplaneDetails();
                } else if (answer.equals("x")) {
                    break;
                }
            }
        }

    private void printAirplanes() {
        for (Airplane plane : flightControl.getAirplanes()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight : flightControl.getFlights()) {
            System.out.println(flight);
            System.out.println("");
        }
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        Airplane plane = askForAirplane(scanner);
        System.out.println(plane);
        System.out.println();
    }

    private void addAirplane (){
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        flightControl.addAirplane(id,capacity);
    }

    private void addFlight(Scanner scanner){
        System.out.print("Give the airplane id: ");
        Airplane airplane = askForAirplane(scanner);
        System.out.print("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destinationID = scanner.nextLine();

        flightControl.addFlight(airplane,departureID,destinationID);

    }

    private Airplane askForAirplane(Scanner scanner) {
        Airplane airplane = null;
        while (airplane == null) {
            String id = scanner.nextLine();
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }














}
