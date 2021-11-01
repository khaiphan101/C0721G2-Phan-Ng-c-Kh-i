package furama_resort.utils;

import furama_resort.models.Facility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RegexFacility {

    static Scanner sc = new Scanner(System.in);
    public static String regexFaci(String temp, String regex){
        boolean flag = true;
        do{
            if(temp.matches(regex)){
                flag = false;
            }else{
                System.err.println("Fail input, please input again:");
                temp = sc.nextLine();
            }
        }while (flag);
        return temp;
    }
//        public static boolean checkFacility(String string) throws WrongFormatException{
//            boolean checks = string.matches(FACILITI_FORMAT);
//            if (!checks){
//                throw new WrongFormatException("fail input");
//            }
//            return checks;
//        }
//
//        public static boolean checkName(String name) throws WrongFormatException{
//            boolean b = name.matches(NAME_FORMAT);
//            if (!b){
//                throw new WrongFormatException("fail service name");
//            }
//            return b;
//        }
//        public static boolean checkArea(Float area)throws WrongFormatException{
//            if (area > 30)
//                return true;
//            else throw new WrongFormatException("fail area facility format");
//        }
//        public static boolean checkNumberOfPeople(int people)throws WrongFormatException{
//            if (people >0 && people <20 )
//                return true;
//            else throw new WrongFormatException("fail input of people Facility");
//        }
//        public static boolean checkFloor(int floor) throws WrongFormatException {
//            if (floor > 0) {
//                return true;
//            } else {
//                throw new WrongFormatException("Fail input floor");
//            }
//        }
//        public static boolean checkRentalCost(Float rentalCost) throws WrongFormatException {
//            if (rentalCost > 0) {
//                return true;
//            } else {
//                throw new WrongFormatException("Fail rental cost");
//            }
//        }
}
