package ex12_01;

import java.util.ArrayList;

public class Hideout<T> {

    //tworzę priv referencje do generic obiektu tej klasy
    private ArrayList<T> hide;
    //konstruktor z generic parametrem
    public Hideout() {
        this.hide = new ArrayList<>();
    }

    //metoda ktora dodaje obiekt do listy, w liscie moze być max 1 obiekt
    //jezeli dodajemy obiekt ktory jest juz w liscie
    //ten obiekt znika
    public void putIntoHideout(T toHide){

    }
}
