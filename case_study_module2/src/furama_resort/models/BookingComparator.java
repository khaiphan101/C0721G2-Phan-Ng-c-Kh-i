package furama_resort.models;

import java.util.Comparator;

public class BookingComparator implements Comparator {
    @Override
    public int compareTo(Booking booking) {
        if(this.getStartDay() == booking.getStartDay()){
            return (this.getEndDay() < booking.getEndDay()) ? 1 : -1;
        }
        return (this.getStartDay() < booking.getStartDay()) ? 1 : -1;
//        return this.getStartDay().compareTo(booking.getStartDay());
    }
}
