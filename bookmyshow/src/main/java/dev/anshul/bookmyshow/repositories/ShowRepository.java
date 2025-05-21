package dev.anshul.bookmyshow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.anshul.bookmyshow.models.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

}
