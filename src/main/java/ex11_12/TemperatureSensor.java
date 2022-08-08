package ex11_12;

import java.util.Random;

//KLASA REPREZENTUJACA CZUJNIK TEMPERATURY
//NA POCZATKU JEST ON WYLACZONY
//WYWOLANIE METODY READ POWODUJE ZE SENSOR LOSOWO WYBIERA
//TEMP Z ZAKRESU -30 DO 30, TAWARTOSC ZOSTAJE ZWROCONA
//JEZELI SENSOR JEST WYLACZONY TO WYWOLANIE METODY READ
//ma wyrzucic wyjatek IllegalStateException
public class TemperatureSensor implements Sensor{

    private boolean sensorCondition;

    public TemperatureSensor() {
        this.sensorCondition = false;
    }

    @Override
    public boolean isOn() {
        return this.sensorCondition;
    }

    @Override
    public void setOn() {
        this.sensorCondition = true;
    }

    @Override
    public void setOff() {
        this.sensorCondition = false;
    }

    @Override
    public int read() {
        if(this.sensorCondition){
            throw new IllegalStateException("Sensor if off.");
        }
        return randomTemperature();
    }

    private int randomTemperature (){
        int r = new Random().nextInt(61);
        return r - 31;
    }
}
