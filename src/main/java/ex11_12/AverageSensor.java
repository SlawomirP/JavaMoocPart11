package ex11_12;

import java.util.ArrayList;
import java.util.List;

//TEN SENSOR ZAWIERA W SOBIE POPRZEDNIE CZUJNIKI
//MUSI SIE TUTAJ ZNAJDOWAC METODA DODAJACA CZUJNIKI
//AVERAGESENSOR JEST WLACZONY TYLKO JEZELI RESZTA
//SENSOROW JEST WLACZONA, PO WYLACZENIU PRZYNAJMNIEJ JEDNEGO
//SENSORA TO AVERAGE TEZ SIE WYLACZA
//METODA SETON WLACZA WSZYSTKIE CZUJNIKI A SETOFF
//WYLACZA WSZYSTKIE EW JEDEN
public class AverageSensor implements Sensor {
    //STWORZE ARRAYLISTE NA OBIEKTY SENSOR
    List<Sensor> sensors;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }


    @Override
    public boolean isOn() {
        for (int i = 0; i < this.sensors.size(); i++) {
            if(!this.sensors.get(i).isOn()){
                return false;
            }
        }
        return true;
    }


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
        if(!isOn()){
            throw new IllegalStateException("At least one of the sensors is off. ");
        }
        return (int) this.sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble();
    }
}
