package furama_resort.utils;

public class RegexFacility {
        protected static final String FACILITI_FORMAT = "^SV(VL|RO|HO)-\\\\d{4}$";
        private static final String NAME_FORMAT = "^[A-Z][a-z]+\\s?([a-z]+\\s)*\\w+$";

        public static boolean checkFacility(String string) throws WrongFormatException{
            boolean checks = string.matches(FACILITI_FORMAT);
            if (!checks){
                throw new WrongFormatException("fail input");
            }
            return checks;
        }

        public static boolean checkName(String name) throws WrongFormatException{
            boolean b = name.matches(NAME_FORMAT);
            if (!b){
                throw new WrongFormatException("fail name facility");
            }
            return b;
        }
        public static boolean checkArea(Float area)throws WrongFormatException{
            if (area > 30)
                return true;
            else throw new WrongFormatException("fail area facility format");
        }
        public static boolean checkNumberOfPeople(int people)throws WrongFormatException{
            if (people >0 && people <=20 )
                return true;
            else throw new WrongFormatException("fail input of people Facility");
        }
        public static boolean checkFloor(int floor) throws WrongFormatException {
            if (floor > 0) {
                return true;
            } else {
                throw new WrongFormatException("Fail input floor");
            }
        }
        public static boolean checkRentalCost(Float rentalCost) throws WrongFormatException {
            if (rentalCost > 0) {
                return true;
            } else {
                throw new WrongFormatException("Fail rental cost");
            }
        }
}
