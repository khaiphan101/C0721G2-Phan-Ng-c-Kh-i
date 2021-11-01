package furama_resort.models;

public class Contract {
    private int idContract;
    private int bookingCode;
    private String deposit;
    private int totalPay;
    private int customerCode;

    public Contract() {
    }

    public Contract(int idContract, int bookingCode, String deposit, int totalpay, int customerCode) {
        this.idContract = idContract;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPay = totalpay;
        this.customerCode = customerCode;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "idContract=" + idContract + '\'' +
                ", bookingCode=" + bookingCode + '\'' +
                ", deposit=" + deposit + '\'' +
                ", totalpay=" + totalPay + '\'' +
                ", code=" + customerCode;
    }

    public String writeToFile() {
        return idContract + "," + bookingCode + "," + deposit + "," + totalPay + ',' + customerCode;
    }
}
