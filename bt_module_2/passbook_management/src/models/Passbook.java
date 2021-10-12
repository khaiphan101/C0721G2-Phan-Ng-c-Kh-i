package models;

public abstract class Passbook {
    private String idBook;
    private String idCustomer;
    private String openDay;
    private String depositDay;
    private String deposit;
    private String interestRate;

    public Passbook(String idBook, String idCustomer, String openDay, String depositDay, String deposit, String interestRate) {
        this.idBook = idBook;
        this.idCustomer = idCustomer;
        this.openDay = openDay;
        this.depositDay = depositDay;
        this.deposit = deposit;
        this.interestRate = interestRate;
    }

    public Passbook() {
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getDepositDay() {
        return depositDay;
    }

    public void setDepositDay(String depositDay) {
        this.depositDay = depositDay;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "idBook='" + idBook + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", openDay='" + openDay + '\'' +
                ", depositDay='" + depositDay + '\'' +
                ", deposit='" + deposit + '\'' +
                ", interestRate='" + interestRate;
    }

    public String writeToFile() {
        return idBook + ',' + idCustomer + ',' + openDay + ',' + depositDay + ',' + deposit + ',' + interestRate;
    }

}
