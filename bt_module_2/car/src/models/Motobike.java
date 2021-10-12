package models;

public class Motobike extends Vehicle{
    private double capacity;

    public Motobike() {
    }

    public Motobike(String BKS, String brand, String yearOfManufacture, String owner, double capacity) {
        super(BKS, brand, yearOfManufacture, owner);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Motobike{" +
                super.toString() +
                "capacity=" + capacity +
                '}';
    }
    public String writeToFile() {
        return super.writeToFile() + ',' + capacity;
    }
}
