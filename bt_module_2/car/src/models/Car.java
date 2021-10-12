package models;

public class Car extends Vehicle {
    private int seatsNumber;
    private String carType;

    public Car(String BKS, String brand, String yearOfManufacture, String owner, int seatsNumer, String carType) {
        super(BKS, brand, yearOfManufacture, owner);
        this.seatsNumber = seatsNumer;
        this.carType = carType;
    }

    public Car() {
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "seatsNumer=" + seatsNumber +
                ", carType='" + carType + '\'' +
                '}';
    }

    public String writeToFile() {
        return super.writeToFile() + ',' + seatsNumber + ',' + carType;
    }
}
