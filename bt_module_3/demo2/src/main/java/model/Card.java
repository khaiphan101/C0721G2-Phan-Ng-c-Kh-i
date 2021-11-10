package model;

public class Card {
    String idCard;
    Book book;
    Student student;
    Status Status;
    String borrowDay;
    String returnDay;

    public Card(String idCard, Book book, Student student, model.Status status, String borrowDay, String returnDay) {
        this.idCard = idCard;
        this.book = book;
        this.student = student;
        Status = status;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Card() {
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public model.Status getStatus() {
        return Status;
    }

    public void setStatus(model.Status status) {
        Status = status;
    }

    public String getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(String borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }

    @Override
    public String toString() {
        return "Card{" +
                "idCard='" + idCard + '\'' +
                ", book=" + book +
                ", student=" + student +
                ", Status=" + Status +
                ", borrowDay='" + borrowDay + '\'' +
                ", returnDay='" + returnDay + '\'' +
                '}';
    }
}
