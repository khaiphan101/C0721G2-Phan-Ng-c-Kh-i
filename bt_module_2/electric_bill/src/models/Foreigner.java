package models;

public class Foreigner extends Customer{
    private String nationality;

    public Foreigner(String nationality) {
        this.nationality = nationality;
    }

    public Foreigner(String idCustomer, String name, String nationality) {
        super(idCustomer, name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Foreigner{" + super.toString() + '\'' +
                "nationality='" + nationality + '\'' +
                '}';
    }
    public String writeToFile() {
        return super.writeToFile() + ',' + nationality;
    }
}
