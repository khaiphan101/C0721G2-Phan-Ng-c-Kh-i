package models;

public abstract class Vehicle {
    private String BKS;
    private String brand;
    private String yearOfManufacture;
    private String owner;

    public Vehicle(String BKS, String brand, String yearOfManufacture, String owner) {
        this.BKS = BKS;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public Vehicle() {
    }

    public String getBKS() {
        return BKS;
    }

    public void setBKS(String BKS) {
        this.BKS = BKS;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BKS='" + BKS + '\'' +
                ", brand='" + brand + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", owner='" + owner + '\'' + ", ";
    }

    public String writeToFile() {
        return BKS + ',' + brand + ',' + yearOfManufacture + ',' + owner;
    }
}
