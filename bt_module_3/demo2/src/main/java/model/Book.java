package model;

public class Book {
    String id;
    String name;
    String actor;
    String amount;
    String description;

    public Book(String id, String name, String actor, String amount, String description) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.amount = amount;
        this.description = description;
    }

    public Book(String id) {
        this.id = id;
    }

    public Book() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
