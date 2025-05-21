package dev.anshul.bookmyshow.dtos;

import dev.anshul.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Booking ticket;
    private ResponseStatus responseStatus;
}
