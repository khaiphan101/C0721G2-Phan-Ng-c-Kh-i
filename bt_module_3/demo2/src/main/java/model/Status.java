package model;

public class Status {
    String id;
    String name;

    public Status(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Status(String id) {
        this.id = id;
    }

    public Status() {
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

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
