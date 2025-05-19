package dev.anshul.bookmyshow.models;

import dev.anshul.bookmyshow.models.emuns.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private Long price;
    private ShowSeatStatus showSeatStatus;
}
