package furama_resort.models;

public class House extends Facility{
    private String roomStandard;
    private int floorNumber;

    public House() {
    }

    public House(String idFacility, String serviceName, float area, float rentalCosts, int maxPeople, String rentalType, int value, String roomStandard, int floorNumber) {
        super(idFacility, serviceName, area, rentalCosts, maxPeople, rentalType, value);
        this.roomStandard = roomStandard;
        this.floorNumber = floorNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", floorNumber=" + floorNumber;
    }
    public  String writeToFile(){
        return super.writeToFile() + ',' + roomStandard + ',' + floorNumber;
    }
}
