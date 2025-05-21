package dev.anshul.bookmyshow.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.anshul.bookmyshow.dtos.BookingRequestDto;
import dev.anshul.bookmyshow.dtos.BookingResponseDto;
import dev.anshul.bookmyshow.dtos.ResponseStatus;
import dev.anshul.bookmyshow.services.BookingService;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        super();
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public BookingResponseDto bookTicket(@RequestBody BookingRequestDto request) {

        var response = new BookingResponseDto();
        try {
            var booking = bookingService.bookTicket(request.getUserId(), request.getShowId(),
                    request.getShowSeatsIds());
            response.setTicket(booking);
            response.setResponseStatus(ResponseStatus.SUCCESS);
            return response;

        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }
    }
}
