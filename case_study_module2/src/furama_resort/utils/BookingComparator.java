package furama_resort.utils;

import furama_resort.models.Booking;

import java.util.Comparator;
import java.util.stream.Stream;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking b1, Booking b2) {
        int[] startDay1 = Stream.of(b1.getStartDay().split("/")).mapToInt(Integer::parseInt).toArray();
        

        int[] startDay2 = Stream.of(b2.getStartDay().split("/")).mapToInt(Integer::parseInt).toArray();
        
        if(compareDays(startDay1, startDay2)!=0) {
            return compareDays(startDay1, startDay2);
        }
        else{
            int[] endDay1 = Stream.of(b1.getEndDay().split("/")).mapToInt(Integer::parseInt).toArray();
            int[] endDay2 = Stream.of(b2.getEndDay().split("/")).mapToInt(Integer::parseInt).toArray();
            return compareDays(endDay1, endDay2);
        }
    }

    public int compareDays(int[] day1, int[] day2) {
        if (day1[2] == day2[2]) {
            if (day1[1] == day2[1]) {
                return day1[0] - day2[0];
            } else return day1[1] - day2[1];
        }
        else return day1[2] - day2[2];
    }
}