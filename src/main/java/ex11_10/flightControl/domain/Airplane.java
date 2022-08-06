package ex11_10.flightControl.domain;

public class Airplane {

    private String airplaneID;
    private int airplaneCapacity;

    public Airplane(String airplaneID, int airplaneCapacity) {
        this.airplaneID = airplaneID;
        this.airplaneCapacity = airplaneCapacity;
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public int getAirplaneCapacity() {
        return airplaneCapacity;
    }

    public String toString() {
        return this.airplaneID + " (" + this.airplaneCapacity + " capacity)";
    }
}
