package model.premise;

public class Premise {
    String id;
    Status status;
    double area ;
    int floor;
    PremiseType premiseType;
    int price;
    String startDay;
    String endDay;

    public Premise(String id, Status status, double area, int floor, PremiseType premiseType, int price, String startDay, String endDay) {
        this.id = id;
        this.status = status;
        this.area = area;
        this.floor = floor;
        this.premiseType = premiseType;
        this.price = price;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Premise() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public PremiseType getPremiseType() {
        return premiseType;
    }

    public void setPremiseType(PremiseType premiseType) {
        this.premiseType = premiseType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDate) {
        this.endDay = endDay;
    }

    @Override
    public String toString() {
        return "Premise{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", area=" + area +
                ", floor=" + floor +
                ", premiseType=" + premiseType +
                ", price=" + price +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                '}';
    }
}
