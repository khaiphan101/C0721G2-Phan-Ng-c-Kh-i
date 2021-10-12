package models;

public class LongTerm extends Passbook {
    private String period;
    private String offers;

    public LongTerm() {
    }

    public LongTerm(String idBook, String idCustomer, String openDay, String depositDay, String deposit, String interestRate, String period, String offers) {
        super(idBook, idCustomer, openDay, depositDay, deposit, interestRate);
        this.period = period;
        this.offers = offers;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", period='" + period + '\'' +
                ", offers='" + offers;
    }
}
