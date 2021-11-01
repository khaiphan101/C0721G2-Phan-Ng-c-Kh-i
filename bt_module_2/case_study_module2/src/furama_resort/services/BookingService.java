package furama_resort.services;

import furama_resort.models.Booking;

import java.util.TreeSet;

public interface BookingService extends Service{
    TreeSet<Booking> readFile(String filePath);
    void writeFile(Booking booking, String filePath);
}
