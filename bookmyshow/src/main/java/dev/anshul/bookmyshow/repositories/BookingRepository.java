package dev.anshul.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.anshul.bookmyshow.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
