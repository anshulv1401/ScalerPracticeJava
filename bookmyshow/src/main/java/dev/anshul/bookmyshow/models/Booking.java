package dev.anshul.bookmyshow.models;

import java.util.List;

import dev.anshul.bookmyshow.models.emuns.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Booking extends BaseModel {
    private String number;
    private BookingStatus bookingStatus;
    private User user;
    private List<ShowSeat> showSeats;
    private List<Payment> payments;
    private Long amount;
}
