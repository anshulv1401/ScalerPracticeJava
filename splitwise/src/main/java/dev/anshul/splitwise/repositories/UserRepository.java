package dev.anshul.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.anshul.splitwise.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
