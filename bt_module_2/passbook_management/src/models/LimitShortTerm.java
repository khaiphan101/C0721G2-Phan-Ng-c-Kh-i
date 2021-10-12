package models;

public class LimitShortTerm extends Passbook {
    private String period;

    public LimitShortTerm() {
    }

    public LimitShortTerm(String idBook, String idCustomer, String openDay, String depositDay, String deposit, String interestRate, String period) {
        super(idBook, idCustomer, openDay, depositDay, deposit, interestRate);
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", period='" + period;
    }

    public String writeToFile() {
        return super.writeToFile() + ',' + period;
    }

}
