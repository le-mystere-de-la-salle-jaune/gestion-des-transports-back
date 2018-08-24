package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.ReserverCovoiturageParticulier;

public interface ReserverCovoiturageParticulierRepo extends JpaRepository<ReserverCovoiturageParticulier, Long>{
	
}
