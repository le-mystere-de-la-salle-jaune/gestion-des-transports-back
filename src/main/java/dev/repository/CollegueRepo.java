package dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.Collegue;

public interface CollegueRepo extends JpaRepository<Collegue, Long> {

	@Query("select cb from Collaborateur cb where cb.email = :email")
    Optional<Collegue> findByEmail(@Param("email") String email);
}
