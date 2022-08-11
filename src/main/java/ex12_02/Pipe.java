package ex12_02;

import java.util.ArrayList;

//MOZEMY TUTAJ DODAWAC I USUWAC WARTOSCI
//JEZELI USUWAMY TO ZAWSZE WARTOSC KTORA ZNAJDUJE
//SIE NAJDLUZEJ NA"LISCIE", MA BYC KONSTRUKTOR BEZ PARAM
public class Pipe <T> {
    //TWORZE ARAYLISTE OBIEKTOW DO PRZECHOWYWANIA
    private ArrayList<T> pipe;

    public Pipe(){
        this.pipe = new ArrayList<>();
    }
    //UMIESZCZA OBIEKT t W LISCIE
    public void putIntoPipe(T value){
        this.pipe.add(value);
    }

    //POBIERA OBIEKT T Z LISTY KTORY JEST TAM NAJDŁUŻEJ
    //NASTEPNIE GO USUWA
    //JEZELI LISTA JEST PUSTA TO ZWRACA NULLA
    public T takeFromPipe(){
        if (this.pipe.isEmpty()) {
            return null;
        }
        T helper = this.pipe.get(0);
        this.pipe.remove(0);
        return helper;
    }

    //METODA ZWROCI TRUE JEZELI COS ZNAJDUJE SIE NA LISCIE
    //FALSE JEZELI LISTA JEST PUSTA
    public boolean isInPipe(){
        return !this.pipe.isEmpty();
    }

}
