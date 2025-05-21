package dev.anshul.bookmyshow.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import dev.anshul.bookmyshow.exceptions.ShowNotFound;
import dev.anshul.bookmyshow.exceptions.ShowSeatNotAvailable;
import dev.anshul.bookmyshow.exceptions.ShowSeatNotValid;
import dev.anshul.bookmyshow.exceptions.UserNotFound;
import dev.anshul.bookmyshow.models.Booking;
import dev.anshul.bookmyshow.models.ShowSeat;
import dev.anshul.bookmyshow.models.emuns.BookingStatus;
import dev.anshul.bookmyshow.models.emuns.ShowSeatStatus;
import dev.anshul.bookmyshow.repositories.ShowRepository;
import dev.anshul.bookmyshow.repositories.ShowSeatRepository;
import dev.anshul.bookmyshow.repositories.UserRepository;

@Service

// @Transactional(isolation = Isolation.SERIALIZABLE) // allowed here
public class BookingService {

    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private PriceCalulationService priceCalulationService;
    // private Lock lock;

    public BookingService(UserRepository userRepository,
            ShowSeatRepository showSeatRepository,
            ShowRepository showRepository,
            PriceCalulationService priceCalulationService) {
        super();
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalulationService = priceCalulationService;
        // this.lock = new ReentrantLock();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(Long userId, Long showId, List<Long> showSeatsIds) {

        var userOps = userRepository.findById(userId);
        if (userOps.isEmpty())
            throw new UserNotFound("User is not valid");

        var showOps = showRepository.findById(showId);
        if (showOps.isEmpty())
            throw new ShowNotFound("Show is not valid");

        var user = userOps.get();

        var showSeatList = showSeatRepository.findAllShowSeatAndLock(showSeatsIds);
        if (showSeatList.size() != showSeatsIds.size())
            throw new ShowSeatNotValid("Invalid show seat id");

        for (var showSeat : showSeatList) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new ShowSeatNotAvailable("Some seats are no longer available");
        }

        // Booking status is pending, after payment booking will be confirmed

        var booking = new Booking();
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setNumber("Booking_" + userId + " Show_" + showId);

        // Isolation level (RC, RU, RR, Serializable)
        // Block the seats
        // lock.lock();

        // Re-valided in the lock
        showSeatList = showSeatRepository.findAllById(showSeatsIds);
        for (var showSeat : showSeatList) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                throw new ShowSeatNotAvailable("Some seats are no longer available");
        }

        for (ShowSeat showSeat : showSeatList) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }
        showSeatRepository.saveAll(showSeatList);

        // lock.unlock();

        booking.setShowSeats(showSeatList);
        booking.setAmount(priceCalulationService.calculatePrice(showSeatList));

        // Start payment. 3rd party payment gateway
        // Assume payment is confirmed
        booking.setBookingStatus(BookingStatus.CONFIRMED);

        for (ShowSeat showSeat : showSeatList) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
        }
        showSeatRepository.saveAll(showSeatList);

        // If payment failed = rollback with booking status = FAILED

        // unlock the showSeat rows - one line change

        return booking;
    }
}
