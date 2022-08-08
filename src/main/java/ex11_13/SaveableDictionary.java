package ex11_13;

import java.util.HashMap;
import java.util.Map;

//STWORZENIE SLOWNICZKA MAJACEGO MOZLIWOSC ZAPISYWANIA I ODCZYTU PLIKU
//SLOWNICZEK MUSI TLUMACZYC Z FINSKIEGO NA INNY JEZYI NA ODWROT
public class SaveableDictionary {

    //TWORZE HASHMAPE DO PRZECHOWYWANIA ALOW I ICH TLUMACZEN
    private HashMap<String, String> dictionary;

    public SaveableDictionary() {
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
            if (this.dictionary.containsKey(word)){
                return this.dictionary.get(word);
            }
        return null;
    }
    //METODA KTORA USUNIE SLOWO I TLUMACZENIE I NA ODWROT
    public void delete(String word){
        //przypadek gdy slowo to klucz
        if(this.dictionary.containsKey(word)){
            this.dictionary.remove(word);
        }
        //przypadek gdy slowo to wartosc
        if (this.dictionary.containsValue(word)){
            String temp = "";
            //przelatuje liste
            for(String key: this.dictionary.keySet()){
                //jezeli slowo jest rowne wartosci z pod klucza
                if(word.equals(this.dictionary.get(key))){
                    temp = key;
                }
            }
            //to usun klucz
            this.dictionary.remove(temp);
        }
    }
}


