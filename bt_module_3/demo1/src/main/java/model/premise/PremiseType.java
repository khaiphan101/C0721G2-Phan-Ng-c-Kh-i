package model.premise;

public class PremiseType {
    int id;
    String name;

    public PremiseType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PremiseType(int id) {
        this.id = id;
    }

    public PremiseType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "PremiseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
