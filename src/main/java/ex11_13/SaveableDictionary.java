package ex11_13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

//STWORZENIE SLOWNICZKA MAJACEGO MOZLIWOSC ZAPISYWANIA I ODCZYTU PLIKU
//SLOWNICZEK MUSI TLUMACZYC Z FINSKIEGO NA INNY JEZYI NA ODWROT
public class SaveableDictionary {

    //TWORZE HASHMAPE DO PRZECHOWYWANIA ALOW I ICH TLUMACZEN
    private HashMap<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        this.dictionary = new HashMap<>();
    }

    //DRUGI KONSTRUKTOR DLA KLASY KTORY BEDZIE MIAL W PARAMETRZE
    //PLIK KTORY BEZIE SLUZYL DO ODCZYTU
    public SaveableDictionary(String file) {
        this.file = file;
        this.dictionary = new HashMap<>();
    }

    //METODA DODAJACA DO SLOWNIKA SLOWO I JEGO TLUMACZENIE
    //NIE MOZE BYC MOZLIWOSCI DODANIA DRUGI RAZ TEGO SAMEGO SLOWA
    public void add(String word, String translation) {
        //doda tylko jak nie bedzie nic pod tym kluczem - putIfAbsent
        this.dictionary.putIfAbsent(word, translation);

    }

    //METODA ZWROCI TLUMACZENIE WPISANEGO SLOWA, JEZELI SLOWA
    //NIE MA W SLOWNIKU TO ZWROCI NULL
    public String translate(String word) {
        //METODA NA WYCIAGNIĘCIE KLUCZA MAJAC WARTOSC Z POD TEGO KLUCZA
        if (this.dictionary.containsValue(word)) {
            //przelatujac przez liste
            for (String key : this.dictionary.keySet()) {
                //jezeli slowo bedzie rowne temu co pod kluczem
                if (word.equals(dictionary.get(key))) {
                    //zwroc klucz
                    return key;
                }
            }
        }
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        }
        return null;
    }

    //METODA KTORA USUNIE SLOWO I TLUMACZENIE I NA ODWROT
    public void delete(String word) {
        //przypadek gdy slowo to klucz
        if (this.dictionary.containsKey(word)) {
            this.dictionary.remove(word);
        }
        //przypadek gdy slowo to wartosc
        if (this.dictionary.containsValue(word)) {
            String temp = "";
            //przelatuje liste
            for (String key : this.dictionary.keySet()) {
                //jezeli slowo jest rowne wartosci z pod klucza
                if (word.equals(this.dictionary.get(key))) {
                    temp = key;
                }
            }
            //to usun klucz
            this.dictionary.remove(temp);
        }
    }

    //METODA KTORA WCZYTA SLOWNIK Z PODANEGO W KONSTRUKTORZE PLIKU
    //JEZELI NIE BEDZIE MOGLA WCZYTAC TO ZWROCI FALSE W PRZECIWNYM
    //WYPADKU DA TRUE
    public boolean load() {
        //stworzenie pomocniczego booleana
        boolean status = true;
        try {
            //STWORZENIE OBIEKTU SCANERA DO WCZYTANIE PLIKU
            Scanner reader = new Scanner(Paths.get(this.file));
            //podczas gdy reader bedzie mial nastepna linie
            while (reader.hasNext()) {
                //pomocniczy string rowna sie nastepnej lini
                String row = reader.nextLine();
                //tablica stringow = rozbity string row
                String[] temp = row.split(":");
                //do hashmapy dictionary dodaj el tablicy
                //o ile wczesniej tam nie bedzie
                this.dictionary.putIfAbsent(temp[0], temp[1]);
            }
        } catch (IOException e) {
            //jezeli wyrzuci wyjatek to zmieni status na false
            status = false;
            throw new RuntimeException(e);
        }
        //jezeli przejdzie poprawnie to poprostu zostanie true
        return status;
    }

    //ZAPISYWANIE DO PLIKU slownika,NAZWA PLIKU DO ZAPISANIE
    //MA BYC W PARAMETRZE METODY, JEZELI NIE BEDZIE MOZNA ZAPISAC
    //METODA MA ZWRÓCIC FALSE W PRZECIWNYM WYPADKU DA TRUE
    public boolean save() {
        boolean status = true;
        try {
            PrintWriter writer = new PrintWriter(this.file);
            for (String key : this.dictionary.keySet()) {
                writer.println(key + ":" + this.dictionary.get(key));
            }
            writer.close(); // to musi koniecznie byc !!!!!!!!
        } catch (FileNotFoundException e) {
            status = false;
            throw new RuntimeException(e);
        }
        return status;
    }
}


