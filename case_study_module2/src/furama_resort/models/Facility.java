package furama_resort.models;

public abstract class Facility {
    //1.	Xây dựng abstract class Facility (cơ sở vật chất) bao gồm các thông tin chung của tất cả dịch vụ cho thuê Villa, House, Room.
    private String idFacility;
    private String serviceName;
    private float area;
    private float rentalCosts;
    private int maxPeople;
    private String rentalType;
    private int value = 0;

    public Facility() {
    }

    public Facility(String idFacility, String serviceName, float area, float rentalCosts, int maxPeople, String rentalType, int value) {
        this.idFacility = idFacility;
        this.serviceName = serviceName;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
        this.value = value;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(float rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "idFacility=" + idFacility +
                ", service name='" + serviceName +
                ", area=" + area +
                ", rental costs=" + rentalCosts +
                ", max people=" + maxPeople +
                ", rental type='" + rentalType;
    }
    public String writeToFile(){
        return idFacility +
                ',' + serviceName +
                ',' + area +
                ',' + rentalCosts +
                ',' + maxPeople +
                ',' + rentalType +
                ',' + value;
    }
}
