package furama_resort.models;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String idFacility, String serviceName, float area, float rentalCosts, int maxPeople, String rentalType,int value, String freeService) {
        super(idFacility, serviceName, area, rentalCosts, maxPeople, rentalType, value);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    public String toString() {
        return super.toString() + '\'' +
                ", free service=" + freeService;
    }
    public  String writeToFile(){
        return super.writeToFile() + ',' + freeService;
    }

}
