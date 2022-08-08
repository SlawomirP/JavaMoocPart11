package ex11_12;

public class MainForTesting {
    public static void main(String[] args) {
        Sensor pie = new TemperatureSensor();
        Sensor dwa = new TemperatureSensor();
        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();


        AverageSensor nowy = new AverageSensor();
        nowy.addSensor(pie);
        nowy.addSensor(dwa);
        nowy.addSensor(kumpula);
        nowy.addSensor(kaisaniemi);
        nowy.addSensor(helsinkiVantaaAirport);


        pie.setOn();
        helsinkiVantaaAirport.setOn();
        System.out.println(pie.read());
        System.out.println(helsinkiVantaaAirport.read());
        nowy.setOn();

        System.out.println("-----");
        System.out.println(nowy.readings());

    }
}

