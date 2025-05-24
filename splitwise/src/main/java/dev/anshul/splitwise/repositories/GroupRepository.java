package dev.anshul.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.anshul.splitwise.models.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
