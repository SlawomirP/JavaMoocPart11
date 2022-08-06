package ex11_10.flightControl.ui;

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
            }
            //METODA NAPISANA PONIZEJ

            if (command.equals("x")){
                break;
            }


        }
    }

    public void startFlightControl(){}

    private void addAirplane (){
        System.out.print("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        flightControl.addAirplane(id,capacity);
    }














}
