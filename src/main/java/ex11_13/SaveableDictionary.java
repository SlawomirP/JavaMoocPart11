package ex11_13;

import java.util.HashMap;
import java.util.Map;

//STWORZENIE SLOWNICZKA MAJACEGO MOZLIWOSC ZAPISYWANIA I ODCZYTU PLIKU
//SLOWNICZEK MUSI TLUMACZYC Z FINSKIEGO NA INNY JEZYI NA ODWROT
public class SaveableDictionary {

    //TWORZE HASHMAPE DO PRZECHOWYWANIA ALOW I ICH TLUMACZEN
    private HashMap<String, String> dictionary;

    public SaveableDictionary () {
        this.dictionary = new HashMap<>();
    }

    //METODA DODAJACA DO SLOWNIKA SLOWO I JEGO TLUMACZENIE
    //NIE MOZE BYC MOZLIWOSCI DODANIA DRUGI RAZ TEGO SAMEGO SLOWA
    public void add (String word, String translation){
        if (!this.dictionary.containsKey(word)){
            this.dictionary.put(word,translation);
        }
    }
    //METODA ZWROCI TLUMACZENIE WPISANEGO SLOWA, JEZELI SLOWA
    //NIE MA W SLOWNIKU TO ZWROCI NULL
    public String translate (String word){
        if (!this.dictionary.containsKey(word) || !this.dictionary.containsValue(word)){
            return null;
        }
        if(this.dictionary.containsValue(word)){
            //METODA NA WYCIAGNIĘCIE KLUCZA MAJAC WARTOSC Z POD TEGO KLUCZA
            for(Map.Entry<String, String> entry: dictionary.entrySet()){
                if(entry.getValue().equals(word)){
                    return entry.getKey();
                }
            }
        }
        return this.dictionary.get(word);
    }

}
