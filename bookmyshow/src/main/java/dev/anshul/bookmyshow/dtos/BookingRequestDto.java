package dev.anshul.bookmyshow.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDto {
    private long userId;
    private List<Long> showSeatsIds;
    private Long showId;
}
