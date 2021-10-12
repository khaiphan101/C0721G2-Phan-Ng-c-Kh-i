package models;

public class UnlimitShortTerm extends ShortTerm {

    public UnlimitShortTerm() {
    }

    public UnlimitShortTerm(String idBook, String idCustomer, String openDay, String depositDay, String deposit, String interestRate) {
        super(idBook, idCustomer, openDay, depositDay, deposit, interestRate);
    }
}
