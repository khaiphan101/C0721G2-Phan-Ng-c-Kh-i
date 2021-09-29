package caseStudy_furamaResort.models;

public class Villa extends House {
    private Float poolArea;

    public Villa() {
    }

    public Villa(String serviceName, float area, float rentalCosts, int maxPeople, String rentalType, String roomStandard, int floorNumber, Float poolArea) {
        super(serviceName, area, rentalCosts, maxPeople, rentalType, roomStandard, floorNumber);
        this.poolArea = poolArea;
    }

    public Float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Float poolArea) {
        this.poolArea = poolArea;
    }
    @Override
    public String toString() {
        return super.toString() + '\'' +
                ", poolArea=" + poolArea;
    }
    public  String writeToFile(){
        return super.writeToFile() + ',' + poolArea;
    }



    //    private String roomStandard;
//    private Float poolArea;
//    private int floorNumber;
//
//    public Villa() {
//    }
//
//    public Villa(String serviceName, float area, float rentalCosts, int maxPeople, String rentalType, String roomStandard, Float poolArea, int floorNumber) {
//        super(serviceName, area, rentalCosts, maxPeople, rentalType);
//        this.roomStandard = roomStandard;
//        this.poolArea = poolArea;
//        this.floorNumber = floorNumber;
//    }
//
//    public String getRoomStandard() {
//        return roomStandard;
//    }
//
//    public void setRoomStandard(String roomStandard) {
//        this.roomStandard = roomStandard;
//    }
//
//    public Float getPoolArea() {
//        return poolArea;
//    }
//
//    public void setPoolArea(Float poolArea) {
//        this.poolArea = poolArea;
//    }
//
//    public int getFloorNumber() {
//        return floorNumber;
//    }
//
//    public void setFloorNumber(int floorNumber) {
//        this.floorNumber = floorNumber;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + + '\'' +
//                "roomStandard='" + roomStandard + '\'' +
//                ", poolArea=" + poolArea +
//                ", floorNumber=" + floorNumber;
//    }
//    public  String writeToFile(){
//        return super.writeToFile() + ',' + roomStandard + ',' + poolArea + ',' + floorNumber;
//    }

}
