package dev.anshul.bookmyshow.models;

import dev.anshul.bookmyshow.models.emuns.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;
    private Long price;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
