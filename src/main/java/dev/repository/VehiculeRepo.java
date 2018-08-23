package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.Vehicule;

public interface VehiculeRepo extends JpaRepository<Vehicule, Long> {

	@Query("select vh from Vehicule vh where vh.societe = true")
	List<Vehicule> listerSociete();
}
