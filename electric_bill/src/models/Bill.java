package models;

public class Bill {
    private String idBill;
    private String idCustomer;
    private String releaseDay;
    private Double AmountOfElecConsume;
    private Double unitPrice;
    private Double totalPrice;

    public Bill(String idBill, String idCustomer, String releaseDay, Double amountOfElecConsume, Double unitPrice, Double totalPrice) {
        this.idBill = idBill;
        this.idCustomer = idCustomer;
        this.releaseDay = releaseDay;
        AmountOfElecConsume = amountOfElecConsume;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    public Double getAmountOfElecConsume() {
        return AmountOfElecConsume;
    }

    public void setAmountOfElecConsume(Double amountOfElecConsume) {
        AmountOfElecConsume = amountOfElecConsume;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idBill='" + idBill + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", releaseDay='" + releaseDay + '\'' +
                ", AmountOfElecConsume=" + AmountOfElecConsume +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

}
