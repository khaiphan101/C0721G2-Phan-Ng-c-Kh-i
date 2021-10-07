package models;

public class Vietnamese extends Customer{
    private String customerType;
    private String elecConsumption;

    public Vietnamese() {
    }

    public Vietnamese(String idCustomer, String name, String customerType, String elecConsumption) {
        super(idCustomer, name);
        this.customerType = customerType;
        this.elecConsumption = elecConsumption;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getElecConsumption() {
        return elecConsumption;
    }

    public void setElecConsumption(String elecConsumption) {
        this.elecConsumption = elecConsumption;
    }

    @Override
    public String toString() {
        return "VNCustomer{" + super.toString() + '\'' +
                ", customerType='" + customerType + '\'' +
                ", elecConsumption='" + elecConsumption + '\'' +
                '}';
    }

    public String writeToFile() {
        return super.writeToFile() + ',' + customerType + ',' + elecConsumption;
    }
}
