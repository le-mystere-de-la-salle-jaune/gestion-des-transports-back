package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.Collaborateur;

public interface CollaborateurRepo extends JpaRepository<Collaborateur, Long> {

	@Query("select cb from Collaborateur cb where cb.email = :email")
	Optional<Collaborateur> findByEmail(@Param("email") String email);

	@Query("select cb from Collaborateur cb where cb.matricule = :matricule")
	Optional<Collaborateur> findByMatricule(@Param("matricule") String matricule);

	@Query("select cb from Collaborateur cb where cb.roles = :role")
	Optional<List<Collaborateur>> findByRole(@Param("role") String role);
}
