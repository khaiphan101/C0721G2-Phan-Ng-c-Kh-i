package models;

public class ShortTerm extends Passbook {
    public ShortTerm() {
    }

    public ShortTerm(String idBook, String idCustomer, String openDay, String depositDay, String deposit, String interestRate) {
        super(idBook, idCustomer, openDay, depositDay, deposit, interestRate);
    }
}
