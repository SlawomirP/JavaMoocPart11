package ex11_12;
//KLASA DLA SENSORA KTORY JEST ZAWSZE W TRYBIE ON
//METODY SETON SETOFF NIE DAJ ZADNEGO EFEKTU DLATEGO
//POZOSTAWIE JE PUSTE
//MUSI SIE TU ZNALESC KONSTRUKTOR Z JEDNYM ARGUMENTEM
//LICZBA CALKOWITA KTORA ZWROCI METODA READ
public class StandardSensor implements Sensor{

    private int parameter;

    public StandardSensor(int parameter) {
        this.parameter = parameter;
    }

    //w tym wypadku na stale daje true
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
    }

    @Override
    public void setOff() {
    }

    @Override
    public int read() {
        return this.parameter;
    }
}
