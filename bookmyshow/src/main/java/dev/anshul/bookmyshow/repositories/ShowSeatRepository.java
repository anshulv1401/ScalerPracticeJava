package dev.anshul.bookmyshow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.anshul.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    // some user has read 1,2
    // let's lock these 2 rows
    // anybody else won't be allowed to even read these 2 rows = Pessimistic locking

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT ss FROM ShowSeat ss WHERE ss.id IN :ids")
    List<ShowSeat> findAllShowSeatAndLock(List<Long> ids);
}
