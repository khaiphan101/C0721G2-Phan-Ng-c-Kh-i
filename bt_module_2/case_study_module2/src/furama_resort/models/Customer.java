package furama_resort.models;

public class Customer extends Person {
    private String rank;
    private String address;

    public Customer() {
    }

    public Customer(int code, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String rank, String address) {
        super(code, name, birthday, gender, idNumber, phoneNumber, email);
        this.rank = rank;
        this.address = address;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "customer code=" + super.getCode() +
                ", name=" + super.getName() + '\'' +
                ", birthday=" + super.getBirthday() + '\'' +
                ", gender=" + super.getGender() + '\'' +
                ", id number=" + super.getIdNumber() +
                ", phone number=" + super.getPhoneNumber() +
                ", email=" + super.getEmail() + '\'' +
                "rank=" + rank + '\'' +
                ", address=" + address + '\'' +
                '}';
    }

    public String writeToFile() {
        return super.getCode() +
                "," + super.getName() +
                "," + super.getBirthday() +
                "," + super.getGender() +
                "," + super.getIdNumber() +
                "," + super.getPhoneNumber() +
                "," + super.getEmail() +
                "," + rank +
                "," + address;
    }

}
