package dev.anshul.bookmyshow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.anshul.bookmyshow.models.ShowSeat;

@Service
public class PriceCalulationService {

    public Long calculatePrice(List<ShowSeat> showSeats) {
        Long amount = 0L;

        for (ShowSeat showSeat : showSeats) {
            amount += showSeat.getPrice();
        }

        return amount;
    }
}
