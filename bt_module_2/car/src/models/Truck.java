package models;

public class Truck extends Vehicle {
    private Double weight;

    public Truck() {
    }

    public Truck(String BKS, String brand, String yearOfManufacture, String owner, Double weight) {
        super(BKS, brand, yearOfManufacture, owner);
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                "weight=" + weight +
                '}';
    }

    public String writeToFile() {
        return super.writeToFile() + ',' + weight;
    }
}
