package models;

public class Customer {
    private String idcustomer;
    private String customerName;
    private String birthday;
    private String number;
    private String address;

    public Customer(String idcustomer, String customerName, String birthday, String number, String address) {
        this.idcustomer = idcustomer;
        this.customerName = customerName;
        this.birthday = birthday;
        this.number = number;
        this.address = address;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idcustomer='" + idcustomer + '\'' +
                ", customerName='" + customerName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(String idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
