package dev.anshul.bookmyshow.models;

import dev.anshul.bookmyshow.models.emuns.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String number;
    private SeatType seatType;
}
