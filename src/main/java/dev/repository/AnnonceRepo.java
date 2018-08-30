package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.Annonce;

public interface AnnonceRepo extends JpaRepository<Annonce, Long>{

	
	@Query("select ann from Annonce ann, Collaborateur colab where colab.email = :email")
	Optional<List<Annonce>> findAllbyEmail(@Param("email") String email);
	
}

