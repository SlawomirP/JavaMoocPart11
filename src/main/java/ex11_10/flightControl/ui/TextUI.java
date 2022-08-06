package ex11_10.flightControl.ui;

import ex11_10.flightControl.logic.FlightControl;

import java.util.Scanner;

//KLASA KTORA BEDZIE INTERFEJEM UZYTKOWNIKA
//BEDZIE POBIERALA OD NIEGO DANE I DZIAŁAŁA NA OBIEKTACH KLASY
//FLIGHTCONTROL
public class TextUI {

    FlightControl flightControl;
    Scanner scanner;

    public TextUI() {
        this.flightControl = new FlightControl();
        this.scanner = new Scanner(System.in);
    }

    //METODA DO WYWOLANIA W MAIN UZYTKOWNIKA, BEDZIE POSIADALA
    //METODY NASTEPUJACE PO SOBIE, JEDNA BEDZIE SLUZAYLA DO
    //UZUPELNIANIA DANYMI OD UZYTKOWNIKA, DRUGA BEDZIE
    //SLUZYLA DO SPRAWDZANIA TYCH DANYCH

    public void start () {}
}
