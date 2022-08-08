package ex11_12;

public class MainForTesting {
    public static void main(String[] args) {
        TemperatureSensor ten = new TemperatureSensor();
        TemperatureSensor minusFive = new TemperatureSensor();

        System.out.println(ten.read());
        System.out.println(minusFive.read());

        System.out.println(ten.isOn());
        ten.setOn();
        System.out.println(ten.isOn());
        ten.setOff();
        System.out.println(ten.isOn());
    }
}

