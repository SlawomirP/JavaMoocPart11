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
    //jezeli dodajemy obiekt a jest juz cos w liscie
    //ten obiekt znika - zostaje nadpisany
    public void putIntoHideout(T toHide){
        if(!this.hide.isEmpty()){
            this.hide.clear();
            this.hide.add(toHide);
        } else {
            this.hide.add(toHide);
        }
    }
    // ZWRACA OBIEKT Z LISTY, JEZELI LISTA JEST PUSTA
    //TO ZWROC NULLA
    public T takeFromHideout(){
        if (this.hide.isEmpty()){
            return null;
        }
        //JEZELI COS JEST W LISCIE TO PRZYPISUJE TO DO
        //POMOCNICZEGO OBIEKTU, USUWAM Z LISTY I ZWRACAM
        //POMOCNICZY OBIEKT
        T helper =  this.hide.get(0);
        this.hide.remove(0);
        return helper;
    }
//SPRAWDZA CZY COS JEST W LICIE
    public boolean isInHideout(){
        if(!this.hide.isEmpty()){
            return true;
        } else{
         return false;
        }
    }



}
