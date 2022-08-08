package ex11_12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TEN SENSOR ZAWIERA W SOBIE POPRZEDNIE CZUJNIKI
//MUSI SIE TUTAJ ZNAJDOWAC METODA DODAJACA CZUJNIKI
//AVERAGESENSOR JEST WLACZONY TYLKO JEZELI RESZTA
//SENSOROW JEST WLACZONA, PO WYLACZENIU PRZYNAJMNIEJ JEDNEGO
//SENSORA TO AVERAGE TEZ SIE WYLACZA
//METODA SETON WLACZA WSZYSTKIE CZUJNIKI A SETOFF
//WYLACZA WSZYSTKIE EW JEDEN
public class AverageSensor implements Sensor {
    //STWORZE ARRAYLISTE NA OBIEKTY SENSOR
    ArrayList<Sensor> sensors;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    //METODA PRZELATUJE PRZEZ LISTE Z OBIEKTAMI I SPRAWDZA ICH STATUS
    //JEZELI CHOCIAZ JEDEN BEDZIE INNY NIZ TRUE TO ODRAZU ZWROCI
    //FALSA A W PRZECIWNYM WYPADKU POPROSTU ZWROCI TRUE
    @Override
    public boolean isOn() {
        for (int i = 0; i < this.sensors.size(); i++) {
            if (!this.sensors.get(i).isOn()) {
                return false;
            }
        }
        return true;
    }

    //METODA PRZELATUJE PRZEZ LISTE OBIEKTOW I NA KAZDYM
    //WYWOLUJE METODE SET ON
    @Override
    public void setOn() {
        for (Sensor sensor : this.sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : this.sensors) {
            sensor.setOff();
        }
    }

    //TERAZ METODA READ MUSI ZWROCIC MI SREDNIA ZE WSZYSTKICH TEMP
    //ZROBIE TO ZA POMOCA STREAMA
    @Override
    public int read() {
        //NA POCZATKU DAJE SRAWDZENIE WYNIKU METODY ISON,
        //JEZELI FALSE TO ODRAZU WYRZUCI EXCEPTION W PRZECIWNYM
        //WYPADKU POPROSTU POLICZY SREDNIA LISTY
        if (!isOn()) {
            throw new IllegalStateException("At least one of the sensors is off. ");
        }
        return (int) this.sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
    }

    //METODA KTORA ZWROCI CALA LISTE ZAPISANYCH OBIEKTÓW
    public List<Integer> readings (){
        return this.sensors.stream().map(sensor -> sensor.read()).collect(Collectors.toCollection(ArrayList::new));
    }
}
